package com.proteinevolution.backend.service;


import com.proteinevolution.backend.dto.ProteinResponse;

import com.proteinevolution.backend.repository.ProteinRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProteinService {


    private final ProteinRepository repository;


    public ProteinService(
            ProteinRepository repository
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

}