package com.project.dmcapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "patient_table")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int pid;
	
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	@NotNull
	private Date dob;
	@NotNull
	private String gender;
	@NotNull
	private long contactNumber;
	@NotNull
	private String password;
	@NotNull
	private String address;
	
	
}
