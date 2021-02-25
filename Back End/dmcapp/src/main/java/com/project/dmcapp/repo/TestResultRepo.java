package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.TestResult;

public interface TestResultRepo extends JpaRepository <TestResult, Integer>{
	//display all test results according to patient id 
		//(view patient itself on the basis of id of patient)
			@Query("Select * FROM TestResult t WHERE t.patientId=:patientId")
		    public List<TestResult> getallTestPatient(int patientId);
			
			
			//display all test results according to patient id 
			//(view patient itself on the basis of id of patient)	
			@Query("Select * FROM TestResult t InnerJoin BookAppointment b on t.patientId=b.patientId AND b.docId =: doctorId ")
		    public List<TestResult> getallTestDoctor(int doctorId);
}
