package com.project.dmcapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.dto.UpdateCommissionDTO;
import com.project.dmcapp.exception.UnauthorisedException;
import com.project.dmcapp.model.Admin;
import com.project.dmcapp.model.DiagnosticCentre;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Role;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateCommission;
import com.project.dmcapp.repo.AdminRepo;
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
	
	@Autowired
	AdminRepo adminRepo;
	
///////login
			@Transactional
			public AuthResponseUser loginAdmin(AuthRequestUser user) {
				
				Optional<Admin> adminCheck = adminRepo.findById(user.getUserId());
				if(!adminCheck.isPresent() || !(adminCheck.get().getPassword().equals(user.getPassword()))) {
						
					throw new UnauthorisedException();
					
				}
					Admin admin = adminCheck.get();
					Role userRole = adminCheck.get().getRole();
					
					AuthResponseUser  authResponseUser = new AuthResponseUser(admin.getAdminId(),admin.getFirstName(),admin.getLastName(), userRole.getRoleName(), "jwt-token");
				
				return authResponseUser;
			}	
	
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
	public boolean modifyCentre(DiagnosticCentre diagnosticCentre) {
		
		DiagnosticCentre diagnosticCentreold = diagnosticCentreRepo.findById(diagnosticCentre.getCentreId()).orElse(null);
		
		if(diagnosticCentreold == null)
			return false;
		
		diagnosticCentreRepo.save(diagnosticCentre);
		
		return true;
	}
	
	//add an agent

	//update test result
	public boolean updateTestResult(TestResult testResult) {
        //log.info("START");
      
       TestResult testResultOld = testResultRepo.findById(testResult.getTestId()).orElse(null);
        
        //TestResult testResultOld2 = (TestResult) testResultOld1.stream().filter(p->p.getTestId().equals(testResult.getTestId()));
        if(testResultOld == null)
            return false;
        testResultRepo.save(testResult);
      
        //log.info("END");
        return true;
    }
	
	//update commission table
    public boolean modifyCommissionTable(int serviceId,UpdateCommissionDTO updateCommissiondto) {
       
        UpdateCommission updateCommissionold = updateCommissionRepo.findCommissionByService(serviceId);
       
        if(updateCommissionold == null)
            return false;
        UpdateCommission updateCommission = new UpdateCommission();
        updateCommission.setCommissionId(updateCommissionold.getCommissionId());
        updateCommission.setBaselineValue(updateCommissiondto.getBaselineValue());
        updateCommission.setDiagnosticServiceId(updateCommissionold.getDiagnosticServiceId());
        updateCommissionRepo.save(updateCommission);
        return true;
    }
	
	
	

}
