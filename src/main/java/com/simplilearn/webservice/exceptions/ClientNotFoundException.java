package com.simplilearn.webservice.exceptions;

public class ClientNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public ClientNotFoundException(String message) {
		super(message);
	}
}
