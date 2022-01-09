package com.simplilearn.webservice.exceptions;

public class SavingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public SavingNotFoundException(String message) {
		super(message);
	}
}
