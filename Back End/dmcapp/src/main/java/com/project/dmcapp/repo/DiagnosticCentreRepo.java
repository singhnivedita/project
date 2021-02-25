package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.model.DiagnosticCentre;

public interface DiagnosticCentreRepo extends JpaRepository < DiagnosticCentre, Integer> {
    
}
