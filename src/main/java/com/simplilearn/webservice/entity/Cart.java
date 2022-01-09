package com.simplilearn.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="ecom_carts")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id")
	private long id;
	
	@Column(name="product_ids")
	private String productIds;
	
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="cart_total")
	private double total;
	
	public Cart(long id, String name, String productIds, Long customerId, double total) {
		super();
		this.id = id;
		this.productIds = productIds;	
		this.customerId = customerId;
		this.total = total;
	}
	public Cart() {}
	
	public String getProductIds() {
		return productIds;
	}
	public void setProductIds(String l) {
		this.productIds = l;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + productIds + ", customer=" + customerId + ", total=" + total + "]";
	}

	
	
}
