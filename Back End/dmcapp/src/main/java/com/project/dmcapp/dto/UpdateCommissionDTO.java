package com.project.dmcapp.dto;





import com.project.dmcapp.model.DiagnosticService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor


public class UpdateCommissionDTO {
	
	
	private Integer commissionId;
	
	private Integer baselineValue;

	
    
    private DiagnosticService diagnosticServiceId;
	
	
	
	
}
