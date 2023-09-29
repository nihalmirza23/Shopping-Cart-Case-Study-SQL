package com.cartservice.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cartservice.app.model.Cart;
import com.cartservice.app.model.Product;

public interface CartService {
	
	public Cart AddCart(Cart cart,int userId);
	public Cart getByCartId(int cartId);
	public Cart getCartByUserId(int userId);
	public String deleteCart(int cartId);
	public Cart deleteItem(int userId,int productId);
	public List<Cart> getAllCarts();
	public Cart AddQuantityOfProduct(int userId, int productId, int quantity);
	public Cart RemoveQuantityOfProduct(int userId, int productId, int quantity);
		
	public Cart addMoreProductsInCart(int cartId, int productId, int quantity);
	public Cart removeAllItemInCart(int cartId);
}
