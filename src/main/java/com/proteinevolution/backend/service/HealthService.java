package com.proteinevolution.backend.service;


import com.proteinevolution.backend.dto.HealthResponse;

import org.springframework.stereotype.Service;



@Service
public class HealthService {


    public HealthResponse getStatus(){


        return new HealthResponse(

                "Protein Evolution Explorer",

                "running",

                "1.0"

        );

    }


}