package com.project.dmcapp.repo;

import com.project.dmcapp.entities.DiagnosticService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DiagnosisServiceRepo extends JpaRepository< DiagnosticService, Integer> {
    
}
