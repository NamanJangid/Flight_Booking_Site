package com.flight.dto;

import java.util.List;

import com.flight.entity.Passenger;

/**
 * 
 * @author Naman
 * 
 * 		This is the helper class for adding passengers 
 * 		along with selected seats
 * 
 *
 */

public class PassengerBookings {
	
	private List<Passenger> passengers;
	private List<String> selectedSeats;
	private int flightNo;
	private int noOfPassengers;
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public List<String> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<String> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

}
