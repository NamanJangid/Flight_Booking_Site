package com.flight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.LoginStatus;
import com.flight.dto.LoginUser;
import com.flight.dto.RegisterStatus;
import com.flight.entity.User;
import com.flight.exception.CommonServiceException;
import com.flight.inventory.UserServiceInventory;
import com.flight.service.UserService;

/**
 * 
 * @author Naman
 *
 *         This is the controller class for User which contains functionality
 *         for user login and Registration.
 */

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceInventory userService = new UserService();

	@PostMapping("/register")
	public RegisterStatus register(@RequestBody @Valid User user) {
		try {
			int id = userService.addUser(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(true);
			status.setMessage("Registration Successfull");
			status.setRegisteredUserId(id);
			return status;
		} catch (CommonServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/login-user")
	public LoginStatus login(@RequestBody LoginUser login) {
		try {
			User user = userService.loginUser(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login Successful");
			loginStatus.setId(user.getId());
			loginStatus.setName(user.getFirstName() + " " + user.getLastName());
			return loginStatus;
		} catch (CommonServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());
			return loginStatus;
		}
	}
}
