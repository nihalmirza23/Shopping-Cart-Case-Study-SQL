package com.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.app.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByProductId(int productId);

}
