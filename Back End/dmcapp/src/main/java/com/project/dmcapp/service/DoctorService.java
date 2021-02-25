package com.project.dmcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.PatientRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateTreatmentRepo;

@Service
public class DoctorService {
	@Autowired
	PatientRepo pateintRepo;
	
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
      
       List<TestResult> testResultOld1 = testResultRepo.getallTestPatient(testResult.getPatientId().getPId());
        if(testResultOld1 == null)
            return false;
        TestResult testResultOld2 = (TestResult) testResultOld1.stream().filter(p->p.getTestId().equals(testResult.getTestId()));
        testResultRepo.save(testResult);
      
        //log.info("END");
        return true;
    }
	
	
	//Update medical record by doctor based on the patient id of the patient
		public boolean updateTreatmentHistory(UpdateTreatment updateTreatment) {
			//log.info("START");
			
			UpdateTreatment updateTreatmentOld = updateTreatmentRepo.getTreatmentHistory(updateTreatment.getPatientId().getPId());
			
			if(updateTreatmentOld == null)
				return false;
			
			updateTreatmentRepo.save(updateTreatment);
			//log.info("END");
			
			return true;
		}
		
		
		//updateAppointmentStatus
		
		
		
		//treatment history - doctor
		public List<BookAppointment> getallpatientId(int doctorId){
			return bookAppointmentRepo.getallpatientId(doctorId);
		}
		
}
