package com.project.dmcapp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dmcapp.exception.CommissionforServiceNotFoundException;

import com.project.dmcapp.exception.ServiceAlreadyExistsException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.model.Agent;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.repo.AgentRepo;
import com.project.dmcapp.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	AgentRepo agentRepo;
	
	//add a service
	@PutMapping("/{centreId}/{serviceId}")
	public ResponseEntity<Msg> addService(@PathVariable("centreId") int centreId, @PathVariable("serviceId") int serviceId) {
		boolean addStatus = adminService.addService(centreId,serviceId);
		
		if(!addStatus)
			throw new ServiceAlreadyExistsException();
		
		return ResponseEntity.ok().body(new Msg("Service added to your centre successfully.", HttpStatus.ACCEPTED));
	}
	
	//update service details
	@PutMapping("/modify-service") 
	  public ResponseEntity<?> modifyService(@RequestBody DiagnosticService diagnosticService)
	  {
		  return new ResponseEntity<>(adminService.modifyService(diagnosticService),HttpStatus.OK); 
		  
	  }
	
	//update testresult
	@PutMapping("/update-test-result")
	public ResponseEntity<Msg> updateTestResult(@RequestBody TestResult testResult) {
		boolean updateStatus = adminService.updateTestResult(testResult);
	
		if(updateStatus == false)
			throw new TestResultNotFoundException();
	
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Test result updated successfully"));
      }
	
	//update commission table
	@PutMapping("/{serviceId}/{baselinevalue}")
	public ResponseEntity<Msg> modifyCommissionTable(@PathVariable("serviceId") int serviceId, @PathVariable("baselinevalue") int baselinevalue) {
		boolean updateStatus = adminService.modifyCommissionTable(serviceId,baselinevalue);
	
		if(updateStatus == false)
			throw new CommissionforServiceNotFoundException();
	
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Baseline value updated successfully"));
      }
	
	//add agent
	@PutMapping("/create-agent")
	public ResponseEntity<Msg> addService(@RequestBody Agent agent) {
		
		agentRepo.save(agent);
		return ResponseEntity.ok().body(new Msg("Service added to your centre successfully.", HttpStatus.ACCEPTED));
	}

}
