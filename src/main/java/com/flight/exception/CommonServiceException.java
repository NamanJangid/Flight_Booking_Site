package com.flight.exception;

/**
 * 
 * @author Naman
 *
 *         common Exception class for login, register
 */

public class CommonServiceException extends RuntimeException {

	public CommonServiceException(String message) {
		super(message);
	}
}
