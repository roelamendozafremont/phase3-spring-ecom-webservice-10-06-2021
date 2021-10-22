package com.simplilearn.webservice.exceptions;

public class InvalidCustomerException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidCustomerException(String message) {
		super(message);
	}
}
