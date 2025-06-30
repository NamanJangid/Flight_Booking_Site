package com.flight.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Passenger;

/**
 * 
 * @author Naman
 * 
 * 		This is the repository class for Passenger
 *
 */

@Repository
public class PassengerRepository extends GenericRepository{

	public Passenger fetchPassenger( int passengerNo) {
		String jpql = "select p from Passenger p where p.passengerNo =:p";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("p", passengerNo);
		Passenger p = (Passenger) q.getSingleResult();
		return p;
	}

}
