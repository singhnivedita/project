package com.project.dmcapp.exception;

public class CommissionforServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CommissionforServiceNotFoundException() {
		super("Commission for Service already exists");
	}
}

