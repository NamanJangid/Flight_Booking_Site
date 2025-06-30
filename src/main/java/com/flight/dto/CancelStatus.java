package com.flight.dto;

/**
 * Cancel Status is the dto class for returning the cancel status confirmation/message.
 * 
 * @author Naman
 *
 */

public class CancelStatus extends Status {

	private int rowsUpdated;

	public int getRowsUpdated() {
		return rowsUpdated;
	}

	public void setRowsUpdated(int rowsUpdated) {
		this.rowsUpdated = rowsUpdated;
	}
}
