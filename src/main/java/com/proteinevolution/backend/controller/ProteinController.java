package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.service.ProteinService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Tag(
        name = "Proteins",
        description = "Protein analysis operations"
)
@RestController
@RequestMapping("/api/proteins")
public class ProteinController {



    private final ProteinService proteinService;



    public ProteinController(
            ProteinService proteinService
    ){

        this.proteinService = proteinService;

    }


    @Operation(
            summary = "Get analyzed proteins"
    )
    @GetMapping
    public List<ProteinResponse> getProteins(){

        return proteinService.getProteins();

    }


}