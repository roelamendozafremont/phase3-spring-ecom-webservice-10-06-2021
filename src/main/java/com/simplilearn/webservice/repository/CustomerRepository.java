package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
