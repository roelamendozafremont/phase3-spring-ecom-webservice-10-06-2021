package com.simplilearn.webservice.exceptions;

public class InvalidCheckingException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidCheckingException(String message) {
		super(message);
	}
}
