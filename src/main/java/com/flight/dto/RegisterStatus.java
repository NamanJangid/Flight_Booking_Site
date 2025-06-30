package com.flight.dto;

/**
 * 
 * @author Naman
 *
 *         Helper class for registration user status
 */

public class RegisterStatus extends UserStatus {

	private int registeredUserId;

	public int getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(int registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

}
