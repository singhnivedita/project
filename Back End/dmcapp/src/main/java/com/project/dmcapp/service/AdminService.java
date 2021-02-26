package com.project.dmcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.model.DiagnosticCentre;
import com.project.dmcapp.model.DiagnosticService;

import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateCommission;
import com.project.dmcapp.repo.DiagnosticCentreRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;

import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateCommissionRepo;



@Service
public class AdminService {
	
	@Autowired
	DiagnosticCentreRepo diagnosticCentreRepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosticServiceRepo;
	
	@Autowired
	UpdateCommissionRepo updateCommissionRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	//add diagnostic service to the centre
	public boolean addService(int centreId, int serviceId) {
		DiagnosticCentre diagnosticCentre = diagnosticCentreRepo.findById(centreId).orElse(null);
		
		DiagnosticService diagnosticService = diagnosticServiceRepo.findById(serviceId).orElse(null);
		
		if(diagnosticCentre == null || diagnosticService == null)
			return false;
		
		diagnosticCentre.getDiagnosticServiceList().add(diagnosticService);
		
		diagnosticCentreRepo.save(diagnosticCentre);
		
		return true;
	}
	
	//modify diagnostic service details
	public boolean modifyService(DiagnosticService diagnosticService) {
		
		DiagnosticService diagnosticServiceold = diagnosticServiceRepo.findById(diagnosticService.getServiceId()).orElse(null);
		
		if(diagnosticServiceold == null)
			return false;
		
		diagnosticServiceRepo.save(diagnosticService);
		
		return true;
	}
	
	//add an agent

	//update test result
	public boolean updateTestResult(TestResult testResult) {
        //log.info("START");
      
       List<TestResult> testResultOld1 = testResultRepo.getallTestPatient(testResult.getPatientId().getPatientId());
        
        TestResult testResultOld2 = (TestResult) testResultOld1.stream().filter(p->p.getTestId().equals(testResult.getTestId()));
        if(testResultOld2 == null)
            return false;
        testResultRepo.save(testResult);
      
        //log.info("END");
        return true;
    }
	
	//update commission table
	public boolean modifyCommissionTable(int serviceId,UpdateCommission updateCommission) {
		
		UpdateCommission updateCommissionold = updateCommissionRepo.findCommissionByService(serviceId);
		
		if(updateCommissionold == null)
			return false;
		
		
		updateCommissionRepo.save(updateCommission);
		return true;
	}
	
	
	

}
