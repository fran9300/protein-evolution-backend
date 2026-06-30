package com.proteinevolution.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public record PythonAnalyzerResponse(

        ProteinSummary protein,

        Map<String,Integer> composition,

        Structure structure

) {


    public record ProteinSummary(

            @JsonProperty("protein_id")
            String proteinId,


            int length,


            @JsonProperty("molecular_weight")
            double molecularWeight,


            double pI,


            double hydrophobicity,


            @JsonProperty("instability_index")
            double instabilityIndex,


            @JsonProperty("aliphatic_index")
            double aliphaticIndex

    ){}



    public record Structure(

            double alphaHelix,

            double turn,

            double betaSheet

    ){}


}
