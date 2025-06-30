package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.Card;
import com.flight.dto.Invoice;
import com.flight.entity.Schedule;
import com.flight.service.PaymentService;
/**
 * this is payment controller
 * @author Naman
 *
 */
@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/testing")
	public void checkInVoice(@RequestParam int ticketNo) {
		try {
			paymentService.paymentService(ticketNo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/invoice")
	public Schedule getInVoice(@RequestBody Invoice in) {
		
		Schedule schedule=paymentService.invoiceService(in.getFlightNo(), in.getDepartureTime());
		return schedule;
		
		
	}
	
	@PostMapping("/payment")
	public boolean paymentVerify(@RequestBody Card card) {
		
		boolean a = paymentService.booking(card.getCardNumber(), card.getCardType());
		
		return a;
	}
}