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
import com.project.dmcapp.dto.TestResultDTO;
import com.project.dmcapp.dto.UpdateTreatmentDTO;
import com.project.dmcapp.exception.DoctorAppointmentNotFoundException;
import com.project.dmcapp.exception.TestResultNotFoundException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Msg;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.repo.DoctorRepo;
import com.project.dmcapp.service.DoctorService;




@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	//get all doctor
	@GetMapping("/all-doctors")
	public ResponseEntity<List<Doctor>> getallDoctor(){
		
		return new ResponseEntity<>(doctorRepo.findAll(), HttpStatus.OK);
	}
	//Docotr Registration
	
			@PostMapping("/registration")
			public ResponseEntity<Msg> doctorRegistration(@RequestBody Doctor doctorData) {
				
				doctorService.doctorRegistration(doctorData);
				
				return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Registration successfully"));
			}
			
			
			//Doctor login
			@PostMapping("/login")
			public ResponseEntity<AuthResponseUser> doctorLogin(@RequestBody AuthRequestUser user) {
				// TODO Auto-generated method stub
				return new ResponseEntity<AuthResponseUser>(doctorService.loginDoctor(user),HttpStatus.OK);
			}
	
	
	//view appointment details made by patient respect to doctor
		@GetMapping("/appointment/{id}")
		public ResponseEntity<List<BookAppointment>> getallpatientId(@PathVariable("id") int docId) {
			List<BookAppointment> patientAppointmentDetails = doctorService.getallpatientId(docId);
			
			if(patientAppointmentDetails == null)
				throw new DoctorAppointmentNotFoundException();
			
			return new ResponseEntity<>(patientAppointmentDetails, HttpStatus.OK);
		}
		
		//view treatment history of patient under particular doctor
		@GetMapping("/treatment-history/{id}")
		public ResponseEntity<List<UpdateTreatment>> getallpatientHistory(@PathVariable("id") int docId) {
			List<UpdateTreatment> treatmentHistory = doctorService.treatmentHistory(docId);
			
			if(treatmentHistory == null)
				throw new DoctorAppointmentNotFoundException();
			
			return new ResponseEntity<>(treatmentHistory, HttpStatus.OK);
		}
		
		//doctor can update test results of the patient 
			@PutMapping("/update-test-result")
			public ResponseEntity<Msg> updateTestResult(@RequestBody TestResultDTO testResultdto) {
				boolean updateStatus = doctorService.updateTestResult(testResultdto);
			
				if(updateStatus == false)
					throw new DoctorAppointmentNotFoundException();
			
				return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Test result updated successfully"));
		}
			
			
			
		//doctor can update treatment history of the patient (UpdateTreatment updateTreatment)
			@PutMapping("/update-treatment-history")
			public ResponseEntity<Msg> updateTreatmentHistory(@RequestBody UpdateTreatmentDTO updateTreatmentdto) {
				boolean updateStatus = doctorService.updateTreatmentHistory(updateTreatmentdto);
			
				if(updateStatus == false)
					throw new DoctorAppointmentNotFoundException();
			
				return ResponseEntity.ok().body(new Msg(HttpStatus.ACCEPTED, LocalDateTime.now(), "Tretment History updated successfully"));
		}
			
		

			
			
			
			//updateAppointmentStatus
			@GetMapping("/approve/{appointmentId}")
			public ResponseEntity<String> approveAppointment(@PathVariable int appointmentId) {
				return new ResponseEntity<>(doctorService.approveAppointment(appointmentId), HttpStatus.OK);
			}

			@GetMapping("/reject/{appointmentId}")
			public ResponseEntity<String> rejectAppointment(@PathVariable int appointmentId) {
				return new ResponseEntity<>(doctorService.rejectAppointment(appointmentId), HttpStatus.OK);

			}
}
