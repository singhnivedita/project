package com.project.dmcapp.model;

import java.sql.Date;
import java.sql.Time;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor 
@AllArgsConstructor
@Data
@Entity
@Table(name = "service_table")
public class DiagnosticService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer serviceId ;
	@NotNull
	private String serviceName;
	@NotNull
	private int cost;
	@NotNull
	private Time time;
	
	@Size(min = 10, max = 100)
	private String instruction;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    @JoinTable(
     name = "Centre_Service", 
     joinColumns =  {@JoinColumn(name = "serviceId")} , 
     inverseJoinColumns =  {@JoinColumn(name = "centreId")} 
  )
   // @JoinColumn(name = "diagnosticCenterId", referencedColumnName = "dgcId")
    private List<DiagnosticCentre> diagnosticCentreList =new ArrayList<>();
	//private Set<DiagnosticCentre> diagnosticCentre = new HashSet<>();
	
}
