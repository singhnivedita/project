package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dmcapp.entities.DiagnosticCentre;

public interface DiagnosticCentreRepo extends JpaRepository < DiagnosticCentre, Integer> {
    
}
