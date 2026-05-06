package com.entity.dto;

public class TransferRequest {
	public TransferRequest(int senderId, int receiverId, double amount) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
	}
	private int senderId;
	private int receiverId;
	private double amount;
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
