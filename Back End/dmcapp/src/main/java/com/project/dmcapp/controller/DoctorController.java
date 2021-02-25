package com.project.dmcapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dmcapp.exception.DoctorAppointmentNotFoundException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	
	//view appointment details made by patient respect to doctor
		@GetMapping("/appointment/{id}")
		public ResponseEntity<List<BookAppointment>> getallpatientId(@PathVariable int docId) {
			List<BookAppointment> patientAppointmentDetails = doctorService.getallpatientId(docId);
			
			if(patientAppointmentDetails == null)
				throw new DoctorAppointmentNotFoundException();
			
			return new ResponseEntity<>(patientAppointmentDetails, HttpStatus.OK);
		}
		
		//doctor can update test results of the patient 
			@PutMapping("/update-test-result")
			public ResponseEntity<Msg> updateTestResult(@RequestBody TestResult testResult) {
				boolean updateStatus = doctorService.updateTestResult(testResult);
			
				if(updateStatus == false)
					throw new DoctorAppointmentNotFoundException();
			
				return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Test result updated successfully"));
		}
			
			
			
		//doctor can update treatment history of the patient (UpdateTreatment updateTreatment)
			@PutMapping("/update-treatment-history")
			public ResponseEntity<Msg> updateTreatmentHistory(@RequestBody UpdateTreatment updateTreatment) {
				boolean updateStatus = doctorService.updateTreatmentHistory(updateTreatment);
			
				if(updateStatus == false)
					throw new DoctorAppointmentNotFoundException();
			
				return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Tretment History updated successfully"));
		}
			
		
		//updateAppointmentStatus
}
