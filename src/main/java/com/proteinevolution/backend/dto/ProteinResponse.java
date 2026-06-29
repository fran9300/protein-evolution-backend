package com.proteinevolution.backend.dto;


public record ProteinResponse(

        String id,

        int length,

        double molecularWeight,

        double pI,

        double hydrophobicity

) {}
