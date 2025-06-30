package com.flight.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.FlightSchedule;
import com.flight.entity.Flight;
import com.flight.entity.Schedule;
import com.flight.inventory.ScheduleInventory;
import com.flight.repository.ScheduleRepository;
import com.flight.dto.ScheduledReturnFlight;
import com.flight.dto.AvailableFlight;
import com.flight.dto.ScheduledFlight;

/**
 * 
 * ScheduleService is the service class for scheduling the flights.
 * 
 * @author Naman
 *
 */

@Service
@Transactional
public class ScheduleService implements ScheduleInventory {

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public void generateSchedule(FlightSchedule flightSchedule) {
		
		Flight flight = scheduleRepository.fetch(Flight.class, flightSchedule.getFlightNo());
		
		long noOfDays = ChronoUnit.DAYS.between(flightSchedule.getFromDate(), flightSchedule.getToDate());
		LocalDate scheduleDay = flightSchedule.getFromDate();
		
		for(int i=0; i <= noOfDays; i++) { 
			
			LocalDateTime departureSchedule = LocalDateTime.of(scheduleDay, flightSchedule.getDepartureTime());
			LocalDateTime returnDepartureSchedule = LocalDateTime.of(scheduleDay, flightSchedule.getReturnDepartureTime());
			
			Schedule schedule = new Schedule();
			schedule.setFlight(flight);
			schedule.setTravelDate(scheduleDay);
			schedule.setSource(flight.getSource());
			schedule.setDestination(flight.getDestination());
			schedule.setDepartureTime(departureSchedule);
			schedule.setArrivalTime(departureSchedule.plusMinutes(flight.getDuration()));
			scheduleRepository.save(schedule);
			schedule.setSource(flight.getDestination());
			schedule.setDestination(flight.getSource());
			schedule.setDepartureTime(returnDepartureSchedule);
			schedule.setArrivalTime(returnDepartureSchedule.plusMinutes(flight.getDuration()));
			scheduleRepository.save(schedule);
			
			scheduleDay = scheduleDay.plusDays(1);
		}
	}
	
	public List<AvailableFlight> getAvailableFlights(ScheduledFlight scheduledFlight) {
		
		List<Schedule> schedules = scheduleRepository.getScheduledFlights(scheduledFlight);
		List<AvailableFlight> results = new ArrayList<AvailableFlight>();
		for (Schedule schedule : schedules) {
			AvailableFlight availableFlight = new AvailableFlight();
			availableFlight.setFlightNo(schedule.getFlight().getFlightNo());
			availableFlight.setAvailableSeats(schedule.getFlight().getAvailableSeats()); // DO SOMETHING FOR AVAILABLE SEATS
			availableFlight.setSource(schedule.getSource());
			availableFlight.setDestination(schedule.getDestination());
			availableFlight.setDeparture(schedule.getDepartureTime());
			availableFlight.setArrival(schedule.getArrivalTime());
			
			results.add(availableFlight);
		}
		return results;
	}
	
	public List<AvailableFlight> getScheduledFlightsForReturnTrip(ScheduledReturnFlight returnSchedule) {
		
		List<Schedule> schedules = scheduleRepository.getScheduledTwoWayFlights(returnSchedule);
		List<AvailableFlight> searchResults = new ArrayList<AvailableFlight>();
		for (Schedule schedule : schedules) {
			AvailableFlight availableFlight = new AvailableFlight();
			availableFlight.setFlightNo(schedule.getFlight().getFlightNo());
			availableFlight.setAvailableSeats(schedule.getFlight().getAvailableSeats()); // DO SOMETHING FOR AVAILABLE SEATS
			availableFlight.setSource(schedule.getSource());
			availableFlight.setDestination(schedule.getDestination());
			availableFlight.setDeparture(schedule.getDepartureTime());
			availableFlight.setArrival(schedule.getArrivalTime());
			
			searchResults.add(availableFlight);
		}
		
		return searchResults;
	}
}
