package com.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.DeleteFlight;
import com.flight.dto.FlightAddStatus;
import com.flight.dto.LoginAdmin;
import com.flight.dto.LoginStatus;
import com.flight.dto.SearchActiveFlightSD;
import com.flight.dto.SearchFlight;
import com.flight.dto.SearchFlightSD;
import com.flight.entity.Admin;
import com.flight.entity.Flight;
import com.flight.exception.CommonServiceException;
import com.flight.exception.FlightNotFoundException;
import com.flight.inventory.AdminServiceInventory;
import com.flight.inventory.SeatServiceInventory;
import com.flight.service.AdminService;
import com.flight.service.SeatService;

/**
 * 
 * @author Naman
 *
 *         This is the controller class for admin which contains all the
 *         required functionality for the same.
 */

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminServiceInventory adminService = new AdminService();
	
	@Autowired
	private SeatServiceInventory seatService = new SeatService();

	@PostMapping("/login-admin")
	public LoginStatus login(@RequestBody LoginAdmin login) {
		try {
			Admin admin = adminService.loginAdmin(login.getUsername(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Valid Admin user");
			loginStatus.setId(admin.getId());
			loginStatus.setName(admin.getUsername());
			return loginStatus;
		} catch (CommonServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}

	@PostMapping("/add-flight")
	public FlightAddStatus add(@RequestBody @Valid Flight flight) {
		try {
			int id = adminService.addFlight(flight);
			seatService.addSeats(id);
			FlightAddStatus status = new FlightAddStatus();
			status.setStatus(true);
			status.setMessage("Registration Successfull");
			status.setFlightId(id);
			return status;
		} catch (CommonServiceException e) {
			FlightAddStatus status = new FlightAddStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/search-flight-by-id")
	public Flight searchFlightId(@RequestBody SearchFlight flight) {
		try {
			Flight flightFetch = (Flight) adminService.searchFlight(flight.getId());
			return flightFetch;
		} catch (FlightNotFoundException e) {
			throw new FlightNotFoundException("No such flight available");
		}
	}

	@PostMapping("/search-flight-sd")
	public List<Flight> searchFlightBySourceDestination(@RequestBody SearchFlightSD flight) {
		try {
			List<Flight> flightfetch = adminService.searchFlight(flight.getSource(), flight.getDestination());
			return flightfetch;
		} catch (FlightNotFoundException e) {
			throw new FlightNotFoundException("No such flight available");
		}
	}

	@PostMapping("/search-flight-active-sd")
	public List<Flight> searchActiveFlightBySourceDestination(@RequestBody SearchActiveFlightSD flight) {
		try {
			List<Flight> flightfetch = adminService.searchActiveFlight(flight.getSource(), flight.getDestination(), flight.getStatus());
			return flightfetch;
		} catch (FlightNotFoundException e) {
			throw new FlightNotFoundException("No such flight available");
		}
	}

	@PostMapping("/delete-flight")
	public Flight deleteFLight(@RequestBody DeleteFlight deleteFlight) {
		Flight flight = adminService.deleteFlight(deleteFlight.getId(), deleteFlight.getStatus());
		System.out.println("flight deleted successfully");
		return flight;
	}
	
	@GetMapping("/all-flight")
	public List<Flight> sendAll(){
		List<Flight> flight = adminService.fetchAll();
		return flight;
	}
}
