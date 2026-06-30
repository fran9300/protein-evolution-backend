package com.proteinevolution.backend.controller;


import com.proteinevolution.backend.dto.ProteinAnalysisDetailResponse;
import com.proteinevolution.backend.dto.ProteinAnalysisResponse;
import com.proteinevolution.backend.dto.ProteinResponse;
import com.proteinevolution.backend.service.ProteinAnalysisService;
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



    private final ProteinService proteinService;

    private final ProteinAnalysisService analysisService;



    public ProteinController(

            ProteinService proteinService,

            ProteinAnalysisService analysisService

    ){

        this.proteinService = proteinService;

        this.analysisService = analysisService;

    }




    @Operation(
            summary = "Get analyzed proteins"
    )
    @GetMapping
    public List<ProteinResponse> getProteins(){


        return proteinService.getProteins();

    }


    @Operation(
            summary = "Get protein analysis by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProteinAnalysisDetailResponse> getById(

            @PathVariable Long id

    ) throws Exception {


        return ResponseEntity.ok(

                proteinService.getDetail(id)

        );

    }




    @Operation(
            summary = "Analyze a protein FASTA file"
    )
    @PostMapping(
            value = "/analyze",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ProteinAnalysisResponse> analyze(


            @RequestParam("file") MultipartFile file


    ) throws Exception {



        ProteinAnalysisResponse response =

                analysisService.analyze(file);



        return ResponseEntity.ok(

                response

        );

    }


}