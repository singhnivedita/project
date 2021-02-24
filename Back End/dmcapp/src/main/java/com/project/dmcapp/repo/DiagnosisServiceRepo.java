package com.project.dmcapp.repo;

import com.project.dmcapp.entities.DiagnosticService;

import org.springframework.data.repository.CrudRepository;

public interface  DiagnosisServiceRepo extends CrudRepository< DiagnosticService, Integer> {
    
}
