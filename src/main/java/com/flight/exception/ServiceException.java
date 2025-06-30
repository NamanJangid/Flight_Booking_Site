package com.flight.exception;

/**
 * 
 * @author Naman
 * 
 * 		This is the excep[tion class used while adding 
 * 		the seats in the flight
 *
 */

public class ServiceException extends RuntimeException {

	public ServiceException(String message) {
		super(message);
	}

}
