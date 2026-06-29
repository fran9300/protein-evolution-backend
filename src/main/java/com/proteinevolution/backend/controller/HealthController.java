package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.dto.HealthResponse;
import com.proteinevolution.backend.service.HealthService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class HealthController {


    private final HealthService healthService;



    public HealthController(
            HealthService healthService
    ){

        this.healthService = healthService;

    }



    @GetMapping("/status")
    public HealthResponse status(){

        return healthService.getStatus();

    }

}