package com.flight.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flight.entity.BankAccount;

/**
 * This is the repository class for bank account table
 * 
 * @author Naman
 *
 */

@Repository
public class BankAccountRepository extends GenericRepository {
	
	public BankAccount fetchAccount(int userId) {
		
		String jpql = "select acc from BankAccount acc join fetch acc.user u where u.id=:userId";
		Query qry = entityManager.createQuery(jpql);
		qry.setParameter("userId", userId);
		BankAccount account = (BankAccount) qry.getSingleResult();
		return account;
	}
   
}
