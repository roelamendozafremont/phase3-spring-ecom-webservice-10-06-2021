package com.simplilearn.webservice.exceptions;

public class SavingAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public SavingAlreadyExistException(String message) {
		super(message);
	}
}
