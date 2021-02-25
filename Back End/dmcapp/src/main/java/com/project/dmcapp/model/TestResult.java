package com.project.dmcapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "testresult_table")
public class TestResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer testId;
	
	@NotNull
	private String testName;
	@NotNull
	private String testResult;
	
	//FK
	
	//foreign key of patient(id) table to specify tests of particular patient
	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "pId")
	private Patient patientId;
	
	//foreign key of service(id) table to specify tests of diagnostic service
	@ManyToOne
	@JoinColumn(name = "diagnosticServiceId", referencedColumnName = "serviceId")
	private DiagnosticService diagnosticServiceId;
}
