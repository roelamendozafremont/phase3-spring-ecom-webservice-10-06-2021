package com.simplilearn.webservice.exceptions;

public class InvalidAccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidAccountException(String message) {
		super(message);
	}
}
