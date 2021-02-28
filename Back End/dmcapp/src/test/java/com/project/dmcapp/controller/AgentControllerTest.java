package com.project.dmcapp.controller;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.service.AgentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class AgentControllerTest {
	@InjectMocks
	AgentController agentController;
	
    @Mock
    private AgentService agentService;
	
	@Test
    void AgentLoginTest()
    {
    	AuthRequestUser user = new AuthRequestUser(6,"handsome@1234"); 
    	AuthResponseUser authResponseUser = new AuthResponseUser(6,"John","Handsome","Agent","jwt-token");
    	when(agentService.agentLogin(user)).thenReturn(authResponseUser);
    	assertEquals(new ResponseEntity<AuthResponseUser>(authResponseUser, HttpStatus.OK),agentController.agentLogin(user));
    }
}