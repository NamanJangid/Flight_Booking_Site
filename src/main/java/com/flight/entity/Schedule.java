package com.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Schedule is the entity class for flight scheduling module.
 * 
 * @author Naman
 *
 */

@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue
	@Column(name = "schedule_id")
	private int id;
	
	@Column(name = "travel_date")
	private LocalDate travelDate;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "departure_time")
	private LocalDateTime departureTime;
	
	@Column(name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	@ManyToOne
	@JoinColumn(name = "flight_no")
	private Flight flight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
}
