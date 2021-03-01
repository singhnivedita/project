package com.project.dmcapp.dto;

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

public class DiagnosticServiceDTO {
	
	
	private Integer serviceId ;
	
	private String serviceName;
	
	private int cost;
	
	private Time time;
	
	
	private String instruction;
	
	
	

	
   // @JoinColumn(name = "diagnosticCenterId", referencedColumnName = "dgcId")
    private List<DiagnosticCentreDTO> diagnosticCentre =new ArrayList<>();
	//private Set<DiagnosticCentre> diagnosticCentre = new HashSet<>();
	
}
