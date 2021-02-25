package com.project.dmcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;

@Service 
public class PatientService {
	
	@Autowired
	PatientRepo pateintrepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	@Autowired
	BookAppointmentRepo bookAppointmentRepo;
	
	
//	//to get all the service list/ details for patient
	public List<DiagnosticService> getDiagnosticService(){
		return diagnosisServiceRepo.findAll();
	}
	
	//to get appointment status of patient all the appointment
	public List<BookAppointment> getAppointmentStatusPatient(int id){
		return bookAppointmentRepo.getAppointmentStatus(id);
	}
	
	
	//to book new appointments
	public String bookAppointment(BookAppointment bookAptmnt){
		bookAppointmentRepo.save(bookAptmnt);
		
		return "Appointment Booked";
		
	}
	
	
	
	
	
}
