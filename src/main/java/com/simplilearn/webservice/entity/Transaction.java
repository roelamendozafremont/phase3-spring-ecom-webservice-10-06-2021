package com.simplilearn.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank2_transactions")


public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	
	@Column(name="debitAmount")
	private double debitAmount;	
	
	@Column(name="creditAmount")
	private double creditAmount;	
	
	@Column(name="dateTransaction")
	private Date dateTransaction;			
	
	@Column(name="type")
	private String type;		
	
//    @ManyToOne
//    @JoinColumn(name="accountId", nullable=true)
//    private Account account;
//	
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	
//	public Account getAccount() {
//		return account;
//	}
//
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}


	public long getId() {
		return id;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(long id) {
		this.id = id;
	}


	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public Transaction(long id, double debitAmount, double creditAmount,
			Date dateTransaction, String type) {
		super();
		this.id = id;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.dateTransaction = dateTransaction;
		this.type = type;
//		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ",  debitAmount=" + debitAmount + ", creditAmount=" + creditAmount + ", dateTransaction="
				+ dateTransaction + ", type=" + type + "]";
	}


	
	
}
