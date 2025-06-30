package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.entity.Admin;
import com.flight.entity.Flight;
import com.flight.enumerate.FlightStatus;
import com.flight.exception.CommonServiceException;
import com.flight.inventory.AdminServiceInventory;
import com.flight.repository.AdminRepository;
import com.flight.repository.FlightRepository;
import com.flight.repository.GenericRepository;

/**
 * 
 * @author Naman
 * 
 *         Service class for Admin table which implements AdminServiceInterface
 */

@Service
@Transactional
public class AdminService implements AdminServiceInventory {

	@Autowired
	private GenericRepository genericRepository;

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public void addAdmin() {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");

		genericRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(String username, String password) {
		try {
			int id = adminRepository.fetchByUsernameAndPassword(username, password);
			Admin admin = adminRepository.fetch(Admin.class, id);
			return admin;
		} 
		catch (EmptyResultDataAccessException e) {
			throw new CommonServiceException("Invalid Username/Password");
		}
	}

	@Override
	public int addFlight(Flight flight) {
		Flight f = (Flight) genericRepository.save(flight);
		return f.getFlightNo();
	}

	@Override
	public Flight searchFlight(int id) {
		try {
			Flight flight =(Flight) genericRepository.fetch(Flight.class, id);
			return flight;
		} 
		catch (EmptyResultDataAccessException e) {
			throw new CommonServiceException("FLight not Available");
		}
	}

	@Override
	public List<Flight> searchFlight(String source, String destination) {
		List<Flight> flight =flightRepository.fetchFlight(source, destination);
		return flight;
	}
	
	@Override
	public List<Flight> searchActiveFlight(String source, String destination, FlightStatus flightStatus) {
		List<Flight> flight = flightRepository.fetchActiveFlight(source, destination, flightStatus);
		return flight;
	}
	
	@Override
	public Flight deleteFlight(int flightNo, FlightStatus status) {
		Flight flight = genericRepository.fetch(Flight.class, flightNo);
		flight.setStatus(status);
		Flight f = (Flight) genericRepository.save(flight);
		return f;
	}
	
	@Override
	public List<Flight> fetchAll() {
		List<Flight> flight = flightRepository.fetchAllFlight();
		return flight;
	}
}
