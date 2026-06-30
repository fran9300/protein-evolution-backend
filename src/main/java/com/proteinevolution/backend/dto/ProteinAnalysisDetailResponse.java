package com.proteinevolution.backend.dto;


import java.time.LocalDateTime;
import java.util.Map;


public record ProteinAnalysisDetailResponse(


        Long id,

        String proteinId,

        Integer length,

        Double molecularWeight,

        Double pI,

        Double hydrophobicity,

        Double instabilityIndex,

        Double aliphaticIndex,

        Map<String,Integer> composition,

        Structure structure,

        LocalDateTime createdAt


){


    public record Structure(

            double alphaHelix,

            double turn,

            double betaSheet

    ){}


}