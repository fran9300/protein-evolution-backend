package com.proteinevolution.backend.model;


import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "protein_analysis")
@Getter
public class ProteinAnalysis {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;



    private String proteinId;


    private Integer length;


    private Double molecularWeight;


    private Double pI;


    private Double hydrophobicity;


    private Double instabilityIndex;


    private Double aliphaticIndex;



    public ProteinAnalysis(){}



    public ProteinAnalysis(
            String proteinId,
            Integer length,
            Double molecularWeight,
            Double pI,
            Double hydrophobicity,
            Double instabilityIndex,
            Double aliphaticIndex
    ){

        this.proteinId = proteinId;
        this.length = length;
        this.molecularWeight = molecularWeight;
        this.pI = pI;
        this.hydrophobicity = hydrophobicity;
        this.instabilityIndex = instabilityIndex;
        this.aliphaticIndex = aliphaticIndex;

    }


}