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


import com.simplilearn.webservice.entity.Transaction;
import com.simplilearn.webservice.repository.TransactionRepository;
import com.simplilearn.webservice.exceptions.InvalidTransactionException;
import com.simplilearn.webservice.exceptions.TransactionNotFoundException;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionRepository pRepo;

	// list all transactions
	@GetMapping("/transactions")
	public List<Transaction> getTransactions() {
		List<Transaction> list = pRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new TransactionNotFoundException("Transaction list is empty !");
	}
	
//	@GetMapping("/transactionsByClientId/{clientId}")
//	public List<Transaction> getTransactionsByClientId(@PathVariable("clientId") long clientId) {
//		List<Transaction> list = pRepo.findByClientId(clientId);
//		if (!list.isEmpty()) {
//			return list;
//		}
//		throw new TransactionNotFoundException("Transaction list is empty !");
//	}		

	// get on transaction
	@GetMapping("/transactions/{id}")
	public Transaction getTransactions(@PathVariable("id") long id) {
		Transaction fetchedTransaction = pRepo.findById(id).orElseThrow(() -> {
			throw new TransactionNotFoundException("Transaction does not exist with id " + id);
		});
		return fetchedTransaction;
	}

	// create transaction
	@PostMapping("/transactions")
	public Transaction addTransaction(@RequestBody(required=false) Transaction transactionObj) {
		if(transactionObj !=null) {
			return pRepo.save(transactionObj);
		}
		throw new InvalidTransactionException("Transaction creation failed ! missing project object !");
	}

	// update transaction
	@PutMapping("/transactions")
	public Transaction updateTransaction(@RequestBody Transaction transactionObj) {
		// step 1: find transaction
		Transaction fetchedTransaction = pRepo.findById(transactionObj.getId()).orElseThrow(() -> {
			throw new TransactionNotFoundException("Transaction does not exist with id " + transactionObj.getId());
		});
		// step 2: Map updating fields
//		fetchedTransaction.setClientId(transactionObj.getClientId());
		fetchedTransaction.setType(transactionObj.getType());
		fetchedTransaction.setId(transactionObj.getId());
//		fetchedTransaction.setCheckingId(transactionObj.getCheckingId());
//		fetchedTransaction.setSavingId(transactionObj.getSavingId());
		fetchedTransaction.setCreditAmount(transactionObj.getCreditAmount());
		fetchedTransaction.setDebitAmount(transactionObj.getDebitAmount());
		fetchedTransaction.setDateTransaction(transactionObj.getDateTransaction());
		// step 3: update
		return pRepo.save(fetchedTransaction);

	}

	// get on transaction
	@DeleteMapping("/transactions/{id}")
	public void deleteTransaction(@PathVariable("id") long id) {
		// step 1: find transaction
		Transaction fetchedTransaction = pRepo.findById(id).orElseThrow(() -> {
			throw new TransactionNotFoundException("Transaction does not exist with id " + id);
		});
		// step 2: delete
		pRepo.delete(fetchedTransaction);
	}
}
