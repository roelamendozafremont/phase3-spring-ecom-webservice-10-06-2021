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


import com.simplilearn.webservice.entity.Saving;
import com.simplilearn.webservice.repository.SavingRepository;
import com.simplilearn.webservice.exceptions.InvalidSavingException;
import com.simplilearn.webservice.exceptions.SavingNotFoundException;

@RestController
@RequestMapping("/api")
public class SavingController {

	@Autowired
	SavingRepository sRepo;


	// list all savings
	@GetMapping("/savings")
	public List<Saving> getSavings() {
		List<Saving> list = sRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new SavingNotFoundException("Saving list is empty !");
	}

//	@GetMapping("/savingsByClientId/{clientId}")
//	public List<Saving> getSavingsByClientId(@PathVariable("clientId") long clientId) {
//		List<Saving> list = sRepo.findByClientId(clientId);
//		if (!list.isEmpty()) {
//			return list;
//		}
//		throw new SavingNotFoundException("Saving list is empty !");
//	}		
	
	// get on saving
	@GetMapping("/savings/{id}")
	public Saving getSavings(@PathVariable("id") long id) {
		Saving fetchedSaving = sRepo.findById(id).orElseThrow(() -> {
			throw new SavingNotFoundException("Saving does not exist with id " + id);
		});
		return fetchedSaving;
	}

	// create saving
	@PostMapping("/savings")
	public Saving addSaving(@RequestBody(required=false) Saving savingObj) {
		if(savingObj !=null) {
			return sRepo.save(savingObj);
		}
		throw new InvalidSavingException("Saving creation failed ! missing project object !");
	}

	// update saving
	@PutMapping("/savings")
	public Saving updateSaving(@RequestBody Saving savingObj) {
		// step 1: find saving
		Saving fetchedSaving = sRepo.findById(savingObj.getId()).orElseThrow(() -> {
			throw new SavingNotFoundException("Saving does not exist with id " + savingObj.getId());
		});
		// step 2: Map updating fields
		fetchedSaving.setBalance(savingObj.getBalance());
		fetchedSaving.setType(savingObj.getType());
		fetchedSaving.setId(savingObj.getId());
		// step 3: update
		return sRepo.save(fetchedSaving);

	}

	// get on saving
	@DeleteMapping("/savings/{id}")
	public void deleteSaving(@PathVariable("id") long id) {
		// step 1: find saving
		Saving fetchedSaving = sRepo.findById(id).orElseThrow(() -> {
			throw new SavingNotFoundException("Saving does not exist with id " + id);
		});
		// step 2: delete
		sRepo.delete(fetchedSaving);
	}
}
