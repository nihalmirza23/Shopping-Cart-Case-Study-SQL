package com.order.app.model;

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
	private int id;
	
	private String productName;
	 
	private int quantity;
	   
	private double productPrice;
	   
	@ElementCollection
	private List<String> productImage;
	   
	private int productId;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public ItemsAddedInCart(int id, String productName, int quantity, double productPrice,
				List<String> productImage, int productId) {
			super();
			this.id = id;
			this.productName = productName;
			this.quantity = quantity;
			this.productPrice = productPrice;
			this.productImage = productImage;
			this.productId = productId;
		}

		public ItemsAddedInCart() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "ItemsAddedInCart [id=" + id + ", productName=" + productName + ", quantity=" + quantity
					+ ", productPrice=" + productPrice + ", productId=" + productId + "]";
		}
	   
	   
	
	   

}
