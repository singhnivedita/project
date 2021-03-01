package com.project.dmcapp.model;



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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor 
@AllArgsConstructor
@Data
@Entity

@Table(name = "centre_table")

public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer centreId ;
	@NotNull
	private String brief;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String email;
	@NotNull
	private String website;
	@NotNull
	private String contactno;
	@NotNull
	private int zip;
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
     name = "Centre_Service", 
     joinColumns =  {@JoinColumn(name = "centreId")} , 
     inverseJoinColumns =  {@JoinColumn(name = "serviceId")} 
  )
	
	//@ManyToMany
    //@JoinColumn(name = "diagnosticServiceId", referencedColumnName = "dgsId")
    private List<DiagnosticService> diagnosticServiceList = new ArrayList<>();
	//Set<DiagnosticService> diagnosticServiceList = new HashSet<>();
	

	//I feel the below serviceId is not required as we are doing the many to many mapping between centre and service
	//of course yes :)
//	@NotNull
//	private int serviceId;

//	@ManyToMany(cascade = CascadeType.ALL )
//    @JoinTable(
//     name = "Centre_Service", 
//     joinColumns =  {@JoinColumn(name = "centreId")} , 
//     inverseJoinColumns =  {@JoinColumn(name = "serviceId")} 
//  )
//	
//	//@ManyToMany
//    //@JoinColumn(name = "diagnosticServiceId", referencedColumnName = "dgsId")
//    private List<DiagnosticService> diagnosticServiceList = new ArrayList<>();
	///Set<DiagnosticService> diagnosticServiceList = new HashSet<>();//old same  by set instead of list----->

	
}
