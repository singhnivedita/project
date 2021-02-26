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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

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
	private int patientId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Date dob;
	@NotNull
	private String gender;
	@NotNull
	@Column(length = 10)
	@Pattern(regexp = "^[0-9]+$")
	private String contactNumber;
	@NotNull
	@Size(min = 6, max = 15)
	private String password;
	@NotNull
	private String address;
	
	//foreign key of role(id) table to specify role
	@ManyToOne
	@JoinColumn(name = "roleId", referencedColumnName = "roleId")
	private Role role;
}
