package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.flight.enumerate.SeatClass;
import com.flight.enumerate.SeatStatus;

/**
 * 
 *  
 * @author Naman
 * 
 * 		Seat class entity is used to create a Seat table 
 * 		which stores the details of the seats in the flight
 *
 */

@Entity
@Table(name = "seat")
public class Seat {

	@EmbeddedId
	private SeatId seatId;
	
	@Column(name = "seat_class")
	@Enumerated(EnumType.STRING)
	private SeatClass seatClass;

	@Column(name = "seat_fare")
	private double fare;
	
	public SeatId getSeatId() {
		return seatId;
	}

	public void setSeatId(SeatId seatId) {
		this.seatId = seatId;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
