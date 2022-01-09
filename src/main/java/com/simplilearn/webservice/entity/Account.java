package com.simplilearn.webservice.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank2_accounts")


public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
//	@Column(name="savingId")
//	private long savingId;
//	
//	@Column(name="checkingId")
//	private long checkingId;	
	
//	@Column(name="clientId")
//	private long clientId;	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "savingId", referencedColumnName = "id")
    private Saving saving;	
   
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "checkingId", referencedColumnName = "id")
    private Checking checking;	    
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;
	
	@Column(name="dateOpen")
	private Date dateOpen;		
	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId", referencedColumnName = "id",nullable=true)
    private Set<Transaction> transactions;	    	

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public Date getDateOpen() {
		return dateOpen;
	}



	public Client getClient() {
		return client;
	}

	
	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public Checking getChecking() {
		return checking;
	}

	public void setChecking(Checking checking) {
		this.checking = checking;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}

	public Account(long id, Saving saving, Checking checking, Client client, Date dateOpen, Set<Transaction> transactions) {
		super();
		this.id = id;
		this.saving = saving;
		this.checking = checking;
		this.client = client;
		this.dateOpen = dateOpen;
		this.transactions = transactions;
	}

	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", saving=" + saving.toString() + ", checking=" + checking.toString() + ", client=" + client.toString()
				+ ", dateOpen=" + dateOpen + "]";
	}




}
