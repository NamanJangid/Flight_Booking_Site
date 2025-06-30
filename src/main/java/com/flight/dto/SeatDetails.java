package com.flight.dto;

/**
 * 
 * @author Naman
 *
 *		This is the helper class used  in allocating the seats
 *		for passengers
 */

public class SeatDetails {
	
	private String seatNo;
	private String seatClass;
	private double fare;
	
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
}
