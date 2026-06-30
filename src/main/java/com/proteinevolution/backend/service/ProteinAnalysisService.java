package com.proteinevolution.backend.service;


import com.proteinevolution.backend.client.PythonAnalyzerClient;
import com.proteinevolution.backend.dto.ProteinAnalysisResponse;
import com.proteinevolution.backend.model.ProteinAnalysis;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class ProteinAnalysisService {



    private final PythonAnalyzerClient analyzerClient;

    private final ProteinService proteinService;




    public ProteinAnalysisService(

            PythonAnalyzerClient analyzerClient,

            ProteinService proteinService

    ){

        this.analyzerClient = analyzerClient;

        this.proteinService = proteinService;

    }





    public ProteinAnalysisResponse analyze(

            MultipartFile file

    ) throws Exception {



        // Llamada al microservicio Python

        ProteinAnalysisResponse response =

                analyzerClient.analyze(file);



        // Convertir DTO -> Entity

        ProteinAnalysis analysis =

                new ProteinAnalysis(

                        response.protein().proteinId(),

                        response.protein().length(),

                        response.protein().molecularWeight(),

                        response.protein().pI(),

                        response.protein().hydrophobicity(),

                        response.protein().instabilityIndex(),

                        response.protein().aliphaticIndex()

                );



        // Guardar en PostgreSQL

        proteinService.save(
                analysis
        );



        return response;

    }



}