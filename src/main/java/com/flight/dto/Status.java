package com.flight.dto;

/**
 * 
 * Status class is a data transfer object class resembling the status of data transfer.
 * 
 * @author Naman
 *
 */

public class Status {

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
