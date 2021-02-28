package com.project.dmcapp.controller;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.service.PatientService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;



public class PatientControllerTest {
	
	@InjectMocks
	PatientController patientController;
	
    @Mock
    private PatientService patientService;
	
	@Test
    void PatientLoginTest()
    {
    	AuthRequestUser user = new AuthRequestUser(5,"mohan@123"); 
    	AuthResponseUser authResponseUser = new AuthResponseUser(5,"Mohan","Srivastav","Patient","jwt-token");
    	when(patientService.loginPatient(user)).thenReturn(authResponseUser);
    	assertEquals(new ResponseEntity<AuthResponseUser>(authResponseUser, HttpStatus.OK),patientController.patientLogin(user));
    }
}
