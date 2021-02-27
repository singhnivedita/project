package com.project.dmcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	//Patient Registration
	
	
	
	//Patient Login
	
	
	//for new booking
	@PostMapping("/booking")
	public ResponseEntity<Msg> appointmentBooking(@RequestBody BookAppointment bookAppointment) {
		
		patientService.bookAppointment(bookAppointment);
		
		return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Booking successfully"));
	}
	
	//booking status of patient
	@GetMapping("/status/{id}")
	public ResponseEntity<List<BookAppointment>> getAppointmentStatus(@PathVariable int pId) {
		List<BookAppointment> bookAppointments = patientService.getAppointmentStatusPatient(pId);
		
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
	public ResponseEntity <UpdateTreatment> getTreatmentHistory(@PathVariable int pId) {
		UpdateTreatment updateTreatment = patientService.getTreatmentHistory(pId);
		
		if(updateTreatment == null)
			throw new TreatmentHistoryNotFoundException();
		
		return new ResponseEntity<>(updateTreatment, HttpStatus.OK);
	}
	
	//view test result
	@GetMapping("/test-result/{id}")
	public ResponseEntity<List <TestResult>> getallTestPatient(@PathVariable int pId) {
		List<TestResult> testResult = patientService.getallTestPatient(pId);
		
		if(testResult == null)
			throw new TestResultNotFoundException();
		
		return new ResponseEntity<>(testResult, HttpStatus.OK);
	}

}
