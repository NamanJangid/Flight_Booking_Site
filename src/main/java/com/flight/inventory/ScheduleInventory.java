package com.flight.inventory;

import java.util.List;

import com.flight.dto.AvailableFlight;
import com.flight.dto.FlightSchedule;
import com.flight.dto.ScheduledFlight;

/**
 * 
 * ScheduleInventory is an interface for ScheduleService class.
 * 
 * @author Naman
 *
 */

public interface ScheduleInventory {

	public void generateSchedule(FlightSchedule flightSchedule );
	
	public List<AvailableFlight> getAvailableFlights(ScheduledFlight scheduledFlight);
}
