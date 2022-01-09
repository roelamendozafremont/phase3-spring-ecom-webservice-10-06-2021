package com.simplilearn.webservice.exceptions;

public class TransactionAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public TransactionAlreadyExistException(String message) {
		super(message);
	}
}
