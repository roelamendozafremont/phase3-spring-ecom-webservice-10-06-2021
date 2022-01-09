package com.simplilearn.webservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.simplilearn.webservice.entity.Checking;
import com.simplilearn.webservice.exceptions.CheckingNotFoundException;
import com.simplilearn.webservice.exceptions.InvalidCheckingException;
import com.simplilearn.webservice.repository.CheckingRepository;

@RestController
@RequestMapping("/api")
public class CheckingController {

	@Autowired
	CheckingRepository pRepo;

	// list all checkings
	@GetMapping("/checkings")
	public List<Checking> getCheckings() {
		List<Checking> list = pRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new CheckingNotFoundException("Checking list is empty !");
	}

//	@GetMapping("/checkingsByClientId/{clientId}")
//	public List<Checking> getCheckingsByClientId(@PathVariable("clientId") long clientId) {
//		List<Checking> list = pRepo.findByClientId(clientId);
//		if (!list.isEmpty()) {
//			return list;
//		}
//		throw new CheckingNotFoundException("Checking list is empty !");
//	}	
	
	// get on checking
	@GetMapping("/checkings/{id}")
	public Checking getCheckings(@PathVariable("id") long id) {
		Checking fetchedChecking = pRepo.findById(id).orElseThrow(() -> {
			throw new CheckingNotFoundException("Checking does not exist with id " + id);
		});
		return fetchedChecking;
	}

	// create checking
	@PostMapping("/checkings")
	public Checking addChecking(@RequestBody(required=false) Checking checkingObj) {
		if(checkingObj !=null) {
			return pRepo.save(checkingObj);
		}
		throw new InvalidCheckingException("Checking creation failed ! missing project object !");
	}

	// update checking
	@PutMapping("/checkings")
	public Checking updateChecking(@RequestBody Checking checkingObj) {
		// step 1: find checking
		Checking fetchedChecking = pRepo.findById(checkingObj.getId()).orElseThrow(() -> {
			throw new CheckingNotFoundException("Checking does not exist with id " + checkingObj.getId());
		});
		// step 2: Map updating fields
		fetchedChecking.setBalance(checkingObj.getBalance());
		fetchedChecking.setType(checkingObj.getType());
		fetchedChecking.setId(checkingObj.getId());
		// step 3: update
		return pRepo.save(fetchedChecking);

	}

	// get on checking
	@DeleteMapping("/checkings/{id}")
	public void deleteChecking(@PathVariable("id") long id) {
		// step 1: find checking
		Checking fetchedChecking = pRepo.findById(id).orElseThrow(() -> {
			throw new CheckingNotFoundException("Checking does not exist with id " + id);
		});
		// step 2: delete
		pRepo.delete(fetchedChecking);
	}
}
