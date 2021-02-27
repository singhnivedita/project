package com.project.dmcapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthResponseUser {

	private int userId;
	private String firstname;
	private String lastname;
	private String role;
	private String token;
	
}
