package com.project.dmcapp.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
<<<<<<< HEAD:Back End/dmcapp/src/main/java/com/project/dmcapp/entities/DiagnosticCentre.java
@Table(name = "centre_table")
=======
@Table(name = "diagnosticcentre_table")
>>>>>>> 30c9b67a438523f75d14b5e0945f81cd6bcf1148:Back End/dmcapp/src/main/java/com/project/dmcapp/entities/Diagnosticcentre.java
public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int centreId ;
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

	@ManyToMany
	private int serviceId;
	
}
