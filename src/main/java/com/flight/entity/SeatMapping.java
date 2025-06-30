package com.flight.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flight.enumerate.SeatStatus;

/**
 * 
 * @author Naman
 * 	
 * 		this class is used to map the seatId with specific mapping id 
 *
 */

@Entity
@Table( name = "seat_mapping")
public class SeatMapping {
	
	@Id
	@GeneratedValue
	@Column(name = "seat_mapping_id")
	private int seatMappingId;
	
	@OneToOne
	@JoinColumn(name = "flight_no")
	@JoinColumn(name ="seat_no")
	private Seat seat;
	
	@Column(name = "seat_status")
	@Enumerated(EnumType.STRING)
	private SeatStatus status;
	
	@Column(name = "travel_date")
	private LocalDate bookingDate;

	public int getSeatMappingId() {
		return seatMappingId;
	}

	public void setSeatMappingId(int seatMappingId) {
		this.seatMappingId = seatMappingId;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public SeatStatus getStatus() {
		return status;
	}

	public void setStatus(SeatStatus status) {
		this.status = status;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
}
