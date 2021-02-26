package com.project.dmcapp.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.dmcapp.model.BookAppointment;



public interface BookAppointmentRepo extends JpaRepository<BookAppointment, Integer>{

	
	
	
	//view appointment status

	@Query("Select patientId FROM BookAppointment b WHERE b.patientId=:patientId ")
	//@Query(value="select* from Request_table Inner Join patient_table on patient_table.pId = Request_table.patientId AND Request_table.status ='Yes' ", nativeQuery = true)
	public List<BookAppointment> getAppointmentStatusPatient(int patientId);



	@Query(value="select * from Request_table Inner Join patient_table on patient_table.patientId = Request_table.patientId AND Request_table.docId :doctorId",nativeQuery = true)
	//@Query(value="select* from Request_table Inner Join patient_table on patient_table.pId = Request_table.patientId AND Request_table.status ='Yes' ", nativeQuery = true)
	public BookAppointment getAppointmentStatusDoctor( Integer doctorId);
	
	
	//view patient  details who has booked for appointment (display in doctor dashboard based on his id )
		@Query("Select b FROM BookAppointment b WHERE b.doctorId =:doctorId")
	    public List<BookAppointment> getallpatientId(Integer doctorId);
		
	//agent can see his commission based on the request he raised	
		@Query("Select b FROM BookAppointment b WHERE b.agentId =:agentId")
		public  List<BookAppointment>getviewCommission(int agentId);
		
		
		
}
//select* from Request_table Inner Join patient_table on 
//patient_table.pId = Request_table.pId AND Request_table.status =Yes