package com.flight.dto;

/**
 * 
 * BookedPassenger is the dto class for fetching the details of already booked passenger.
 * 
 * @author Naman
 *
 */
public class BookedPassenger {

	private int passengerId;
	private String name;
	
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
