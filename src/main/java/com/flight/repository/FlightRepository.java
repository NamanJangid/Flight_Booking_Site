package com.flight.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Flight;
import com.flight.enumerate.FlightStatus;

/**
 * 
 * @author Naman
 *
 *         Dao/Repository methods for Flight table
 */

@Repository
public class FlightRepository extends GenericRepository {

	// Searching a flight by flight number
	public List<Flight> fetchFlight(int flightNo) {
		String jpql = "select f from Flight f where f.flightNo =:flightNo";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("flightNo", flightNo);
		List<Flight> list = q.getResultList();
		return list;
	}

	// Searching a flight by source and destination
	public List<Flight> fetchFlight(String source, String destination) {
		String jpql = "select f from Flight f where f.source =:source and f.destination=:destination";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("source", source);
		q.setParameter("destination", destination);
		List<Flight> list = q.getResultList();
		return list;
	}

	// Searching a flight by source and destination
	public List<Flight> fetchActiveFlight(String source, String destination, FlightStatus status) {
		String jpql = "select f from Flight f where f.source =:source and f.destination=:destination and f.status=:status";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("source", source);
		q.setParameter("destination", destination);
		q.setParameter("status", status);
		List<Flight> list = q.getResultList();
		return list;
	}

	// select all the flights
	public List<Flight> fetchAllFlight() {
		String jpql = "select f from Flight f ";
		Query q = entityManager.createQuery(jpql);
		List<Flight> list = q.getResultList();
		return list;
	}
}
