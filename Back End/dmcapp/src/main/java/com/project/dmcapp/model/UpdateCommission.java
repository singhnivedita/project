package com.project.dmcapp.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "commission_table")
public class UpdateCommission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer commissionId;
	@NotNull
	private Integer baselineValue;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosticServiceId", referencedColumnName = "serviceId")
    private DiagnosticService diagnosticService;
	
	
	
	
}
