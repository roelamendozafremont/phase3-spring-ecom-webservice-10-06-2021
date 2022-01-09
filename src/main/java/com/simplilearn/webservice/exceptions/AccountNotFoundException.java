package com.simplilearn.webservice.exceptions;

public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public AccountNotFoundException(String message) {
		super(message);
	}
}
