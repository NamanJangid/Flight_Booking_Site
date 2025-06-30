package com.flight.dto;

import java.time.LocalDateTime;

public class Invoice {
	
	private int flightNo;
	private LocalDateTime departureTime;
	
	
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	

}

