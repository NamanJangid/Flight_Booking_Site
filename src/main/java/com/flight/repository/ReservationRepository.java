package com.flight.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.Flight;
import com.flight.entity.Passenger;
import com.flight.enumerate.SeatStatus;
import com.flight.enumerate.TicketStatus;

/**
 * 
 * ReservationRepository is the data access object class for reservation table.
 * 
 * @author Naman
 *
 */

@Repository
public class ReservationRepository extends GenericRepository {

	public List<Passenger> fetchPassengersByTicketNo(int ticketNo) {
		
		String jpql = "select passenger from Passenger passenger where passenger.reservation.ticketNo = :tktNo";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("tktNo", ticketNo);
		
		return qry.getResultList();
	}
	
	public int cancelBookingsForTicketNo(int ticketNo) {
		
		String jpql = "update Reservation reservation set reservation.status = :sts where reservation.ticketNo = :tktNo";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("sts", TicketStatus.CANCELLED);
		qry.setParameter("tktNo", ticketNo);
		
		int rowsUpdated = qry.executeUpdate();
		return rowsUpdated;
	}
	
	public int cancelSeatBookingForReservation(int ticketNo) {
		
		String jpql = "update SeatMapping m SET m.status = :sts where m.seatMappingId IN (select p.seatMapping.seatMappingId from Passenger p where p.reservation.ticketNo = :tkt)";
		
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("sts", SeatStatus.AVAILABLE);
		qry.setParameter("tkt", ticketNo);
		
		int rowsUpdated = qry.executeUpdate();
		
		return rowsUpdated;
	}
	
	public int cancelBookingForAPassenger(int ticketNo, int passengerId) {
		
		String jpql = "update SeatMapping m SET m.status = :sts where m.seatMappingId IN (select p.seatMapping.seatMappingId from Passenger p where p.reservation.ticketNo = :tkt AND p.passengerNo = :pid)";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("sts", SeatStatus.AVAILABLE);
		qry.setParameter("tkt", ticketNo);
		qry.setParameter("pid", passengerId);
		
		int rowsUpdated = qry.executeUpdate();
		
		return rowsUpdated;
	}
}
