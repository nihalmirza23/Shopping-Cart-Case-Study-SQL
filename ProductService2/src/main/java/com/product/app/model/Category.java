package com.product.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int categoryId;
	
	@Column(unique = true)
	private String categoryName;
	
	
	@Column(length = 10000)
    private String imgUrl; 

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

	public Category(int categoryId, String categoryName, String imgUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.imgUrl = imgUrl;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", imgUrl=" + imgUrl + "]";
	}

	public Category() {
		
	}
	
	

	
	
	
	
	
	

}
