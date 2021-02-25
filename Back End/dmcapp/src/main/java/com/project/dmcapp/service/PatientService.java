package com.project.dmcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
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
	PatientRepo pateintrepo;
	
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
		return bookAppointmentRepo.getAppointmentStatusPatient(id);
	}
	
	
	//to book new appointments
	public String bookAppointment(BookAppointment bookAptmnt){
		bookAppointmentRepo.save(bookAptmnt);
		
		return "Appointment Booked";
		
	}
	
	//view treatment history
	public List<UpdateTreatment> getTreatmentHistory(int id){
		return updateTreatmentRepo.getTreatmentHistory(id);
		
	}
	
	//view test result
	public List<TestResult> getallTestPatient(int pId) {
		// TODO Auto-generated method stub
		return testResultRepo.getallTestPatient(pId);
	}
	
	
	
	
}
