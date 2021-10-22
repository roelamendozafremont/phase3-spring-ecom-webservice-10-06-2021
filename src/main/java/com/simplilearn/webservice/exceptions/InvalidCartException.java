package com.simplilearn.webservice.exceptions;

public class InvalidCartException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidCartException(String message) {
		super(message);
	}
}
