package com.proteinevolution.backend.service;


import com.proteinevolution.backend.dto.ProteinResponse;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProteinService {



    public List<ProteinResponse> getProteins(){


        return List.of(
                // simulo datos por ahora
                new ProteinResponse(
                        "P04637",
                        393,
                        43652.71,
                        6.33,
                        -0.756
                )

        );


    }


}