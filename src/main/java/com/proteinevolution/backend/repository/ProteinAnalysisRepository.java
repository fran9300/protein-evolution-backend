package com.proteinevolution.backend.repository;


import com.proteinevolution.backend.model.ProteinAnalysis;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProteinAnalysisRepository
        extends JpaRepository<ProteinAnalysis, Long> {


}
