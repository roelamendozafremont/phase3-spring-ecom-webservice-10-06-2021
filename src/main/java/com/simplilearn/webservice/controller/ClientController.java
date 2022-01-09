package com.simplilearn.webservice.controller;


import java.util.Date;
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

import com.simplilearn.webservice.entity.Client;
import com.simplilearn.webservice.repository.ClientRepository;
import com.simplilearn.webservice.exceptions.InvalidClientException;
import com.simplilearn.webservice.exceptions.ClientNotFoundException;


@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	ClientRepository pRepo;

	// list all clients
	@GetMapping("/clients")
	public List<Client> getClients() {
		List<Client> list = pRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new ClientNotFoundException("Client list is empty !");
	}
	
	@GetMapping("/clientsByFirstName/{fname}")
	public List<Client> getClientsByFirstName(@PathVariable("fname") String fname) {
		List<Client> list = pRepo.findByFname(fname);
		if (!list.isEmpty()) {
			return list;
		}
		throw new ClientNotFoundException("Client list is empty !");
	}	

	@GetMapping("/clientsByLastName/{lname}")
	public List<Client> geClientsByLastName(@PathVariable("lname") String lname) {
		List<Client> list = pRepo.findByLname(lname);
		if (!list.isEmpty()) {
			return list;
		}
		throw new ClientNotFoundException("Client list is empty !");
	}		

	// get on client
	@GetMapping("/clients/{id}")
	public Client getClients(@PathVariable("id") long id) {
		Client fetchedClient = pRepo.findById(id).orElseThrow(() -> {
			throw new ClientNotFoundException("Client does not exist with id " + id);
		});
		return fetchedClient;
	}

	// create client
	@PostMapping("/clients")
	public Client addClient(@RequestBody(required=false) Client clientObj) {
		if(clientObj !=null) {
			return pRepo.save(clientObj);
		}
		throw new InvalidClientException("Client creation failed ! missing project object !");
	}

	// update client
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client clientObj) {
		// step 1: find client
		Client fetchedClient = pRepo.findById(clientObj.getId()).orElseThrow(() -> {
			throw new ClientNotFoundException("Client does not exist with id " + clientObj.getId());
		});
		// step 2: Map updating fields
		fetchedClient.setCity(clientObj.getCity());
		fetchedClient.setDate(new Date());
		fetchedClient.setEmail(clientObj.getEmail());
		fetchedClient.setId(clientObj.getId());
		fetchedClient.setFname(clientObj.getFname());	
		fetchedClient.setLname(clientObj.getLname());
		fetchedClient.setMname(clientObj.getMname());
		fetchedClient.setPhone(clientObj.getPhone());
		fetchedClient.setPostal(clientObj.getPostal());
		fetchedClient.setState(clientObj.getState());
		fetchedClient.setStreet(clientObj.getStreet());
		// step 3: update
		return pRepo.save(fetchedClient);

	}

	// get on client
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable("id") long id) {
		// step 1: find client
		Client fetchedClient = pRepo.findById(id).orElseThrow(() -> {
			throw new ClientNotFoundException("Client does not exist with id " + id);
		});
		// step 2: delete
		pRepo.delete(fetchedClient);
		//pRepo.deleteById(id);
	}
}
