package com.flight.dto;

import com.flight.enumerate.FlightStatus;

/**
 * 
 * @author Naman
 *
 *         Helper class for deleting a flight
 */

public class DeleteFlight {

	private int id;
	private FlightStatus status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

}
