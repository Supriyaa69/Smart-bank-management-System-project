package com.entity.dto;

public class AccountResponse {
	    private int accountId;
	    private double balance;
	    private String accountType;
	    private UserResponse user;
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public UserResponse getUser() {
			return user;
		}
		public void setUser(UserResponse user) {
			this.user = user;
		}

}
