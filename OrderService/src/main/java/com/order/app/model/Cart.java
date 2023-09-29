package com.order.app.model;

import java.util.List;


public class Cart {
	
    private int cartId;
	
    private double totalPrice;
    
    
    private int userId;
    
   private String productName;
   private int quantity;
   private double productPrice;
   
   private List<ItemsAddedInCart> productsAdded;


	public void setProductsAdded(List<ItemsAddedInCart> productsAdded) {
	this.productsAdded = productsAdded;
}


	public Cart(int cartId, double totalPrice, int userId, String productName, int quantity, double productPrice) {
	super();
	this.cartId = cartId;
	this.totalPrice = totalPrice;
	this.userId = userId;
	this.productName = productName;
	this.quantity = quantity;
	this.productPrice = productPrice;
}


	public int getQuantity() {
	return quantity;
}



public List<ItemsAddedInCart> getProductsAdded() {
		return productsAdded;
	}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


	public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}



public double getProductPrice() {
	return productPrice;
}


public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
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

	
    
    
    
}
