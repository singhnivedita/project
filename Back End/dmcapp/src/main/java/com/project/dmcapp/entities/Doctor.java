package com.project.dmcapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "doctor_table")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int docId;
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	@NotNull
	private Date dob;
	@NotNull
	private String gender;
	@NotNull
	@Size(min = 10, max = 10)
	private long contactNumber;
	@NotNull
	@Size(min = 6, max = 15)
	private String password;
	@NotNull
	private String address;
	@NotNull
	private String qualification;
	@NotNull
	private String speciality;
	
}
