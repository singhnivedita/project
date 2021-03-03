package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.DiagnosticCentre;
import com.project.dmcapp.model.DiagnosticService;

public interface  DiagnosticServiceRepo extends JpaRepository< DiagnosticService, Integer> {
    
	@Query("Select s from DiagnosticService s where serviceId=?1 ")
	List<DiagnosticService> findServiceById(int sId);
}
