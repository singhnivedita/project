package com.project.dmcapp.model;


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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "updatetreatment_table")
public class UpdateTreatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer treatmentId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName = "pId")
    private Patient patientId;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "docId")
    private Doctor doctorId;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosticServiceId", referencedColumnName = "serviceId")
    private DiagnosticService diagnosticService;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testresultId", referencedColumnName = "testId")
    private TestResult testresultId;
		
	@NotNull
	private String symptoms;
	@NotNull
	private String diagnosis;
	@NotNull
	private String recommendation;
	@NotNull
	private String diet;

	@NotNull
	private String prescription;

	

}
