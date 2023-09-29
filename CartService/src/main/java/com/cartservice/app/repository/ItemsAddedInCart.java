package com.cartservice.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartservice.app.model.Cart;

public interface ItemsAddedInCart extends JpaRepository<Cart, Integer> {
		

	
	
}
