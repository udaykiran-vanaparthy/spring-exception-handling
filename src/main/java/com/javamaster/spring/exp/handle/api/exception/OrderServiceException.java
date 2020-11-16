package com.javamaster.spring.exp.handle.api.exception;



/**
 * @author thatsuday
 * This class is used for throwing the exception.
 *
 */
public class OrderServiceException extends Exception {

	private static final long serialVersionUID = 23L;

	public OrderServiceException(String message) {
		super(message);
		
	}

}
