package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.webservice.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
