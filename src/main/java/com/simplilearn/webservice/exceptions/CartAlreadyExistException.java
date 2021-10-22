package com.simplilearn.webservice.exceptions;

public class CartAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	
	public CartAlreadyExistException(String message) {
		super(message);
	}
}
