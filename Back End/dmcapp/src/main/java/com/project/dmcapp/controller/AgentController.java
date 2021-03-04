package com.project.dmcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.exception.BookingNotFoundException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.ReviewQuestion;
import com.project.dmcapp.model.TechnicalIssue;
import com.project.dmcapp.repo.TechnicaIssueRepo;
import com.project.dmcapp.repo.UpdateCommissionRepo;
import com.project.dmcapp.service.AgentService;
@CrossOrigin
@RestController
@RequestMapping("/agent")
public class AgentController {
	
	
	@Autowired
	AgentService agentService;
	
	
	@Autowired
	UpdateCommissionRepo updateCommissionRepo;
	@Autowired
	TechnicaIssueRepo technicalIssueRepo;
	
	//Agent Login
		@PostMapping("/login")
		public ResponseEntity<AuthResponseUser> agentLogin(@RequestBody AuthRequestUser user) {
			// TODO Auto-generated method stub
			return new ResponseEntity<AuthResponseUser>(agentService.agentLogin(user),HttpStatus.OK);
		}
	
	
		
		@PostMapping("/report-issue")
		public ResponseEntity<Msg> addReviewQuestion(@RequestBody TechnicalIssue technicalIssue) {
			
			technicalIssueRepo.save(technicalIssue);
			return ResponseEntity.ok().body(new Msg("Technical Issue reported successfully.", HttpStatus.ACCEPTED));
		}
	
	//view diagnostic services
		@GetMapping("/diagnostic-service")
		public ResponseEntity<List<DiagnosticService>> getAllDiagnosticService(){
			
			return new ResponseEntity<>(agentService.getDiagnosticService(), HttpStatus.OK);
		}
		
	//for new booking
		@PostMapping("/booking")
		public ResponseEntity<Msg> appointmentBooking(@RequestBody BookAppointment bookAppointment) {
			
			agentService.bookAppointment(bookAppointment);
			
			return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Booking successfully"));
		}
		
		//view commission
		
		@GetMapping("/commission/{id}")
		public int getCommission(@PathVariable("id") Integer aId) {
			
			return updateCommissionRepo.findCommissionValue(aId);
			
		}
		
		//appointment status booked by agent
		
		
		@GetMapping("/status/{id}")
		public ResponseEntity<List<BookAppointment>> getAppointmentStatus(@PathVariable("id") int aId) {
			List<BookAppointment> bookAppointments = agentService.getAppointmentStatusAgent(aId);
			/////////log.info("appointments size"+bookAppointments.size());
			if(bookAppointments == null)
				throw new BookingNotFoundException();
			
			return new ResponseEntity<>(bookAppointments, HttpStatus.OK);
		}
		
		
		
		
}
