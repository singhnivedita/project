package com.project.dmcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.service.AgentService;

@RestController
@RequestMapping("/agent")
public class AgentController {
	
	
	@Autowired
	AgentService agentService;
	
	
	//Agent Login
	
	
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
		
}
