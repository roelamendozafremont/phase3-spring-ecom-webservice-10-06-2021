package com.simplilearn.webservice.exceptions;

public class CartNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	String message;
	public CartNotFoundException(String message) {
		super(message);
	}
}
