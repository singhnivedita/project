package com.project.dmcapp.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;



@NoArgsConstructor 
@AllArgsConstructor
@Data
@Entity
@Table(name = "diagnosisService_table")
public class DiagnosisService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int dgId ;
	@NotNull
	private String dgName;
	@NotNull
	private int cost;
	@NotNull
	private Time time;
	@NotNull
	@Size(min = 10, max = 100)
	private String instructions;

	
}
