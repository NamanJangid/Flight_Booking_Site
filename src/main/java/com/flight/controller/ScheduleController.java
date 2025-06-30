package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.FlightSchedule;
import com.flight.service.ScheduleService;
import com.flight.dto.AvailableFlight;
import com.flight.dto.ScheduledFlight;
import com.flight.dto.ScheduledReturnFlight;
import com.flight.dto.ScheduleStatus;

/**
 * 
 * ScheduleController is the controller class for managing the schedules of the flights.
 * 
 * @author Naman
 *
 */

@RestController
@CrossOrigin
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/add-schedule")
	public ScheduleStatus addFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
		try {
			scheduleService.generateSchedule(flightSchedule);
			ScheduleStatus status = new ScheduleStatus();
			status.setStatus(true);
			status.setScheduledFlightNo(flightSchedule.getFlightNo());
			status.setMessage("Schedule added Successfully");
			return status;
		}
		catch(Exception e) {
			ScheduleStatus status = new ScheduleStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping("/available-flights")
	public List<AvailableFlight> searchAvailableFlights(@RequestBody ScheduledFlight scheduledFlight) {
		// exception yet to be written for NO RESULTS..
		return scheduleService.getAvailableFlights(scheduledFlight);
	}
	
	@PostMapping("/return-trip-flights")
	public List<AvailableFlight> searchAvailableFlightsForReturnTrip(@RequestBody ScheduledReturnFlight scheduledReturn) {
		return scheduleService.getScheduledFlightsForReturnTrip(scheduledReturn);
	}
}
