package com.flight.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.entity.User;
import com.flight.exception.CommonServiceException;
import com.flight.inventory.UserServiceInventory;
import com.flight.repository.UserRepository;

/**
 * 
 * @author Naman
 *
 *         Service class for user
 */

@Service
@Transactional
public class UserService implements UserServiceInventory {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private MailSender mailSender;
	
	@Override
	public int addUser(User user) {
		if (userRepository.isCustomerPresent(user.getEmail())) {
			throw new CommonServiceException("User already regristered");
		} else {
			user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			User upUser = (User) userRepository.save(user);

			// email
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("flightreservationproject@gmail.com");
			message.setTo(user.getEmail());
			message.setSubject("Welcome to our Site");
			message.setText("Thanks for registering on our site we hope u will enjoy the experience");
			mailSender.send(message);

			return upUser.getId();
		}
	}

	@Override
	public User loginUser(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = userRepository.fetchByEmailAndPassword(email, password);
			User user = userRepository.fetch(User.class, id);
			return user;
		} catch (EmptyResultDataAccessException e) {
			throw new CommonServiceException("Invalid Username/Password");
		}
	}
}
