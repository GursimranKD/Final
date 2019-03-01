package com.infy.ekart.exceptions;

@SuppressWarnings("serial")

public class UserNotAllowedException extends Exception{
	public UserNotAllowedException(String message) {
		super(message);
	}

}
