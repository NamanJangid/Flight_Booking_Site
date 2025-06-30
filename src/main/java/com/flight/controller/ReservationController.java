package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.service.ReservationService;
import com.flight.dto.BookedPassenger;
import com.flight.dto.CancelStatus;
import com.flight.dto.Booking;
import com.flight.dto.ReservationStatus;

/**
 * 
 * ReservationController is the controller class for handling the reservations done by users.
 * 
 * @author Naman
 *
 */

@RestController
@CrossOrigin
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/booking")
	public ReservationStatus makeBooking(@RequestBody Booking booking) {
		try {
			int ticketNo = reservationService.makeReservation(booking);
			ReservationStatus status = new ReservationStatus();
			status.setTicketNo(ticketNo);
			status.setMessage("Reservation is done!!");
			status.setStatus(true);
			return status;
		}
		catch(Exception e) {
			ReservationStatus status = new ReservationStatus();
			status.setMessage(e.getMessage());
			status.setStatus(false);
			return status;
		}
	}
	
	@GetMapping("/fetch-passengers")
	public List<BookedPassenger> fetchPassengers(@RequestParam int ticketNo) {
		List<BookedPassenger> passengerList = reservationService.fetchAllPassengerByTicketNo(ticketNo);
		return passengerList;
	}
	
	@PostMapping("/cancel-reservation")
	public CancelStatus cancelReservation(@RequestParam int ticketNo) {
		
		int cancelledRows = reservationService.cancelReservationsForTicketNo(ticketNo);
		int revivedSeats = reservationService.cancelSeatBookingOfReservation(ticketNo);
		CancelStatus status = new CancelStatus();
		status.setRowsUpdated(cancelledRows);
		status.setMessage("Reservation cancelled for the Ticket No: "+ticketNo+" "+revivedSeats+" made available");
		status.setStatus(true);
		return status;
	}
	
	@PostMapping("/cancel-seat-bookings")
	public CancelStatus cancelSeatBookings(@RequestParam int ticketNo) {
		int revivedSeats = reservationService.cancelSeatBookingOfReservation(ticketNo);
		CancelStatus status = new CancelStatus();
		status.setRowsUpdated(revivedSeats);
		status.setMessage("Seat Bookings cancelled for Ticket No: "+ticketNo);
		status.setStatus(true);
		return status;
	}
	
	@PostMapping("/cancel-passenger-booking")
	public CancelStatus cancelReservationOfSinglePassenger(@RequestParam int ticketNo, int passengerId) {
		int revivedSeats = reservationService.cancelBookingOfSinglePassenger(ticketNo, passengerId);
		CancelStatus status = new CancelStatus();
		status.setRowsUpdated(revivedSeats);
		status.setMessage("Seat Bookings cancelled for Passenger No: "+passengerId);
		status.setStatus(true);
		return status;
	}
	
}
