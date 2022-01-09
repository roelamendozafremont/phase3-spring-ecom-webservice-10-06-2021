package com.simplilearn.webservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Checking;

public interface CheckingRepository extends JpaRepository<Checking, Long>{
	
//	List <Checking> findByClientId(long clientId);	

}
