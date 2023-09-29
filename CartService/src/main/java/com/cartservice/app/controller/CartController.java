package com.cartservice.app.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.app.filter.JwtFilter;
import com.cartservice.app.model.AuthenticationRequest;
import com.cartservice.app.model.AuthenticationResponse;
import com.cartservice.app.model.Cart;
import com.cartservice.app.service.CartServiceImpl;
import com.cartservice.app.service.MyUserDetails;
import com.cartservice.app.util.JwtUtil;




@RestController
@RequestMapping("/cart")
//@CrossOrigin(origins = {"http://localhost:4200/"})
public class CartController {
	
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetails myUserDetails;
	 
	 
	
	@GetMapping("/user/login")
	public String loginUser() {
		return "User Logged";
	}
	
	
	
	@PostMapping("/addcart/{userId}")
	public Cart AddCart(@RequestBody Cart cart, @PathVariable("userId") int userId) {
		return cartServiceImpl.AddCart(cart, userId);
	}
	
	@GetMapping("/getCart/{cartId}")
	public Cart getByCartId(@PathVariable("cartId") int cartId) {
		return cartServiceImpl.getByCartId(cartId);
	}
	
	@PostMapping("/add/quantity/{userId}/{productId}/{quantity}")
	public Cart AddQuantityOfProduct(@PathVariable("userId")int userId,
		@PathVariable("productId")	int productId,@PathVariable("quantity") int quantity) {
		return cartServiceImpl.AddQuantityOfProduct(userId, productId, quantity);
	}
	
	@GetMapping("/byUser/{userId}")
	public Cart getCartByUserId( @PathVariable("userId") int userId) {
		return cartServiceImpl.getCartByUserId(userId);
	}
	
	@DeleteMapping("/delete/{cartId}")
	public String deleteCart(@PathVariable("cartId") int cartId) {
		return cartServiceImpl.deleteCart(cartId);
	}
	
	@GetMapping("/carts")
	public List<Cart> getAllCarts(){
		return cartServiceImpl.getAllCarts();
	}
	
	@PostMapping("/remove/quantity/{userId}/{productId}/{quantity}")
	public Cart RemoveQuantityOfProduct(@PathVariable("userId") int userId, 
			@PathVariable("productId")	int productId, 
			@PathVariable("quantity")Integer quantity) {
		return cartServiceImpl.RemoveQuantityOfProduct(userId, productId, quantity);
	}
	@PostMapping("/add/items/{userId}/{productId}/{quantity}")
	public Cart addMoreProductsInCart(@PathVariable("userId") int userId,
			@PathVariable("productId")	int productId,
			@PathVariable("quantity")Integer quantity) {
		return cartServiceImpl.addMoreProductsInCart(userId, productId, quantity);
	}
	@PutMapping("/remove/item/{userId}/{productId}")
	public Cart deleteItem(@PathVariable("userId")  int userId, @PathVariable("productId")
	int productId) {
		return cartServiceImpl.deleteItem(userId, productId);
	}
	
	
	@PutMapping("/removeall/{cartId}")
    public Cart removeAllItemInCart(@PathVariable("cartId") int cartId) {
    	return cartServiceImpl.removeAllItemInCart(cartId);
    }
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = myUserDetails
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	
	
	}
	
	
