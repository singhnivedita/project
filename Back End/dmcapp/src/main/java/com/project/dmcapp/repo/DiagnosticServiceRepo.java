package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.model.DiagnosticService;

public interface  DiagnosticServiceRepo extends JpaRepository< DiagnosticService, Integer> {
    
}
