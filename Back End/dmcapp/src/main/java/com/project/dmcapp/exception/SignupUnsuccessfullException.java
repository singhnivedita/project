package com.project.dmcapp.exception;

public class SignupUnsuccessfullException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SignupUnsuccessfullException() {
		super("Signup unsuccessfull. Please try again.");
	}
}

