package com.simplilearn.webservice.exceptions;

public class AccountAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public AccountAlreadyExistException(String message) {
		super(message);
	}
}
