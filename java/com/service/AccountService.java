package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountRepository;
import com.entity.Account;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public double getBalance(int accountId) {
		Optional<Account>accountOpt=accountRepository.findById(accountId);
		if(accountOpt.isEmpty()) {
			throw new RuntimeException("Account not found");
		}
		return accountOpt.get().getBalance();
	}
	

}
