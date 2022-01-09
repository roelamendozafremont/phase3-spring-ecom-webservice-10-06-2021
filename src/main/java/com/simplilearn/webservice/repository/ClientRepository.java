package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simplilearn.webservice.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Long>{

	List <Client> findByFname(String fname);
	List <Client> findByLname(String lname);	
	
}
