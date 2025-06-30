package com.flight.controller;
/**
 * 
 * this is BankAccount controller class
 * @author Naman
 */
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.UserAccountHelper;

import com.flight.exception.BankAccountNotFoundException;


import com.flight.service.BankAccountService;

@RestController
@CrossOrigin
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccount;

	@PostMapping("/balance-deduction")
	public String balanceDeduction(@RequestBody UserAccountHelper bankAccountTransac) {
		try {
			bankAccount.transaction(bankAccountTransac.getUserId(), bankAccountTransac.getBalance());
			return "Transaction succesfull";
		} catch (BankAccountNotFoundException e) {
			// TODO: handle exception
			throw new BankAccountNotFoundException("ammount not deducted");
		}
	}

	@PostMapping("/balance-addition")
	public void balanceAddition(@RequestBody UserAccountHelper bankAccountTransac) {
		try {
			bankAccount.refund(bankAccountTransac.getUserId(), bankAccountTransac.getBalance());
		} catch (BankAccountNotFoundException e) {
			// TODO: handle exception
			throw new BankAccountNotFoundException("amount not refunded");
		}
	}
}
