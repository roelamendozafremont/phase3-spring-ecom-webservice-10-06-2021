package com.simplilearn.webservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Saving;

public interface SavingRepository extends JpaRepository<Saving, Long>{
	
//	List <Saving> findByClientId(long clientId);

}
