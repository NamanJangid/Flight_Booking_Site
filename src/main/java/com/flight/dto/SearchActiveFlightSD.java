package com.flight.dto;

import com.flight.enumerate.FlightStatus;

public class SearchActiveFlightSD extends SearchFlightSD {

	private FlightStatus status;

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

}
