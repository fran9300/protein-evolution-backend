package com.proteinevolution.backend.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class Protein {


    private final String id;

    private final int length;

    private final double molecularWeight;

    private final double pI;

    private final double hydrophobicity;


}
