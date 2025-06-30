package com.flight.inventory;

import java.util.List;

import com.flight.entity.Admin;
import com.flight.entity.Flight;
import com.flight.enumerate.FlightStatus;

/**
 * 
 * @author Naman
 *
 *         Interface for Admin table
 */

public interface AdminServiceInventory {

	public void addAdmin();

	public Admin loginAdmin(String username, String password);

	public int addFlight(Flight flight);

	public Flight searchFlight(int id);

	public List<Flight> searchFlight(String source, String destination);

	public List<Flight> searchActiveFlight(String source, String destination, FlightStatus flightStatus);

	public Flight deleteFlight(int flightNo, FlightStatus status);
	
	public List<Flight> fetchAll();
}
