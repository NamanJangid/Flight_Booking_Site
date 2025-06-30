package com.flight.inventory;

import com.flight.entity.User;

/**
 * 
 * @author Naman
 *
 *         Interface for User Table
 */

public interface UserServiceInventory {

	public int addUser(User user);
	
	public User loginUser(String email, String password);
}
