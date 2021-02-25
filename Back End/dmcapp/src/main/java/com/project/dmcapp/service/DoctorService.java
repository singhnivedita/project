package com.project.dmcapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dmcapp.entities.TestResult;
import com.project.dmcapp.entities.UpdateTreatment;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateTreatmentRepo;

public class DoctorService {
	@Autowired
	PatientRepo pateintrepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	@Autowired
	BookAppointmentRepo bookAppointmentRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	@Autowired
	UpdateTreatmentRepo updateTreatmentRepo;
	
	
	//Update Test Result by doctor based on the patient id of the patient
	public boolean updateTestResult(TestResult testResult) {
		//log.info("START");
		
		TestResult testResultOld = testResultRepo.getallTestDoctor(testResult.getPatientId()).orElse(null);
		if(testResultOld == null)
			return false;
		
		testResultRepo.save(testResult);
		
		//log.info("END");
		return true;
	}
	
	
	//Update Test Result by doctor based on the patient id of the patient
		public boolean updateTreatmentHistory(UpdateTreatment updateTreatment) {
			//log.info("START");
			
			UpdateTreatment updateTreatmentOld = updateTreatmentRepo.getTreatmentHistory(updateTreatment.getPatientId()).orElse(null);
			
			if(updateTreatmentOld == null)
				return false;
			
			testResultRepo.save(updateTreatment);
			
			//log.info("END");
			
			return true;
		}
}
