package com.project.dmcapp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "request_table")
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
	@Value("Yes")
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
	@ManyToOne
    @JoinColumn(name = "agentId", referencedColumnName = "agentId")
    private Agent agentId;
	

}
