package com.wallet.api.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Statement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  statementId;
	private String transactionType;
	private Double amount;
	private LocalDate date;
	private String transactionRemarks;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private EWallet eWallet;

	public Statement(int statementId, String transactionType, Double amount, LocalDate date,
			String transactionRemarks, EWallet eWallet) {
		super();
		this.statementId = statementId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.transactionRemarks = transactionRemarks;
		this.eWallet = eWallet;
	}
	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatementId() {
		return statementId;
	}
	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}
	public EWallet geteWallet() {
		return eWallet;
	}
	public void seteWallet(EWallet eWallet) {
		this.eWallet = eWallet;
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

	
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}

	
	
}
