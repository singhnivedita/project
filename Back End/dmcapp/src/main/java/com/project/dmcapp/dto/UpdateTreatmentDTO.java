package com.project.dmcapp.dto;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Patient;
import com.project.dmcapp.model.TestResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor


public class UpdateTreatmentDTO {

	private Integer treatmentId;
	

    private Patient patientId;
		

    private Doctor doctorId;

    private DiagnosticService diagnosticServiceId;
	

    private TestResult testresultId;
		

	private String symptoms;
	
	private String diagnosis;
	
	private String recommendation;
	
	private String diet;

	
	private String prescription;

}
