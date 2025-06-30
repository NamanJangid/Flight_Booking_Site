package com.flight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.PassengerBookings;
import com.flight.entity.Flight;
import com.flight.entity.Passenger;
import com.flight.entity.Seat;
import com.flight.entity.SeatId;
import com.flight.entity.SeatMapping;
import com.flight.enumerate.SeatStatus;
import com.flight.inventory.PassengerServiceInventory;
import com.flight.repository.PassengerRepository;

/**
 * 
 * @author Naman
 * 
 * 		This is the service class for passenger
 *
 */ 

@Service
@Transactional
public class PassengerService implements PassengerServiceInventory{

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Override
	public void addPassengers(PassengerBookings pas) {
		
		List<Passenger> passengers = pas.getPassengers();
		int noOfP =pas.getNoOfPassengers();
		List<String> selectedSeats = pas.getSelectedSeats();
		Flight flight = passengerRepo.fetch(Flight.class, pas.getFlightNo());
		
		for(int i =0;i<noOfP;i++) {
			Passenger p = passengers.get(i);
			SeatMapping sm = new SeatMapping();
			SeatId si = new SeatId();
			si.setFlight(flight);
			si.setSeatNo(selectedSeats.get(i));
			Seat seat = passengerRepo.fetch(Seat.class, si);
			
			sm.setSeat(seat);
			sm.setStatus(SeatStatus.BOOKED);
			sm = (SeatMapping) passengerRepo.save(sm);
			p.setSeatMapping(sm);
			passengerRepo.save(p);
		}
		
	}
}




	