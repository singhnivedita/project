package com.project.dmcapp.entities;


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
@Table(name = "UpdateTreatment_table")
public class UpdateTreatment {
	
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName = "pId")
    private Patient patientId;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "docId")
    private Doctor doctorId;
		
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosticServiceId", referencedColumnName = "dgsId")
    private DiagnosticService diagnosticService;
	

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
	
	//	@NotNull
	//	private String referal;
	

}
