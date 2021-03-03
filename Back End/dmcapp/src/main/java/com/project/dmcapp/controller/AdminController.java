package com.project.dmcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.exception.CommissionforServiceNotFoundException;

import com.project.dmcapp.exception.ServiceNotFoundException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.model.Agent;
import com.project.dmcapp.model.DiagnosticCentre;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateCommission;
import com.project.dmcapp.repo.AgentRepo;
import com.project.dmcapp.repo.DiagnosticCentreRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.service.AdminService;
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService ;
	
	@Autowired
	private AgentRepo agentRepo;
	
	@Autowired
	DiagnosticCentreRepo diagnosticCentreRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	//Admin Login
		@PostMapping("/login")
		public ResponseEntity<AuthResponseUser> adminLogin(@RequestBody AuthRequestUser user) {
			// TODO Auto-generated method stub
			return new ResponseEntity<AuthResponseUser>(adminService.loginAdmin(user),HttpStatus.OK);
		}
	
		
		//show centre
		@GetMapping("/diagnostic-centre")
		public ResponseEntity<List<DiagnosticCentre>> getAllDiagnosticService(){
			
			return new ResponseEntity<>(diagnosticCentreRepo.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/all-test")
		public ResponseEntity<List<TestResult>> getAllTestResults(){
			
			return new ResponseEntity<>(testResultRepo.findAll(), HttpStatus.OK);
		}
		
	//add a service
	@PutMapping("add-service/{centreId}/{serviceId}")
	public ResponseEntity<Msg> addService(@PathVariable("centreId") int centreId, @PathVariable("serviceId") int serviceId) {
		boolean addStatus = adminService.addService(centreId,serviceId);
		
		if(!addStatus)
			throw new ServiceNotFoundException();
		
		return ResponseEntity.ok().body(new Msg("Service added to your centre successfully.", HttpStatus.ACCEPTED));
	}
	
	//update service details
	@PutMapping("/modify-centre") 
	  public ResponseEntity<?> modifyService(@RequestBody DiagnosticCentre diagnosticCentre)
	  {
		  return new ResponseEntity<>(adminService.modifyCentre(diagnosticCentre),HttpStatus.OK); 
		  
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
	@PutMapping("update-commission/{serviceId}")
	public ResponseEntity<Msg> modifyCommissionTable(@PathVariable("serviceId") int serviceId,@RequestBody UpdateCommission updateCommission) {
		boolean updateStatus = adminService.modifyCommissionTable(serviceId,updateCommission );
	
		if(updateStatus == false)
			throw new CommissionforServiceNotFoundException();
	
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Baseline value updated successfully"));
      }
	
	//add agent
	@PostMapping("/create-agent")
	public ResponseEntity<Msg> addService(@RequestBody Agent agent) {
		
		agentRepo.save(agent);
		return ResponseEntity.ok().body(new Msg("Agent added to your centre successfully.", HttpStatus.ACCEPTED));
	}

}
