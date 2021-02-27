package com.project.dmcapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.exception.UnauthorisedException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Role;
import com.project.dmcapp.repo.AgentRepo;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateTreatmentRepo;
import com.project.dmcapp.model.Agent;

@Service
public class AgentService {
	
	@Autowired
	PatientRepo pateintRepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	@Autowired
	BookAppointmentRepo bookAppointmentRepo;
	
	@Autowired
	UpdateTreatmentRepo updateTreatmentRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	
	
	@Autowired
	AgentRepo agentRepo; 
	
	//login 
	//login
			@Transactional
			public AuthResponseUser agentLogin(AuthRequestUser user) {
				
				Optional<Agent> agentCheck = agentRepo.findByIdAndPassword(user.getUserId(),user.getPassword());
				if (!agentCheck.isPresent()) {
						
					throw new UnauthorisedException();
					
				}
					Agent agent = agentCheck.get();
					Role userRole = agentCheck.get().getRole();
					
					AuthResponseUser  authResponseUser = new AuthResponseUser(agent.getAgentId(),agent.getFirstName(),agent.getLastName(), userRole.getRoleName(), "jwt-token");
				
				return authResponseUser;
			}	
	//to get all the service list/ details for agents and patients
	public List<DiagnosticService> getDiagnosticService(){
		return diagnosisServiceRepo.findAll();
	}
	
	
	//view commission based on agent id and booking made by agent
	
	
	//book appointment by agent (we need to pass extra column agend it at the time of booking when its 
	//patient then the value of extra column should be null otherwise we have put value of agent id  
	public String bookAppointment(BookAppointment bookAptmnt){
		bookAppointmentRepo.save(bookAptmnt);
		
		return "Appointment Booked";
		
	}
	
}
