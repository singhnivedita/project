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
import com.project.dmcapp.dto.DiagnosticServiceDTO;
import com.project.dmcapp.exception.BookingNotFoundException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.exception.TreatmentHistoryNotFoundException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.Patient;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.service.PatientService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	
	
	
	
	@Autowired
	PatientService patientService;
	
//	@GetMapping("/status")
//    public List<BookAppointment> getAppointmentStatus1(@PathVariable int pId) {
//        return patientService.getAppointmentStatusPatient(pId);
//    }
	
	
	//for new booking
	@PostMapping("/booking")
	public ResponseEntity<Msg> appointmentBooking(@RequestBody BookAppointment bookAppointment) {
		
		patientService.bookAppointment(bookAppointment);
		
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Booking successfully"));
	}
	
	//booking status of patient
	@GetMapping("/status/{id}")
	public ResponseEntity<List<BookAppointment>> getAppointmentStatus(@PathVariable("id") int pId) {
		List<BookAppointment> bookAppointments = patientService.getAppointmentStatusPatient(pId);
		log.info("appointments size"+bookAppointments.size());
		if(bookAppointments == null)
			throw new BookingNotFoundException();
		
		return new ResponseEntity<>(bookAppointments, HttpStatus.OK);
	}
	
	
	//view diagnostic services
	@GetMapping("/diagnostic-service")
	public ResponseEntity<List<DiagnosticService>> getAllDiagnosticService(){
		
		return new ResponseEntity<>(patientService.getDiagnosticService(), HttpStatus.OK);
	}


	//view treatment history
	@GetMapping("/treatment-history/{id}") 
	public ResponseEntity <UpdateTreatment> getTreatmentHistory(@PathVariable("id") int pId) {
		UpdateTreatment updateTreatment = patientService.getTreatmentHistory(pId);
		
		if(updateTreatment == null)
			throw new TreatmentHistoryNotFoundException();
		
		return new ResponseEntity<>(updateTreatment, HttpStatus.OK);
	}
	
	//view test result
	@GetMapping("/test-result/{id}")
	public ResponseEntity<List <TestResult>> getallTestPatient(@PathVariable("id") int patientId) {
		List<TestResult> testResult = patientService.getallTestPatient(patientId);
		
		if(testResult == null)
			throw new TestResultNotFoundException();
		
		return new ResponseEntity<>(testResult, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Msg> registerUser(@RequestBody Patient patient) {
		
		patientService.registerUser(patient);
		
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Registered successfully"));
	}
	//Patient Login
	@PostMapping("/login")
		public ResponseEntity<AuthResponseUser> patientLogin(@RequestBody AuthRequestUser user) {
			// TODO Auto-generated method stub
			return new ResponseEntity<AuthResponseUser>(patientService.loginPatient(user),HttpStatus.OK);
		}

}
