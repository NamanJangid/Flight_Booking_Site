package com.flight.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Naman
 *
 *		This Entity class is used to create Passengers table 
 *		it is used to store the details of the passengers who booked the tickets.
 */

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue
	@Column(name = "passenger_id")
	private int passengerNo;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "mobile_no")
	private int contact;

	@ManyToOne
	@JoinColumn(name = "ticket_no")
	private Reservation reservation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seat_mapping_id")
	private SeatMapping seatMapping;

	public int getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(int passengerNo) {
		this.passengerNo = passengerNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public SeatMapping getSeatMapping() {
		return seatMapping;
	}

	public void setSeatMapping(SeatMapping seatMapping) {
		this.seatMapping = seatMapping;
	}
	
}
