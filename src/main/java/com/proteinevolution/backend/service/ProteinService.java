package com.proteinevolution.backend.service;


import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.model.ProteinAnalysis;
import com.proteinevolution.backend.repository.ProteinAnalysisRepository;

import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ProteinService {


    private final ProteinAnalysisRepository repository;



    public ProteinService(
            ProteinAnalysisRepository repository
    ){

        this.repository = repository;

    }



    public List<ProteinResponse> getProteins(){


        return repository.findAll()

                .stream()

                .map(protein ->

                        new ProteinResponse(

                                protein.getProteinId(),

                                protein.getLength(),

                                protein.getMolecularWeight(),

                                protein.getPI(),

                                protein.getHydrophobicity()

                        )

                )

                .toList();

    }




    public ProteinAnalysis save(
            ProteinAnalysis protein
    ){

        return repository.save(
                protein
        );

    }


}