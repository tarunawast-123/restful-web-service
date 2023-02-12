package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
    
	private LocalDate timestmp;
	private String message;
	private  String details;
	
	public ErrorDetails(LocalDate timestmp, String message, String details) {
		super();
		this.timestmp = timestmp;
		this.message = message;
		this.details = details;
	}

	public LocalDate getTimestmp() {
		return timestmp;
	}


	public String getMessage() {
		return message;
	}


	public String getDetails() {
		return details;
	}

	
}
