package com.project.dmcapp.exception;

public class BookingNotFoundException extends RuntimeException {
	
		private static final long serialVersionUID = 1L;

		public BookingNotFoundException() {
			super("No Booking has been made as of now by this patient");
		}
	

}
