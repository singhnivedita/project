package com.project.dmcapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Movie already exists in your fav. Adding Movie to Fav Unsuccessfull.")
public class ServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceNotFoundException() {
		super("Service already exists");
	}

}
