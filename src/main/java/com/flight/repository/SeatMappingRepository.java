package com.flight.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.enumerate.SeatStatus;

@Repository
public class SeatMappingRepository extends GenericRepository{

	public List<String> bookedSeats(LocalDate bookingDate, int flightNo){
		
		String hql = "select m.seat.seatId.seatNo from SeatMapping m where m.bookingDate = :trvlDate and m.seat.seatId.flight.flightNo = :fno and m.status = :sts";
		
		Query qry = entityManager.createQuery(hql);
		qry.setParameter("trvlDate", bookingDate);
		qry.setParameter("fno", flightNo);
		qry.setParameter("sts", SeatStatus.BOOKED);
		List<String> bookedSeats = qry.getResultList();
		
		return bookedSeats;
	}
}
