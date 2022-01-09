package com.simplilearn.webservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.webservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

//List <Account> findByClientId(long clientId);
	
}
