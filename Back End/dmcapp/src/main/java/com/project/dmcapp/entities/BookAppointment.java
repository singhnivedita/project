package com.project.dmcapp.entities;

import java.sql.Date;

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
@Table(name = "Request_table")
public class BookAppointment {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;
	
	@NotNull
	private Date date;
	@NotNull
	private Integer time;
	@NotNull
	private String remark;
	@NotNull
	private String status; 

	//change all primitive type to wrapper
	//foreign keys
	
	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "pId")
	private Patient patientId;
	
	@ManyToOne
	@JoinColumn(name = "docId", referencedColumnName = "docId")
	private Doctor doctorId;
	
	@ManyToOne
	@JoinColumn(name = "dgserviceId", referencedColumnName = "serviceId")
	private DiagnosticService diagnosticService;
	

}
