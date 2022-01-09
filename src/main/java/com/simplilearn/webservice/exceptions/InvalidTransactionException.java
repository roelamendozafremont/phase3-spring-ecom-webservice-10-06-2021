package com.simplilearn.webservice.exceptions;

public class InvalidTransactionException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidTransactionException(String message) {
		super(message);
	}
}
