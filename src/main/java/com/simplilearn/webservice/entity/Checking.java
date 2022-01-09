package com.simplilearn.webservice.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="bank2_checkings")


public class Checking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="type")
	private String type;

	
	public Checking() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public Checking(long id, double balance, String type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Checking [id=" + id + ", balance=" + balance + ", type=" + type + "]";
	}



	
}
