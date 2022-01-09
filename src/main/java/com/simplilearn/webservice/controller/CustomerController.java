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

import com.simplilearn.webservice.entity.Customer;
import com.simplilearn.webservice.repository.CustomerRepository;
import com.simplilearn.webservice.exceptions.InvalidCustomerException;
import com.simplilearn.webservice.exceptions.CustomerNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository cRepo;


	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> list = cRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new CustomerNotFoundException("Customer list is empty !");
	}

	
	
	@GetMapping("/customers/{id}")
	public Customer getCustomers(@PathVariable("id") long id) {
		Customer fetchedCustomer = cRepo.findById(id).orElseThrow(() -> {
			throw new CustomerNotFoundException("Customer does not exist with id " + id);
		});
		return fetchedCustomer;
	}


	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody(required=false) Customer customerObj) {
		if(customerObj !=null) {
			return cRepo.save(customerObj);
		}
		throw new InvalidCustomerException("Customer creation failed ! missing project object !");
	}


	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customerObj) {

		Customer fetchedCustomer = cRepo.findById(customerObj.getId()).orElseThrow(() -> {
			throw new CustomerNotFoundException("Customer does not exist with id " + customerObj.getId());
		});
	
		fetchedCustomer.setFname(customerObj.getFname());
		fetchedCustomer.setMname(customerObj.getMname());
		fetchedCustomer.setLname(customerObj.getLname());		
		fetchedCustomer.setPhone(customerObj.getPhone());
		fetchedCustomer.setEmail(customerObj.getEmail());
		fetchedCustomer.setAddress(customerObj.getAddress());
		// step 3: update
		return cRepo.save(fetchedCustomer);

	}


	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable("id") long id) {

		Customer fetchedCustomer = cRepo.findById(id).orElseThrow(() -> {
			throw new CustomerNotFoundException("Customer does not exist with id " + id);
		});
		// step 2: delete
		cRepo.delete(fetchedCustomer);
	}
}
