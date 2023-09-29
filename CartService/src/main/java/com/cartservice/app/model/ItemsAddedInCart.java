package com.cartservice.app.model;





import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ItemsAddedInCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	
	private int productId;
	
	private String productName;
	 
	   
	private int quantity;
	 
	   
	 private double productPrice;
	 
	 @ElementCollection
	 private List<String> productImage;


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public List<String> getProductImage() {
		return productImage;
	}


	public void setProductImage(List<String> productImage) {
		this.productImage = productImage;
	}


	public ItemsAddedInCart(int itemId, int productId, String productName, int quantity, double productPrice,
			List<String> productImage) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}


	public ItemsAddedInCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

	
	
	
	   
	   

}
