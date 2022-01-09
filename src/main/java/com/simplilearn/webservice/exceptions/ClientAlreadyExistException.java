package com.simplilearn.webservice.exceptions;

public class ClientAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public ClientAlreadyExistException(String message) {
		super(message);
	}
}
