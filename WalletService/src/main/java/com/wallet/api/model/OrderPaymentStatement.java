package com.wallet.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OrderPaymentStatement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private String transactionType;
	private Double amount;
	private LocalDate date;
	
	//private EWallet ewallet;
	
	private int walletId;

	//private String orderId;
	private String transactionRemarks;

	public OrderPaymentStatement(int paymentId, String transactionType, Double amount, LocalDate date,
			int walletId, String transactionRemarks) {
		super();
		this.paymentId = paymentId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.walletId = walletId;
		this.transactionRemarks = transactionRemarks;
	}

	public OrderPaymentStatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getTransactionRemarks() {
		return transactionRemarks;
	}

	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	


}
