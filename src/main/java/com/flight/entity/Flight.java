package com.flight.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flight.enumerate.FlightStatus;

/**
 * 
 * @author Naman
 *
 *         Flight class contains the details of the flight
 */

@Entity
@Table(name = "flight")
public class Flight {

	@Null
	@Id
	@GeneratedValue
	@Column(name = "flight_no")
	private int flightNo;

	@NotNull
	private String source;
	
	@NotNull
	private String destination;
	
	private long duration;

	@NotNull
	@Column(name = "flight_status")
	@Enumerated(EnumType.STRING)
	private FlightStatus status;

	@NotNull
	@Column(name = "available_seats")
	private int availableSeats;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
	private List<Schedule> schedules;

	@OneToMany(mappedBy = "flight")
	private List<Reservation> reservations;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seatId.flight")
	private List<Seat> seats;

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
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

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@JsonIgnore
	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@JsonIgnore
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@JsonIgnore
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
