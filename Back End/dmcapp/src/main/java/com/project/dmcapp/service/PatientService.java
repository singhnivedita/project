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
import com.project.dmcapp.model.Patient;
import com.project.dmcapp.model.Role;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateTreatmentRepo;

@Service 
public class PatientService {
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	@Autowired
	BookAppointmentRepo bookAppointmentRepo;
	
	@Autowired
	UpdateTreatmentRepo updateTreatmentRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	
//	//to get all the service list/ details for patient
	public List<DiagnosticService> getDiagnosticService(){
		return diagnosisServiceRepo.findAll();
	}
	
	//to get appointment status of patient all the appointment
	public List<BookAppointment> getAppointmentStatusPatient(int id){
		
		return patientRepo.findById(id).get().getAppointments();
	}
	
	
	//to book new appointments
	public String bookAppointment(BookAppointment bookAptmnt){
		bookAppointmentRepo.save(bookAptmnt);
		
		return "Appointment Booked";
		
	}
	
	
	//view treatment history
	public UpdateTreatment getTreatmentHistory(int id){
		return updateTreatmentRepo.getTreatmentHistory(id);
		
	}
	
	//view test result
	public List<TestResult> getallTestPatient(int patientId) {
		// TODO Auto-generated method stub
		return testResultRepo.getallTestPatient(patientId);
	}

	public String registerUser(Patient patient) {
		// TODO Auto-generated method stub
		patientRepo.save(patient);
		return "User Registered Successfully";
		
	}
	
	//login
		@Transactional
		public AuthResponseUser loginPatient(AuthRequestUser user) {
			
			Optional<Patient> patientCheck = patientRepo.findByIdAndPassword(user.getUserId(),user.getPassword());
			if (!patientCheck.isPresent()) {
					
				throw new UnauthorisedException();
				
			}
			
				Patient patient = patientCheck.get();
				Role userRole = patientCheck.get().getRole();
				
				AuthResponseUser  authResponseUser = new AuthResponseUser(patient.getPatientId(),patient.getFirstName(),patient.getLastName(), userRole.getRoleName(), "jwt-token");
			
			return authResponseUser;

		}
	
	
}
