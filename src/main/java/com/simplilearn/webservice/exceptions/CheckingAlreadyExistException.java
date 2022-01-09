package com.simplilearn.webservice.exceptions;

public class CheckingAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public CheckingAlreadyExistException(String message) {
		super(message);
	}
}
