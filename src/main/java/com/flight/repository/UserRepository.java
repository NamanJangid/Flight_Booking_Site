package com.flight.repository;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author Naman
 *
 *         Dao/Repository class for User
 */

@Repository
public class UserRepository extends GenericRepository {

	public boolean isCustomerPresent(String email) {

		return (Long) 
				entityManager.createQuery("select count(u.id) from User u where u.email=:email")
				.setParameter("email", email).getSingleResult() == 1 ? true : false;
	}

	public int fetchByEmailAndPassword(String email, String password) {
		return (Integer) 
				entityManager.createQuery("select u.id from User u where u.email=:email and u.password=:pass")
				.setParameter("email", email).setParameter("pass", password).getSingleResult();
	}
}
