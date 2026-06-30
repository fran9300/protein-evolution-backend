package com.proteinevolution.backend.dto;


public record ProteinResponse(

        Long id,

        String proteinId,

        int length,

        double molecularWeight,

        double pI,

        double hydrophobicity

) {}
