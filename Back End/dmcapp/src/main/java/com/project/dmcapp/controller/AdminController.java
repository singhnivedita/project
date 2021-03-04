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
import com.project.dmcapp.dto.UpdateCommissionDTO;
import com.project.dmcapp.exception.CommissionforServiceNotFoundException;

import com.project.dmcapp.exception.ServiceNotFoundException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.model.Agent;
import com.project.dmcapp.model.DiagnosticCentre;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.ReviewQuestion;
import com.project.dmcapp.model.Role;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateCommission;
import com.project.dmcapp.repo.AgentRepo;
import com.project.dmcapp.repo.DiagnosticCentreRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.ReviewQuestionRepo;
import com.project.dmcapp.repo.RoleRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateCommissionRepo;
import com.project.dmcapp.service.AdminService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
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
	
	
	
	@Autowired
	ReviewQuestionRepo reviewQuestionRepo;
	
	
	@Autowired
	UpdateCommissionRepo updateCommissionRepo;
	
	
	
	@Autowired
	DiagnosticServiceRepo diagnosticServiceRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	//Admin Login
		@PostMapping("/login")
		public ResponseEntity<AuthResponseUser> adminLogin(@RequestBody AuthRequestUser user) {
			// TODO Auto-generated method stub
			return new ResponseEntity<AuthResponseUser>(adminService.loginAdmin(user),HttpStatus.OK);
		}
	
		
		//show centre all centres
		@GetMapping("/diagnostic-centre")
		public ResponseEntity<List<DiagnosticCentre>> getAllDiagnosticService(){
			
			return new ResponseEntity<>(diagnosticCentreRepo.findAll(), HttpStatus.OK);
		}
		//get all aacordig to test id
		@GetMapping("/all-test")
		public ResponseEntity<List<TestResult>> getAllTestResults(){
			
			return new ResponseEntity<>(testResultRepo.findAll(), HttpStatus.OK);
		}
		//view diagnostic centre according to centre id
		@GetMapping("/diagnostik-centre/{id}")
		public ResponseEntity<List<DiagnosticCentre>> getCentreById(@PathVariable("id") int cId){
			
			return new ResponseEntity<>(diagnosticCentreRepo.findCentreById(cId), HttpStatus.OK);
		}
		
		@GetMapping("/diagnostik-service/{id}")
		public ResponseEntity<List<DiagnosticService>> getServiceById(@PathVariable("id") int serviceId){
			
			return new ResponseEntity<>(diagnosticServiceRepo.findServiceById(serviceId), HttpStatus.OK);
		}
		//view all commission
		@GetMapping("/view-commission")
		public ResponseEntity<List<UpdateCommission>> getAllComm(){
			
			return new ResponseEntity<>(updateCommissionRepo.findAll(), HttpStatus.OK);
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
	public ResponseEntity<Msg> modifyCommissionTable(@PathVariable("serviceId") int serviceId, @RequestBody UpdateCommissionDTO updateCommissiondto) {
		boolean updateStatus = adminService.modifyCommissionTable(serviceId,updateCommissiondto);
		
	
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
	
	//get roles by role help us in registration
	@GetMapping("/roles/{id}")
	public ResponseEntity<List<Role>> getRoleById(@PathVariable("id") int rId){
		
		return new ResponseEntity<>(roleRepo.findRoleById(rId), HttpStatus.OK);
	}

	@PostMapping("/create-review-question")
	public ResponseEntity<Msg> addReviewQuestion(@RequestBody ReviewQuestion reviewQuestion) {
		
		reviewQuestionRepo.save(reviewQuestion);
		return ResponseEntity.ok().body(new Msg("Question added to the review questionarie successfully.", HttpStatus.ACCEPTED));
	}
	
}
