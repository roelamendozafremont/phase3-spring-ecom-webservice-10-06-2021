package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ecom_customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private long id;
	
	@Column(name="customer_fname")
	private String fname;
	
	@Column(name="customer_mname")
	private String mname;
	
	@Column(name="customer_lname")
	private String lname;
	
	@Column(name="customer_email")
	private String email;
	
	@Column(name="customer_phone")
	private String phone;
	
	@Column(name="customer_address")
	private String address;
	
	public Customer(long id, String fname, String mname, String lname, String email, String phone, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	
	public Customer() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + "]";
	}

	
	
}
