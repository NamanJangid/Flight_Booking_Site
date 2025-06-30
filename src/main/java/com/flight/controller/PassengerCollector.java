package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.PassengerBookings;
import com.flight.dto.Status;
import com.flight.service.PassengerService;

/**
 * 
 * @author Naman
 * 
 * 		This is the collector class for passengers this contains all
 * 		the fuctionalities related to passengers
 *
 */

@RestController
@CrossOrigin
public class PassengerCollector {

	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/adding-passengers")
	public Status addingPassengerWiththeirSeat(@RequestBody PassengerBookings pb) {
		
		passengerService.addPassengers(pb);
		Status s = new Status();
		s.setMessage("passengers mapped succesfully with seat");
		s.setStatus(true);
		return s;
	}

}
	
	
	
	

