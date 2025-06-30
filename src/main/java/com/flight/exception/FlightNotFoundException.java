package com.flight.exception;

/**
 * 
 * @author Naman
 *
 *         common Exception class for flight not found
 */

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException(String message) {
		super(message);

	}
}
