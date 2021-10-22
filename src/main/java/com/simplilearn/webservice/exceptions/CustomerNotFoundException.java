package com.simplilearn.webservice.exceptions;

public class CustomerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
