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

import com.simplilearn.webservice.entity.Account;
import com.simplilearn.webservice.exceptions.AccountNotFoundException;
import com.simplilearn.webservice.exceptions.InvalidAccountException;
import com.simplilearn.webservice.repository.AccountRepository;


@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	AccountRepository pRepo;

	// list all accounts
	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		List<Account> list = pRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new AccountNotFoundException("Account list is empty !");
	}

//	@GetMapping("/accountsByClientId/{clientId}")
//	public List<Account> getAccountsByClientId(@PathVariable("clientId") long clientId) {
//		List<Account> list = pRepo.findByClientId(clientId);
//		if (!list.isEmpty()) {
//			return list;
//		}
//		throw new AccountNotFoundException("Account list is empty !");
//	}
	
	// get on account
	@GetMapping("/accounts/{id}")
	public Account getAccounts(@PathVariable("id") long id) {
		Account fetchedAccount = pRepo.findById(id).orElseThrow(() -> {
			throw new AccountNotFoundException("Account does not exist with id " + id);
		});
		return fetchedAccount;
	}
	
	// create account
	@PostMapping("/accounts")
	public Account addAccount(@RequestBody(required=false) Account accountObj) {
		if(accountObj !=null) {
			return pRepo.save(accountObj);
		}
		throw new InvalidAccountException("Account creation failed ! missing project object !");
	}

	// update account
	@PutMapping("/accounts")
	public Account updateAccount(@RequestBody Account accountObj) {
		// step 1: find account
		Account fetchedAccount = pRepo.findById(accountObj.getId()).orElseThrow(() -> {
			throw new AccountNotFoundException("Account does not exist with id " + accountObj.getId());
		});
		// step 2: Map updating fields
		fetchedAccount.setChecking(accountObj.getChecking());
		fetchedAccount.setClient(accountObj.getClient());
		fetchedAccount.setDateOpen(accountObj.getDateOpen());
		fetchedAccount.setId(accountObj.getId());
		fetchedAccount.setSaving(accountObj.getSaving());	
		fetchedAccount.setTransactions(accountObj.getTransactions());
		// step 3: update
		return pRepo.save(fetchedAccount);

	}

	// get on account
	@DeleteMapping("/accounts/{id}")
	public void deleteAccount(@PathVariable("id") long id) {
		// step 1: find account
		Account fetchedAccount = pRepo.findById(id).orElseThrow(() -> {
			throw new AccountNotFoundException("Account does not exist with id " + id);
		});
		// step 2: delete
		pRepo.delete(fetchedAccount);
	}
}
