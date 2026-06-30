package com.proteinevolution.backend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public record ProteinAnalysisResponse(


        ProteinSummary protein,


        Map<String,Integer> composition,


        Structure structure


) {



    public record ProteinSummary(

            @JsonProperty("protein_id")
            String protein_id,

            int length,

            @JsonProperty("molecular_weight")
            double molecular_weight,

            double pI,

            double hydrophobicity,

            @JsonProperty("instability_index")
            double instability_index,

            @JsonProperty("aliphatic_index")
            double aliphatic_index

    ){}



    public record Structure(

            double alphaHelix,

            double turn,

            double betaSheet

    ){}


}