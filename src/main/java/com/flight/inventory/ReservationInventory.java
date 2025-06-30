package com.flight.inventory;

import java.util.List;

import com.flight.dto.BookedPassenger;
import com.flight.dto.Booking;

/**
 * 
 * ReservationInventory is the interface for ReservationService class.
 * 
 * @author Naman
 *
 */
public interface ReservationInventory {

	public int makeReservation(Booking booking);
	
	public List<BookedPassenger> fetchAllPassengerByTicketNo(int ticketNo);
	
	public int cancelReservationsForTicketNo(int ticketNo);
	
	public int cancelSeatBookingOfReservation(int ticketNo);
	
	public int cancelBookingOfSinglePassenger(int ticketNo, int passengerId);
}
