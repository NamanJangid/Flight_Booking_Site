package com.flight.exception;

/**
 * 
 * ScheduleException is exception handler class for schedule service exceptions.
 * 
 * @author Naman
 *
 */
public class ScheduleException extends RuntimeException {

	public ScheduleException() {
		super();
	}

	public ScheduleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ScheduleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScheduleException(String message) {
		super(message);
	}

	public ScheduleException(Throwable cause) {
		super(cause);
	}

}
