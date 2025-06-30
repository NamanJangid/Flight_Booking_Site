package com.flight.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.BookedSeat;
import com.flight.entity.Flight;
import com.flight.entity.Seat;
import com.flight.entity.SeatId;
import com.flight.enumerate.SeatClass;
import com.flight.inventory.SeatServiceInventory;
import com.flight.repository.SeatMappingRepository;
import com.flight.repository.SeatRepository;

/**
 * 
 * @author Naman
 * 
 * 		This is the service class for Seat
 *
 */

@Service
@Transactional
public class SeatService implements SeatServiceInventory{
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private SeatMappingRepository seatMappingRepository;
	
	@Override
	public void addSeats(int flightNo) {

		Flight flight = (Flight) seatRepository.fetch(Flight.class, flightNo);
		String seatNo = "";
		String seatMatrix = "ABCDE";
		int businessRow = (int) ((flight.getAvailableSeats() * 0.3)/seatMatrix.length());
		for(int i=1; i<= flight.getAvailableSeats()/seatMatrix.length(); i++) {
			for( int mtx = 0; mtx< seatMatrix.length(); mtx++) {
				seatNo = seatNo+seatMatrix.charAt(mtx)+i;
				Seat seat = new Seat();
				SeatId seatId = new SeatId();
				seatId.setSeatNo(seatNo);
				seatId.setFlight(flight);
				if(i<=businessRow) {
					seat.setSeatClass(SeatClass.BUSINESS);
					seat.setFare(5000);
				}
				else {
					seat.setSeatClass(SeatClass.ECONOMY);
					seat.setFare(3500);
				}
				seat.setSeatId(seatId);
				seatRepository.save(seat);
				seatNo="";
			}			
		}
		
	}
	
	public List<String> getBookedSeats(BookedSeat bs){
		return seatMappingRepository.bookedSeats(bs.getBookingDate(), bs.getFlightNo());
	}

	public double getSeatFare(int flightNo, String seatNo) {
		Flight flight = seatRepository.fetch(Flight.class, flightNo);
		SeatId sid =new SeatId();
		sid.setFlight(flight);
		sid.setSeatNo(seatNo);
		Seat seat = seatRepository.fetch(Seat.class, sid);
		return seat.getFare();
	}

}
