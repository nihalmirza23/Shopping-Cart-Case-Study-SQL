package com.product.app.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.app.model.Review;
import com.product.app.model.UserProfile;
import com.product.app.repository.ReviewRepository;


@RestController
@RequestMapping("/review")
//@CrossOrigin(origins = {"http://localhost:4200/"})
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/getallreview")
	public List<Review> getReview() {
		
		return reviewRepository.findAll();
	}
	
	@GetMapping("/getreview/{pid}")
	public List<Review> getReviewByProductId(@PathVariable("pid") int productId) {
		
		List<Review> ratings = reviewRepository.findByProductId(productId);
		Collections.reverse(ratings);
		return ratings;
	}
	
	@PostMapping("/postreview/{pid}/{uid}")
	public Review postReviewByUser(@RequestBody Review review,
											@PathVariable("pid") int productId,
											@PathVariable("uid") int userId) {
		review.setProductId(productId);
		review.setUserId(userId);
		UserProfile profile=restTemplate.getForObject("http://localhost:8095/api/user/"+userId, UserProfile.class);
		review.setUserName(profile.getFullName());
		return reviewRepository.save(review);
		
	}
	
}
