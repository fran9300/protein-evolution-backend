package com.proteinevolution.backend.dto;


public record ProteinResponse(

        String proteinId,

        int length,

        double molecularWeight,

        double pI,

        double hydrophobicity

) {}
