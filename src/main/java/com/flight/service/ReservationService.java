package com.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.repository.ReservationRepository;
import com.flight.entity.Seat;
import com.flight.entity.SeatId;
import com.flight.dto.BookedPassenger;
import com.flight.entity.Passenger;
import com.flight.dto.Booking;
import com.flight.entity.Flight;
import com.flight.entity.Reservation;
import com.flight.entity.User;
import com.flight.inventory.ReservationInventory;

/**
 * 
 * ReservationService is the service class for the reservations of users.
 * 
 * @author Naman
 *
 */

@Service
@Transactional
public class ReservationService implements ReservationInventory {
	
	@Autowired
	private ReservationRepository reservationRepository;

	public int makeReservation(Booking booking) {
		Flight flight = reservationRepository.fetch(Flight.class, booking.getFlightNo());
		User user = reservationRepository.fetch(User.class, booking.getUserId());
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setDateOfBooking(LocalDate.now());
		reservation.setUser(user);
		Reservation updatedReservation = (Reservation) reservationRepository.save(reservation);
		return updatedReservation.getTicketNo();		
	}
	
	public List<BookedPassenger> fetchAllPassengerByTicketNo(int ticketNo) {
		
		List<Passenger> passengerList = reservationRepository.fetchPassengersByTicketNo(ticketNo);
		List<BookedPassenger> passengers = new ArrayList<BookedPassenger>();
		for (Passenger passenger : passengerList) {
			BookedPassenger bookedPassenger = new BookedPassenger();
			bookedPassenger.setPassengerId(passenger.getPassengerNo());
			bookedPassenger.setName(passenger.getFirstName()+" "+passenger.getLastName());
			
			passengers.add(bookedPassenger);
		}
		
		return passengers;
	}
	
	public int cancelReservationsForTicketNo(int ticketNo) {
		return reservationRepository.cancelBookingsForTicketNo(ticketNo);
	}
	
	public int cancelSeatBookingOfReservation(int ticketNo) {
		return reservationRepository.cancelSeatBookingForReservation(ticketNo);
	}
	
	public int cancelBookingOfSinglePassenger(int ticketNo, int passengerId) {
		return reservationRepository.cancelBookingForAPassenger(ticketNo, passengerId);
	}
	
}
