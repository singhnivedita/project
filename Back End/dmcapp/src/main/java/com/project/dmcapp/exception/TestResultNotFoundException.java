package com.project.dmcapp.exception;

public class TestResultNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TestResultNotFoundException() {
		super("No Test Result found");
	}


}
