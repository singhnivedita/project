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
@Table(name = "UpdateTreatment_table")
public class UpdateTreatment {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;
	@NotNull
	private int patientId;
	@NotNull
	private int doctorId;
	@NotNull
	private int serviceId;
	@NotNull
	private String symptoms;
	@NotNull
	private String diagnosis;
	@NotNull
	private String recommendation;
	@NotNull
	private String diet;
	@NotNull
	private String referal;
	@NotNull
	private String prescription;

}
