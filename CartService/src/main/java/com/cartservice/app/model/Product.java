package com.cartservice.app.model;

import java.util.List;
import java.util.Map;






public class Product {
	
	
	private int productid;
	
	
	private int merchantId;

	private String merchantName;
	
	
	private String productType;
	
	private String productName;

	
	
	private List<String> image;
	
	private double price;
	
	private String description;  
	
	private Map<String, String> specification;  
	
	
	private Category category;
	



	public Product(int productid, int merchantId, String merchantName, String productType, String productName, List<String> image, double price, String description, Map<String, String> specification,
			Category category) {
		super();
		this.productid = productid;
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.productType = productType;
		this.productName = productName;
		
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
		this.category = category;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}







	public int getProductid() {
		return productid;
	}




	public void setProductid(int productid) {
		this.productid = productid;
	}




	public int getMerchantId() {
		return merchantId;
	}




	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}




	public String getMerchantName() {
		return merchantName;
	}




	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}




	public String getProductType() {
		return productType;
	}




	public void setProductType(String productType) {
		this.productType = productType;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}





	public List<String> getImage() {
		return image;
	}




	public void setImage(List<String> image) {
		this.image = image;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}


	public Product() {
		
	}
	


}
