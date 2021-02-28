package com.project.dmcapp.model;

import java.sql.Date;
import java.sql.Time;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
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
	private Time time;
	@NotNull
	private String remark;
	@NotNull
	@Value("Yes")
	private boolean status; 

	//change all primitive type to wrapper
	//foreign keys
	
	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "patientId")
	private Patient patientId;
	
	@ManyToOne
	@JoinColumn(name = "docId", referencedColumnName = "docId")
	private Doctor doctorId;
	
	@ManyToOne
	@JoinColumn(name = "dgserviceId", referencedColumnName = "serviceId")
	private DiagnosticService diagnosticService;
	
	@ManyToOne
	@JoinColumn(name = "agentId", referencedColumnName = "agentPk")
	
	private Agent agentId;

	

}
