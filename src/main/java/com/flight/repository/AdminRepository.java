package com.flight.repository;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author Naman
 *
 *         Dao/Repository class for admin
 */

@Repository
public class AdminRepository extends GenericRepository {

	public int fetchByUsernameAndPassword(String username, String password) {
		return (Integer) 
				entityManager
				.createQuery("select a.id from Admin a where a.username=:uname and a.password=:pass")
				.setParameter("uname", username).setParameter("pass", password).getSingleResult();
	}
}
