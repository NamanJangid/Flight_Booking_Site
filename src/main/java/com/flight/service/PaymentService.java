package com.flight.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.entity.Payment;
import com.flight.entity.Reservation;
import com.flight.entity.Schedule;
import com.flight.enumerate.CardType;
import com.flight.repository.PaymentRepository;

/**
 * this is payment service
 * 
 * @author Naman
 *
 */
@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public void paymentService(int ticketNo) {
		List<String> pa = paymentRepository.inVoice(ticketNo);
		Reservation r = (Reservation) paymentRepository.fetch(Reservation.class, ticketNo);
		int id = r.getPayment().getId();
		double p = paymentRepository.inVoiceSub(id);
		System.out.println("Payment Id=" + id);
		System.out.println("Ticket No= " + ticketNo);
		for (String name : pa) {
			System.out.println("Passenger Name =" + name);
		}
		System.out.println("Total Fair=" + p);
	}

	public Schedule invoiceService(int flightNo, LocalDateTime departureTime) {
		return paymentRepository.details(flightNo, departureTime);

	}

	public boolean booking(long cardNumber, CardType cardType) {
		Payment p = (Payment) paymentRepository.booking(cardNumber, cardType);

		if (cardNumber == p.getCardNo()) {

			return true;
		} else {
			return false;
		}
	}
}