package com.project.dmcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.entities.DiagnosticService;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;

@Service 
public class PatientService {
	
	@Autowired
	PatientRepo pateintrepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	public List<DiagnosticService> getDiagnosticService(){
		return diagnosisServiceRepo.findAll();
	}
}
