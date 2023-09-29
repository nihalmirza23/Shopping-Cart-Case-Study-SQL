package com.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);

	Product findByProductName(String productName);

	List<Product> findByProductType(String producttype);

	List<Product> findByMerchantId(int merchantId);

	List<Product> findByCategoryId(int categoryId);


	
	
	

}
