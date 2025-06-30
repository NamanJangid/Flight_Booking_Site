package com.flight.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flight.enumerate.TicketStatus;

/**
 * 
 * Reservation is the entity class for reservation module and reservation table.
 * 
 * @author Naman
 *
 */

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue
	@Column(name = "ticket_no")
	private int ticketNo;
	
	@Column(name = "booking_date")
	private LocalDate dateOfBooking;
	
	@Column(name = "ticket_status")
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
	private List<Passenger> passengers;
	
	@ManyToOne
	@JoinColumn(name = "flight_no")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
