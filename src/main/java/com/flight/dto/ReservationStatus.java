package com.flight.dto;

/**
 * ReservationStatus is the status dto class for Reservation status.
 * 
 * @author Naman
 *
 */

public class ReservationStatus extends Status {

	private int ticketNo;

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
}
