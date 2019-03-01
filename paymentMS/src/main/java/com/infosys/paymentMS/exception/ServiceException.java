package com.infosys.paymentMS.exception;


public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
		
	}
	
	public ServiceException(String e) {
		super(e);
		
	}
}