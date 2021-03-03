package com.project.dmcapp.dto;

import java.sql.Date;
import java.sql.Time;




import com.project.dmcapp.model.Agent;
import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

public class BookAppointmentDTO {
	
    private Integer requestId;
	
	
	private Date date;
	
	private Time time;
	
	private String remark;
	
	private boolean status; 

	//change all primitive type to wrapper
	//foreign keys
	
	

	private Patient patientId;
	

	private Doctor doctorId;
	
	
	private DiagnosticService diagnosticService;
	
	
	
	private Agent agentId;

	

}
