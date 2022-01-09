package com.simplilearn.webservice.exceptions;

public class InvalidClientException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public InvalidClientException(String message) {
		super(message);
	}
}
