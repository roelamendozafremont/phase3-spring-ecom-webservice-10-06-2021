package com.simplilearn.webservice.exceptions;

public class InvalidSavingException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidSavingException(String message) {
		super(message);
	}
}
