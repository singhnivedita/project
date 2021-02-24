package com.project.dmcapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int testId;
	
	@NotNull
	private String testName;
	@NotNull
	private String testResult;
	
	//FK
	
	@NotNull
	private int pId;
	
	@NotNull
	private int serviceId;
}
