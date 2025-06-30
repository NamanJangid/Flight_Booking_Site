package com.flight.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Naman
 * 
 * 		SeatId is a Entity class which creates a composite primary key which is used in Seat table
 *
 */

@Embeddable
public class SeatId implements Serializable{
	
	@Column(name = "seat_no")
	private String seatNo;
	
	@ManyToOne
	@JoinColumn(name = "flight_no")
	private Flight flight;

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
