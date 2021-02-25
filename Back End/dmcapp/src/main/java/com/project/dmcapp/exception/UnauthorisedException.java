package com.project.dmcapp.exception;

public class UnauthorisedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnauthorisedException() {
		super("Unauthorised");
	}
}