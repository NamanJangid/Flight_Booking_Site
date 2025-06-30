package com.flight.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Schedule;
import com.flight.dto.ScheduledReturnFlight;
import com.flight.dto.ScheduledFlight;

/**
 * 
 * ScheduleRepository is the data access object class for schedule table.
 * 
 * @author Naman
 *
 */

@Repository
public class ScheduleRepository extends GenericRepository {

	public List<Schedule> getScheduledFlights(ScheduledFlight scheduledFlight) {

		String jpql = "select schedule from Schedule schedule where schedule.travelDate = :forDate and schedule.source = :src and schedule.destination = :dest";
		
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("forDate", scheduledFlight.getTravelDate());
		qry.setParameter("src", scheduledFlight.getSource());
		qry.setParameter("dest", scheduledFlight.getDestination());

		List<Schedule> scheduledFlights = qry.getResultList();
		return scheduledFlights;
	}
	
	public List<Schedule> getScheduledTwoWayFlights(ScheduledReturnFlight scheduledReturn) {

		String jpql = "select schedule from Schedule schedule where (schedule.travelDate = :trvDate AND schedule.source = :src AND schedule.destination = :dest ) OR (schedule.travelDate = :retDate AND schedule.source = :dest AND schedule.destination = :src )";
		
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("trvDate", scheduledReturn.getTravelDate());
		qry.setParameter("retDate", scheduledReturn.getReturnDate());
		qry.setParameter("src", scheduledReturn.getSource());
		qry.setParameter("dest", scheduledReturn.getDestination());

		List<Schedule> scheduledFlights = qry.getResultList();
		
		return scheduledFlights;
	}
}
