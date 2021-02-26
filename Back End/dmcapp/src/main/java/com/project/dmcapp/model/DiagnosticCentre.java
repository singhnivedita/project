package com.project.dmcapp.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int contactno;
	@NotNull
	private int zip;

	@NotNull
	private int serviceId;






	@ManyToMany(cascade = CascadeType.ALL, mappedBy="diagnosticCentre")
    //@JoinColumn(name = "diagnosticServiceId", referencedColumnName = "dgsId")
    private List<DiagnosticService> diagnosticServiceList;

	
}
