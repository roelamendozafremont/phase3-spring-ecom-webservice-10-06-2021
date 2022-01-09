package com.simplilearn.webservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.webservice.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

//	List <Transaction> findByClientId(long clientId);
	
	
}
