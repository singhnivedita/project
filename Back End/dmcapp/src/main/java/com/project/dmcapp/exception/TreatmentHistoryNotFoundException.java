package com.project.dmcapp.exception;

public class TreatmentHistoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TreatmentHistoryNotFoundException() {
		super("No Treatment history found");
	}


}
