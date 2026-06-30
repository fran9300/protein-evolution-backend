package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.client.PythonAnalyzerClient;
import com.proteinevolution.backend.dto.ProteinAnalysisResponse;
import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.service.ProteinService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@Tag(
        name = "Proteins",
        description = "Protein analysis operations"
)
@RestController
@RequestMapping("/api/proteins")
public class ProteinController {

    private final PythonAnalyzerClient analyzerClient;

    private final ProteinService proteinService;



    public ProteinController(
            PythonAnalyzerClient analyzerClient, ProteinService proteinService
    ){
        this.analyzerClient = analyzerClient;

        this.proteinService = proteinService;

    }


    @Operation(
            summary = "Get analyzed proteins"
    )
    @GetMapping
    public List<ProteinResponse> getProteins(){

        return proteinService.getProteins();

    }



    @PostMapping(
            value = "/analyze",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ProteinAnalysisResponse> analyze(

            @RequestParam("file") MultipartFile file

    ) throws Exception {

        ProteinAnalysisResponse response =
                analyzerClient.analyze(file);


        return ResponseEntity.ok(response);

    }


}