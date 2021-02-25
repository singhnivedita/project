package com.project.dmcapp.exception;

public class DoctorAppointmentNotFoundException extends RuntimeException {
	public DoctorAppointmentNotFoundException() {
		super("No Booking has been made to you as of now by patients");
	}
}
