package com.project.dmcapp.repo;

import org.springframework.data.repository.CrudRepository;
import com.project.dmcapp.entities.DiagnosticCentre;

public interface DiagnosticcentreRepo extends CrudRepository < DiagnosticCentre, Integer> {
    
}
