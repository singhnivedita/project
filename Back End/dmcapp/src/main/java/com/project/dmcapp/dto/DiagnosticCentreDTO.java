package com.project.dmcapp.dto;



import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dmcapp.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor



public class DiagnosticCentreDTO {
	

	private Integer centreId ;
	
	private String brief;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String email;
	
	private String website;

	private String contactno;
	
	private int zip;
	
	
	
	//@ManyToMany
    //@JoinColumn(name = "diagnosticServiceId", referencedColumnName = "dgsId")
    private List<DiagnosticServiceDTO> diagnosticServiceList = new ArrayList<>();
	//Set<DiagnosticService> diagnosticServiceList = new HashSet<>();
	

	//I feel the below serviceId is not required as we are doing the many to many mapping between centre and service
	//of course yes :)
//	@NotNull
//	private int serviceId;


	
}
