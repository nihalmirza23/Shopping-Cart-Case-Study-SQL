package com.cartservice.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
	
    private double totalPrice;

    @Column(unique = true)
    private int userId;

    private int totalItems;

    private int quantity;

    private int productId;
   

    @OneToMany( cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ItemsAddedInCart> productsAdded;


	public Cart(int cartId, double totalPrice, int userId, int totalItems, int quantity, int productId,
			List<ItemsAddedInCart> productsAdded) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.totalItems = totalItems;
		this.quantity = quantity;
		this.productId = productId;
		this.productsAdded = productsAdded;
	}


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTotalItems() {
		return totalItems;
	}


	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public List<ItemsAddedInCart> getProductsAdded() {
		return productsAdded;
	}


	public void setProductsAdded(List<ItemsAddedInCart> productsAdded) {
		this.productsAdded = productsAdded;
	}
    
    
    
    
}
