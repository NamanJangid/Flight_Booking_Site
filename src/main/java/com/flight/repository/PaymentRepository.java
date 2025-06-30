package com.flight.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Payment;
import com.flight.entity.Schedule;
import com.flight.enumerate.CardType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * this is payment repository
 * 
 * @author Naman
 *
 */

@Repository
public class PaymentRepository extends GenericRepository {
	public List<String> inVoice(int ticketNo) {
		String jpql = "select p.firstName from Passenger p where p.reservation.ticketNo=:tno";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("tno", ticketNo);
		List<String> a = qry.getResultList();
		return a;
	}

	public double inVoiceSub(int id) {
		String jpql = "select p.fare from Payment p where p.id=:tno";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("tno", id);
		double a = (double) qry.getSingleResult();
		return a;
	}

	public Schedule details(int flightNo, LocalDateTime departureTime) {

		String jpql = "select s from Schedule s where s.flight.flightNo=:fn and s.departureTime=:dt";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("fn", flightNo);
		qry.setParameter("dt", departureTime);
		Schedule a = (Schedule) qry.getResultList();
		return a;
	}

	public Payment booking(long cardNumber, CardType cardType) {
		String jpql = "select p from Payment p where p.cardNo=:cn ";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("cn", cardNumber);
		Payment a = (Payment) qry.getSingleResult();
		return a;

	}

}