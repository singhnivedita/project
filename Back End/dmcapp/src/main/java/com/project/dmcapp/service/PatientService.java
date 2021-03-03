package com.project.dmcapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.dto.BookAppointmentDTO;
import com.project.dmcapp.dto.DiagnosticServiceDTO;
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
	// here we need to return dto so that the response is in one json object/whatever instead of nested.
		//same thing is implemented in the last method of this class but not working
		return diagnosisServiceRepo.findAll();
	}
	
	//to get appointment status of patient all the appointment
	public List<BookAppointment> getAppointmentStatusPatient(int id){
		
		return patientRepo.findById(id).get().getAppointments();
	}
	
	
	//to book new appointments
	public String bookAppointment(BookAppointmentDTO bookAptmntdto){
		
		BookAppointment bookAptmnt = new BookAppointment();
		bookAptmnt.setRequestId(bookAptmntdto.getRequestId());
		bookAptmnt.setRemark(bookAptmntdto.getRemark());
		bookAptmnt.setDate(bookAptmntdto.getDate());
		bookAptmnt.setTime(bookAptmntdto.getTime());
		bookAptmnt.setPatientId(bookAptmntdto.getPatientId());
		bookAptmnt.setDoctorId(bookAptmntdto.getDoctorId());
		bookAptmnt.setDiagnosticService(bookAptmntdto.getDiagnosticService());
		bookAptmnt.setAgentId(bookAptmntdto.getAgentId());
				
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
		
		/*
		 * @Transactional public List<DiagnosticServiceDTO> getDiagnosticServiceAll() {
		 * 
		 * Optional<List<DiagnosticService>> diagnosticService =
		 * Optional.of(diagnosisServiceRepo.findAll()); if
		 * (!diagnosticService.isPresent()) {
		 * 
		 * throw new UnauthorisedException();
		 * 
		 * }
		 * 
		 * List<DiagnosticService> diagnosticServices = diagnosticService.get();
		 * 
		 * 
		 * List<DiagnosticServiceDTO> diagnosticServicesdto = new ArrayList<>();
		 * diagnosticServicesdto.copy(diagnosticServices);
		 * 
		 * return diagnosticServicesdto;
		 * 
		 * }
		 */
	
	
}
