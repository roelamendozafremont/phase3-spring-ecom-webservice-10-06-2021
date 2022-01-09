package com.simplilearn.webservice.exceptions;

public class TransactionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public TransactionNotFoundException(String message) {
		super(message);
	}
}
