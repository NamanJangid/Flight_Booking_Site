package com.flight.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSchedule {

	private int flightNo;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalTime departureTime;
	private LocalTime returnDepartureTime;
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getReturnDepartureTime() {
		return returnDepartureTime;
	}
	public void setReturnDepartureTime(LocalTime returnDepartureTime) {
		this.returnDepartureTime = returnDepartureTime;
	}
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
}
