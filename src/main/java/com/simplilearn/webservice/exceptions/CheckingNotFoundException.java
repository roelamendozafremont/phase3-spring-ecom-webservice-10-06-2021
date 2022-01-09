package com.simplilearn.webservice.exceptions;

public class CheckingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public CheckingNotFoundException(String message) {
		super(message);
	}
}
