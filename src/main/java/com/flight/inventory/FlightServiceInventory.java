package com.flight.inventory;

import java.util.List;

import com.flight.entity.Flight;
import com.flight.enumerate.FlightStatus;

/**
 * 
 * @author Naman
 *
 *         Interface for Flight Table
 */

public interface FlightServiceInventory {

	public void addFlight(Flight flight);

	public List<Flight> searchFlight(int flightNo);

	public List<Flight> searchFlight(String source, String Destination);

	public void removeFlight(int flightNo, FlightStatus flightStatus);
}
