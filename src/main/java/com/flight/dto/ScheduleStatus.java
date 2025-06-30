package com.flight.dto;

/**
 * ScheduleStatus is the status dto class for Schedule status.
 * 
 * @author Naman
 *
 */

public class ScheduleStatus extends Status {

	private int scheduledFlightNo;

	public int getScheduledFlightNo() {
		return scheduledFlightNo;
	}

	public void setScheduledFlightNo(int scheduledFlightNo) {
		this.scheduledFlightNo = scheduledFlightNo;
	}
}
