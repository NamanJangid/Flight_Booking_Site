package com.flight.dto;

import java.time.LocalDate;

import com.flight.enumerate.CardType;

public class Card {

	private long cardNumber;
	private CardType cardType;
	private LocalDate expriyDate;
	private int cvc;
	private double totalFare;
	

	public LocalDate getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

}
