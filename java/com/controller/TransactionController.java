package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.dto.DepositRequest;
import com.entity.dto.TransactionResponse;
import com.entity.dto.TransferRequest;
import com.service.TranscationService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TranscationService transactionService;
	
	@PostMapping("/transfer")
	public String transferMoney(@RequestBody TransferRequest request) {
		return transactionService.transferMoney(
				request.getSenderId(),
				request.getReceiverId(),
				request.getAmount());
	}
	@PostMapping("/deposit")
	public String deposit(@RequestBody DepositRequest request) {
	    return transactionService.depositMoney(
	        request.getAccountId(),
	        request.getAmount()
	    );
	}
	@GetMapping("/history/{accountId}")
	public List<TransactionResponse> getHistory(@PathVariable int accountId) {
	    return transactionService.getTransactionHistory(accountId);
	}
	

}
