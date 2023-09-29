package com.order.app.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.app.model.Cart;
import com.order.app.model.Orders;
import com.order.app.model.UserProfile;
import com.order.app.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
    public Orders addOrder(int userId,Orders order, String headers) {
		
    	HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.AUTHORIZATION, headers);
		HttpEntity<String> entity = new HttpEntity<>("some body", header);
    	
    	
    	
		Cart cart = restTemplate.exchange("http://localhost:8097/cart/byUser/"+userId,HttpMethod.GET,entity, Cart.class).getBody();
		
		
		UserProfile profile = restTemplate.exchange("http://localhost:8095/api/user/"+userId,HttpMethod.GET,entity,
								UserProfile.class).getBody();
		
		System.out.println(profile);
		order.setItems(cart.getProductsAdded());
		order.setAddress(profile.getAddress());
		order.setAmountPaid(cart.getTotalPrice());
		order.setUserId(userId);
		order.setUsername(profile.getUserName());
		order.setOrderDate(LocalDate.now());
		
		order.setOrderStatus("Order Placed");
		return orderRepository.save(order);
	}

	// get all Order
	public List<Orders> getAllOrder() {
		return orderRepository.findAll();
	}

	// get Order by order id
	public Orders getOrderById(int orderId) {
	
		
	   Orders order= orderRepository.findById(orderId).get();
	
	   return order;
	   
	}
	
	
  // delete Order by id
	public String deleteOrderById(int orderId) {
		orderRepository.deleteById(orderId);
		return "Order Deleted  or Cancled Succesfully";
	}

	// get order by customer ID
	public List<Orders> getOrdersByUserId(int UserId) {
		
		List<Orders> orders = orderRepository.findByUserId(UserId);
		Collections.reverse(orders);
		return orders;

	}

	@Override
	public Orders cancelOrderByOrderId(int orderId) {
		Orders order = orderRepository.findById(orderId).get();
		order.setOrderStatus("Cancelled");
		return orderRepository.save(order);
		
	}
	
	@Override
	public Orders editOrder(int orderId) {
		Orders order = orderRepository.findById(orderId).get();
		order.setModeOfPayment("EWALLET");
		return orderRepository.save(order);
	
	}
	
	@Override
	public Orders editModeofPay(int orderId) {
		Orders order = orderRepository.findById(orderId).get();
	    order.setModeOfPayment("PAYMENT GATEWAY");
       	return orderRepository.save(order);
		
	}
	


}
