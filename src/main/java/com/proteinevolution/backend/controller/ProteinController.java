package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.service.ProteinService;


import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/proteins")
public class ProteinController {



    private final ProteinService proteinService;



    public ProteinController(
            ProteinService proteinService
    ){

        this.proteinService = proteinService;

    }



    @GetMapping
    public List<ProteinResponse> getProteins(){

        return proteinService.getProteins();

    }


}