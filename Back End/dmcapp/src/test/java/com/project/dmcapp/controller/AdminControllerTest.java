	package com.project.dmcapp.controller;


	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;

	import com.project.dmcapp.dto.AuthRequestUser;
	import com.project.dmcapp.dto.AuthResponseUser;
	import com.project.dmcapp.service.AdminService;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.mockito.Mockito.when;

	public class AdminControllerTest {
		@InjectMocks
		AdminController adminController;
		
	    @Mock
	    private AdminService adminService;
		
		@Test
	    void AdminLoginTest()
	    {
	    	AuthRequestUser user = new AuthRequestUser(5,"handsome@123"); 
	    	AuthResponseUser authResponseUser = new AuthResponseUser(5,"Rocky","Abraham","Admin","jwt-token");
	    	when(adminService.loginAdmin(user)).thenReturn(authResponseUser);
	    	assertEquals(new ResponseEntity<AuthResponseUser>(authResponseUser, HttpStatus.OK),adminController.adminLogin(user));
	    
	    }
	}
