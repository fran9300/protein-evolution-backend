package com.proteinevolution.backend.service;


import com.proteinevolution.backend.client.PythonAnalyzerClient;
import com.proteinevolution.backend.dto.ProteinAnalysisResponse;
import com.proteinevolution.backend.dto.PythonAnalyzerResponse;
import com.proteinevolution.backend.model.ProteinAnalysis;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;


@Service
public class ProteinAnalysisService {



    private final PythonAnalyzerClient analyzerClient;

    private final ProteinService proteinService;

    private final ObjectMapper mapper;


    public ProteinAnalysisService(

            PythonAnalyzerClient analyzerClient,

            ProteinService proteinService,

            ObjectMapper mapper

    ){

        this.analyzerClient = analyzerClient;

        this.proteinService = proteinService;

        this.mapper = mapper;

    }





    public ProteinAnalysisResponse analyze(

            MultipartFile file

    ) throws Exception {



        // Llamada al microservicio Python

        PythonAnalyzerResponse pythonResponse  =

                analyzerClient.analyze(file);



        // Convertir DTO -> Entity

        ProteinAnalysis analysis =

                new ProteinAnalysis(

                        pythonResponse .protein().proteinId(),

                        pythonResponse .protein().length(),

                        pythonResponse .protein().molecularWeight(),

                        pythonResponse .protein().pI(),

                        pythonResponse .protein().hydrophobicity(),

                        pythonResponse .protein().instabilityIndex(),

                        pythonResponse .protein().aliphaticIndex(),

                        mapper.writeValueAsString(

                                pythonResponse .composition()

                        ),


                        mapper.writeValueAsString(

                                pythonResponse.structure()

                        )


                );



        // Guardar en PostgreSQL

        proteinService.saveAnalysis(
                analysis
        );



        return new ProteinAnalysisResponse(

                new ProteinAnalysisResponse.ProteinSummary(

                        pythonResponse.protein().proteinId(),

                        pythonResponse.protein().length(),

                        pythonResponse.protein().molecularWeight(),

                        pythonResponse.protein().pI(),

                        pythonResponse.protein().hydrophobicity(),

                        pythonResponse.protein().instabilityIndex(),

                        pythonResponse.protein().aliphaticIndex()

                ),

                pythonResponse.composition(),

                new ProteinAnalysisResponse.Structure(

                        pythonResponse.structure().alphaHelix(),

                        pythonResponse.structure().turn(),

                        pythonResponse.structure().betaSheet()

                )
        );

    }



}