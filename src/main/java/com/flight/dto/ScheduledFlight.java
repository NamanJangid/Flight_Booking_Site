package com.flight.dto;

import java.time.LocalDate;

/**
 * ScheduledFlight is the dto class for getting the flight search data from frontend.
 * 
 * @author Naman
 *
 */

public class ScheduledFlight {

	private LocalDate travelDate;
	private String source;
	private String destination;
	
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
