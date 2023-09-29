package com.product.app.service;

import java.util.List;

import com.product.app.model.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	public Category getCategoryByName(String categoryName);
	public List<Category> getAllCategory();
	public Category getCategoryById(int categoryId);
	public void deleteCategoriesById(int categoryId);
}
