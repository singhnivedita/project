package com.project.dmcapp.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "diagnosticcentre_table")
public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int dcId ;
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



	
}
