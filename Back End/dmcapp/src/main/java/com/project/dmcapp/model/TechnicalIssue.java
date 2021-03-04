package com.project.dmcapp.model;



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
//@Data
@Entity
@Table(name = "technicals_issues")
public class TechnicalIssue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int issueId;
	@NotNull
	private String issues;
	@NotNull
	private String description;
	@NotNull
	private String role;
	@NotNull
	private int yourId;

	
}
