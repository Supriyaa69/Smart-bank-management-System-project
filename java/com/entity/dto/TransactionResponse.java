package com.entity.dto;

import java.time.LocalDateTime;

public class TransactionResponse {
	    private int id;
	    private double amount;
	    private String type;
	    private LocalDateTime date;
	    private AccountResponse senderAccount;
	    private AccountResponse receiverAccount;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		public AccountResponse getSenderAccount() {
			return senderAccount;
		}
		public void setSenderAccount(AccountResponse senderAccount) {
			this.senderAccount = senderAccount;
		}
		public AccountResponse getReceiverAccount() {
			return receiverAccount;
		}
		public void setReceiverAccount(AccountResponse receiverAccount) {
			this.receiverAccount = receiverAccount;
		}

}
