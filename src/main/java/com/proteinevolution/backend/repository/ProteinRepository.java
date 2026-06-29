package com.proteinevolution.backend.repository;


import com.proteinevolution.backend.model.Protein;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProteinRepository
        extends JpaRepository<Protein, Long> {


}