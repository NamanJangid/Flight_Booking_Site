package com.flight.dto;

import java.time.LocalDate;

/**
 * ScheduledReturnFlight is the dto class for user's return trip flight search.
 * 
 * @author Naman
 *
 */

public class ScheduledReturnFlight {

	private LocalDate travelDate;
	private LocalDate returnDate;
	private String source;
	private String destination;
	
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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
