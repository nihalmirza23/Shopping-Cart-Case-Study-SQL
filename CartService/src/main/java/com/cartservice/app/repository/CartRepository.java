package com.cartservice.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cartservice.app.model.Cart;


public interface CartRepository extends JpaRepository<Cart,Integer>  {

	Optional<Cart> findByUserId(int userId);
	
	//List<Cart> findByCartId(int cartId);

}
