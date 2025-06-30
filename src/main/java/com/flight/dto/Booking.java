package com.flight.dto;

/**
 * Booking is the data transfer object class for making reservation and generating TicketNo.
 * 
 * @author Naman
 *
 */

public class Booking {

	private int userId;
	private int flightNo;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

}
