package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.BookedSeat;
import com.flight.dto.FlightAddHelper;
import com.flight.dto.Status;
import com.flight.exception.ServiceException;
import com.flight.inventory.SeatServiceInventory;
import com.flight.service.SeatService;

/**
 * 
 * @author Naman
 * 
 * 		This is the collector class which contains all the 
 * 		Functionalities related to the seats in the flight
 *
 */

@RestController
@CrossOrigin
public class SeatController {

	@Autowired
	private SeatServiceInventory seatService = new SeatService();
	
	@PostMapping("/add-seats")
	public Status add(@RequestBody FlightAddHelper flight) {
		try {
			seatService.addSeats(flight.getFlightNo());
			Status status = new Status();
			status.setStatus(true);
			status.setMessage("Seats added succesfully");
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/booked-seats")
	public List<String> fetchBookedSeats(@RequestBody BookedSeat bs){
		return seatService.getBookedSeats(bs);
	}
	
	@GetMapping("/get-fare")
	public double getFare(@RequestParam int flightNo, String seatNo) {
		return seatService.getSeatFare(flightNo, seatNo);
	}
	
}