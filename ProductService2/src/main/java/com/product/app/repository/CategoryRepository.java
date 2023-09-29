package com.product.app.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.product.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);

}
