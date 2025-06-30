package com.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * this is bank account entity
 * 
 * 
 * @author Naman
 *
 */

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@GeneratedValue
	@Column(name = "account_no")
	private int acno;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "bank_name")
	private String name;
	
	@Column(name="balance")
	private double balance;

	@Column(name = "card_no")
	private int cardNo;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	
}
