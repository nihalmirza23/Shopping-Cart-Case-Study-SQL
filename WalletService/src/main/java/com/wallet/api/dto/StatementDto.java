package com.wallet.api.dto;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;


import com.wallet.api.model.EWallet;
public class StatementDto {
	
	
	private String transactionType;
	private Double amount;
	private LocalDate date;
	
	private EWallet ewallet;

	private String orderId;
	private String transactionRemarks;
	
	
	
	
	public StatementDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatementDto( String transactionType, Double amount, LocalDate date, EWallet ewallet,
			String orderId, String transactionRemarks) {
		super();
		
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.ewallet = ewallet;
		this.orderId = orderId;
		this.transactionRemarks = transactionRemarks;
	}
	public EWallet getEwallet() {
		return ewallet;
	}
	public void setEwallet(EWallet ewallet) {
		this.ewallet = ewallet;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	
	

}
