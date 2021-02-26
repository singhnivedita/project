package com.project.dmcapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Movie already exists in your fav. Adding Movie to Fav Unsuccessfull.")
public class ServiceAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceAlreadyExistsException() {
		super("Service already exists");
	}

}
