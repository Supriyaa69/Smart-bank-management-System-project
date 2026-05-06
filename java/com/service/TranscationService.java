package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AccountRepository;
import com.dao.TranscationRepository;
import com.entity.Account;
import com.entity.Transction;
import com.entity.dto.TransactionResponse;
import com.mapper.TransactionMapper;

@Service
public class TranscationService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TranscationRepository transactionRepository;
	@Transactional
	public  String transferMoney(int senderId, int receiverId, double amount) {
		if(amount<=0) {
			return "Invalid amount";
		}
		Optional<Account>senderOpt=accountRepository.findById(senderId);
		Optional<Account>receiverOpt=accountRepository.findById(receiverId);
		if(senderOpt.isEmpty() || receiverOpt.isEmpty()) {
			return "Invalid account";
		}
		Account sender=senderOpt.get();
		Account receiver=receiverOpt.get();
		if(sender.getAccount_id()==receiver.getAccount_id()) {
			return "Cannot transfer to the same account";
		}
		if(sender.getBalance()<amount) {
			return "Insufficient balance";
		}
		sender.setBalance(sender.getBalance()-amount);
		receiver.setBalance(receiver.getBalance()+amount);
		accountRepository.save(sender);
		accountRepository.save(receiver);
	
	    Transction transaction = new Transction();
	    transaction.setAmount(amount);
	    transaction.setType("TRANSFER");
	    transaction.setDate(LocalDateTime.now());
	    transaction.setSenderAccount(sender);
	    transaction.setReceiverAccount(receiver);
	    transactionRepository.save(transaction);
	    
	    return "Transaction successful";
}
	@Transactional
	public String depositMoney(int accountId, double amount) {

	    if (amount <= 0) {
	        return "Invalid amount";
	    }

	    Optional<Account> accountOpt = accountRepository.findById(accountId);

	    if (accountOpt.isEmpty()) {
	        return "Account not found";
	    }

	    Account account = accountOpt.get();

	    // Add balance
	    account.setBalance(account.getBalance() + amount);
	    accountRepository.save(account);

	    Transction transaction = new Transction();
	    transaction.setAmount(amount);
	    transaction.setType("DEPOSIT");
	    transaction.setDate(LocalDateTime.now());
	    transaction.setReceiverAccount(account); 
	    transaction.setSenderAccount(null);      

	    transactionRepository.save(transaction);

	    return "Deposit successful";
	}
	public List<TransactionResponse> getTransactionHistory(int accountId) {

	    Optional<Account> accountOpt = accountRepository.findById(accountId);

	    if (accountOpt.isEmpty()) {
	        throw new RuntimeException("Account not found");
	    }

	    Account account = accountOpt.get();

	    List<Transction> sent = transactionRepository.findBySenderAccount(account);
	    List<Transction> received = transactionRepository.findByReceiverAccount(account);

	    sent.addAll(received);
	    return sent.stream()
	            .map(TransactionMapper::toDTO)
	            .toList();
	}
	    

}
