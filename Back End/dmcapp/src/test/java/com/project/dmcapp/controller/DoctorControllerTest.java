package com.project.dmcapp.controller;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.service.DoctorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DoctorControllerTest {
	@InjectMocks
	DoctorController doctorController;
	
    @Mock
    private DoctorService doctorService;
	
	@Test
    void DoctorLoginTest()
    {
    	AuthRequestUser user = new AuthRequestUser(5,"johny@1234"); 
    	AuthResponseUser authResponseUser = new AuthResponseUser(5,"Johny","Abraham","Doctor","jwt-token");
    	when(doctorService.loginDoctor(user)).thenReturn(authResponseUser);
    	assertEquals(new ResponseEntity<AuthResponseUser>(authResponseUser, HttpStatus.OK),doctorController.doctorLogin(user));
    }
}