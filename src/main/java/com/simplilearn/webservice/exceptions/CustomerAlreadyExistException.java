package com.simplilearn.webservice.exceptions;

public class CustomerAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public CustomerAlreadyExistException(String message) {
		super(message);
	}
}
