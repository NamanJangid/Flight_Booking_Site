package com.flight.inventory;

import java.util.List;

import com.flight.dto.BookedSeat;

/**
 * 
 * @author Naman
 * 
 * 		This is the interface for SeatService
 *
 */

public interface SeatServiceInventory {

	public void addSeats(int flightNo);
	
	public List<String> getBookedSeats(BookedSeat bs);

	public double getSeatFare(int flightNo, String seatNo);
}
