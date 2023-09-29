package com.product.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.jwtutil.JwtUtil;
import com.product.app.model.AuthenticationRequest;
import com.product.app.model.AuthenticationResponse;
import com.product.app.model.Category;
import com.product.app.repository.CategoryRepository;
import com.product.app.service.CategoryServiceImpl;
import com.product.app.service.MyUserDetails;


@RestController
@RequestMapping("/category")
//@CrossOrigin(origins = {"http://localhost:4200/"})
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private MyUserDetails myUserDetails;
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@GetMapping("/user/login")
	public String loginUser() {
		return "User Logged";
	}
	
	@PostMapping("/autnenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
				authenticationManager.
					authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password");
		}
		
		final UserDetails userDetails = myUserDetails.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category) {
		return categoryServiceImpl.addCategory(category);
		
	}
	
	@PostMapping("/addCategorys")
	public List<Category> addCategorys(@RequestBody List<Category> category) {
		return repository.saveAll(category);
		
	}
	
	//find by categoryName
	@GetMapping("/category/{categoryName}")
		public Category getCategoryByName(@PathVariable String categoryName) {
			return categoryServiceImpl.getCategoryByName(categoryName);
		}
		
    //get all Category APi
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		return categoryServiceImpl.getAllCategory();
	}
	
		//get all Category APi
		@DeleteMapping("/categories/{categoryId}")
		public String deleteCategoriesById(@PathVariable int categoryId){
			 categoryServiceImpl.deleteCategoriesById(categoryId);
			 return "deleted successfully";
		}
		
	@PutMapping("/categories/{categoryId}")
	public Category updateCategory(@RequestBody Category category,@PathVariable("categoryId") int categoryId) {
		
		Category category2=repository.findById(categoryId).orElseThrow();
		
		category2.setImgUrl(category.getImgUrl());
		
	return	repository.save(category2);
		
		
	}
	
	
	
}
