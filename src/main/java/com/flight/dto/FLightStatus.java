package com.flight.dto;

/**
 * 
 * @author Naman
 *
 *         Helper class for flight
 */

public class FLightStatus {

	private String message;
	private boolean status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
