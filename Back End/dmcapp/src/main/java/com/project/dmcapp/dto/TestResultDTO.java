package com.project.dmcapp.dto;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.project.dmcapp.model.DiagnosticService;
import com.project.dmcapp.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor


public class TestResultDTO {
	
	
	private Integer testId;
	
	
	private String testName;
	
	private String testResult;
	
	//FK
	
	
	private Patient patientId;
	

    private DiagnosticService diagnosticServiceId;
}
