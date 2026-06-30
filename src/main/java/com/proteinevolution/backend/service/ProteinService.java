package com.proteinevolution.backend.service;


import com.proteinevolution.backend.dto.ProteinAnalysisDetailResponse;
import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.model.ProteinAnalysis;
import com.proteinevolution.backend.repository.ProteinAnalysisRepository;


import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;


import java.util.List;
import java.util.Map;


@Service
public class ProteinService {


    private final ProteinAnalysisRepository repository;

    private final ObjectMapper mapper;



    public ProteinService(
            ProteinAnalysisRepository repository,
            ObjectMapper mapper
    ){

        this.repository = repository;
        this.mapper = mapper;

    }



    public List<ProteinResponse> getProteins(){


        return repository.findAll()

                .stream()

                .map(protein ->

                        new ProteinResponse(

                                protein.getId(),

                                protein.getProteinId(),

                                protein.getLength(),

                                protein.getMolecularWeight(),

                                protein.getPI(),

                                protein.getHydrophobicity()

                        )

                )

                .toList();

    }




    public ProteinAnalysis getById(Long id){


        return repository.findById(id)

                .orElseThrow(
                        () -> new RuntimeException(
                                "Protein analysis not found"
                        )
                );

    }




    public void saveAnalysis(
            ProteinAnalysis protein
    ){

        repository.save(
                protein
        );
    }


    public void deleteProtein(Long id){
        repository.deleteById(id);
    }


    public ProteinAnalysisDetailResponse getDetail(Long id)
            throws Exception {


        ProteinAnalysis protein = getById(id);



        return new ProteinAnalysisDetailResponse(


                protein.getId(),

                protein.getProteinId(),

                protein.getLength(),

                protein.getMolecularWeight(),

                protein.getPI(),

                protein.getHydrophobicity(),

                protein.getInstabilityIndex(),

                protein.getAliphaticIndex(),


                mapper.readValue(

                        protein.getComposition(),

                        Map.class

                ),


                mapper.readValue(

                        protein.getStructure(),

                        ProteinAnalysisDetailResponse.Structure.class

                ),


                protein.getCreatedAt()

        );

    }


}