package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flight.enumerate.CardType;
/**
 * this is payment entity
 * 
 * @author Naman
 *
 */


@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private int id;

	@Column(name = "payment_mode")
	private String mode;

	@Column(name = "card_type")
	@Enumerated(EnumType.STRING)
	private CardType cardType;

	@Column(name = "card_no")
	private long cardNo;

	@Column(name = "total_fare")
	private double fare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	
	
}
