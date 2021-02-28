package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.TestResult;

public interface TestResultRepo extends JpaRepository <TestResult, Integer>{
	//display all test results according to patient id 
		//(view patient itself on the basis of id of patient)
			@Query("Select t FROM TestResult t WHERE t.patientId.patientId=?1")
		    public List<TestResult> getallTestPatient(int patientId);
			
			
			//display all test results according to patient id 
			//(view patient itself on the basis of id of patient)	
			//@Query(value="select * from Request_table Inner Join patient_table on patient_table.pId = Request_table.patientId AND Request_table.docId :doctorId",nativeQuery = true)
			//@Query("Select t FROM TestResult t InnerJoin BookAppointment b on t.patientId=b.patientId AND b.doctorId =?1")
			@Query(value="select * from testresult_table Inner Join Request_table on testresult_table.patientId = Request_table.patientId AND Request_table.docId :doctorId",nativeQuery = true)
		    public List<TestResult> getallTestDoctor(int doctorId);
}
