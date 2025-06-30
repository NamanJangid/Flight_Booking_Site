package com.flight.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.BankAccount;
import com.flight.repository.BankAccountRepository;

/**
 * This is service class for bank account repository 
 * 
 * @author Naman
 *
 */
@Service
@Transactional
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	public void transaction(int userId, double amount) {
		
		BankAccount bankAccount = bankAccountRepository.fetchAccount( userId);
		if(bankAccount.getBalance()>amount) {
			bankAccount.setBalance(bankAccount.getBalance()-amount);
			bankAccountRepository.save(bankAccount);
		}
		else {
			System.out.println("low balance Can't book ticket");
		}
	}
	
	public void refund(int userId, double amount) {
		BankAccount bankAccount = bankAccountRepository.fetchAccount( userId);
		bankAccount.setBalance(bankAccount.getBalance()+(amount*0.95));
		bankAccountRepository.save(bankAccount);
	}
}
