package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.project.dmcapp.model.DiagnosticCentre;


public interface DiagnosticCentreRepo extends JpaRepository < DiagnosticCentre, Integer> {
	
    
	
	
	
	@Query("Select c from DiagnosticCentre c where centreId=?1 ")
	List<DiagnosticCentre> findCentreById(int cId);

	
}
