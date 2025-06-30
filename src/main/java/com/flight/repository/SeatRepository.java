package com.flight.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Seat;
import com.flight.enumerate.SeatStatus;

/**
 * 
 * @author Naman
 * 	
 * 		This is the repository class for seat
 *
 */

@Repository
public class SeatRepository extends GenericRepository{

	public List<Seat> fetchBySeatStatus(SeatStatus seatStaus, int flightNo){
		
		String jpql = "select s from Seat s where s.seatStatus =:ss and s.seatId.flight.flightNo =:fn";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("ss", seatStaus);
		q.setParameter("fn", flightNo);
		List<Seat> list = q.getResultList();
		return list;
	}
	
	public long fetchNoOfSeatsBySeatStatus(SeatStatus seatStaus, int flightNo){
		
		String jpql = "select count(s.seatStatus) from Seat s where s.seatStatus =:ss and s.seatId.flight.flightNo =:fn";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("ss", seatStaus);
		q.setParameter("fn", flightNo);
		long result = (long) q.getSingleResult();
		return result;
	}

}
