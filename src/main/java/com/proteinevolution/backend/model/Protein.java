package com.proteinevolution.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="proteins")
@Getter
@RequiredArgsConstructor
public class Protein {

    @Id
    @GeneratedValue
    private  String proteinId;

    private  int length;

    private  double molecularWeight;

    private  double pI;

    private  double hydrophobicity;


}
