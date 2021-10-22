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

import com.simplilearn.webservice.entity.Cart;
import com.simplilearn.webservice.repository.CartRepository;
import com.simplilearn.webservice.exceptions.InvalidCartException;
import com.simplilearn.webservice.exceptions.CartNotFoundException;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	CartRepository pRepo;

	// list all carts
	@GetMapping("/carts")
	public List<Cart> getCarts() {
		List<Cart> list = pRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new CartNotFoundException("Cart list is empty !");
	}

	// get on cart
	@GetMapping("/carts/{id}")
	public Cart getCarts(@PathVariable("id") long id) {
		Cart fetchedCart = pRepo.findById(id).orElseThrow(() -> {
			throw new CartNotFoundException("Cart does not exist with id " + id);
		});
		return fetchedCart;
	}

	// create cart
	@PostMapping("/carts")
	public Cart addCart(@RequestBody(required=false) Cart cartObj) {
		if(cartObj !=null) {
			return pRepo.save(cartObj);
		}
		throw new InvalidCartException("Cart creation failed ! missing project object !");
	}

	// update cart
	@PutMapping("/carts")
	public Cart updateCart(@RequestBody Cart cartObj) {
		// step 1: find cart
		Cart fetchedCart = pRepo.findById(cartObj.getId()).orElseThrow(() -> {
			throw new CartNotFoundException("Cart does not exist with id " + cartObj.getId());
		});
		// step 2: Map updating fields
		fetchedCart.setCustomerId(cartObj.getCustomerId());
		
		
		fetchedCart.setProductIds(cartObj.getProductIds());
		fetchedCart.setTotal(cartObj.getTotal());
		// step 3: update
		return pRepo.save(fetchedCart);

	}

	// get on cart
	@DeleteMapping("/carts/{id}")
	public void deleteCart(@PathVariable("id") long id) {
		// step 1: find cart
		Cart fetchedCart = pRepo.findById(id).orElseThrow(() -> {
			throw new CartNotFoundException("Cart does not exist with id " + id);
		});
		// step 2: delete
		pRepo.delete(fetchedCart);
	}
}
