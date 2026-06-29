package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.service.HealthService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
    public String status(){

        return healthService.getStatus();

    }

}