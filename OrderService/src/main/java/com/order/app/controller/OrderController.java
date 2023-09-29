package com.order.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.model.Orders;
import com.order.app.service.OrderServiceImpl;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:4200/"})
public class OrderController  {

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	// Post order
	@ApiOperation("add order method")
	@PostMapping("/order/{userId}")
	public Orders addOrder(@PathVariable("userId") int userId,@RequestBody Orders order,
			@RequestHeader(HttpHeaders.AUTHORIZATION)String headers) {
		logger.trace("add order method accessed");
		return orderServiceImpl.addOrder(userId, order,headers);		
	}

	// get all Order
	@ApiOperation("get all order method")
	@GetMapping("/allorder")
	public List<Orders> getAllOrder() {
		logger.trace("get all order method accessed");
		List<Orders> OrderList = orderServiceImpl.getAllOrder();

		return OrderList;
	}

	// get All Order by OrderId
	@ApiOperation("get order by Id method")
	@GetMapping("/allorder/{orderId}")
	public Orders getOrderById(@PathVariable("orderId") int orderId) {
		logger.trace("get order by Id method accessed");
	        Orders order=orderServiceImpl.getOrderById(orderId);
		return order;
	}

  	//Delete Order By id
	@ApiOperation("Delete order by orderId")
	@DeleteMapping("/delete/{orderId}")
	public String deleteOrderById(@PathVariable("orderId") int orderId) {
		logger.trace("Delete order by orderId method accessed");
		return orderServiceImpl.deleteOrderById(orderId);
	}
	
	// get All Order by OrderId
	@ApiOperation("get all orders by user Id method")
	@GetMapping("/allorder/byuser/{userId}")
	public List<Orders> getOrderByUserId(@PathVariable("userId") int userId) {
		logger.trace("get order by Id method accessed");
		return orderServiceImpl.getOrdersByUserId(userId);
		
	}
	
	//cancel order by order Id
	@ApiOperation("cancel order by order Id method")
	@PutMapping("/allorder/cancelorder/{orderId}")
	public Orders cancelOrderByOrderId(@PathVariable("orderId") int orderId) {
		logger.trace("cancel order by order Id method");
		return orderServiceImpl.cancelOrderByOrderId(orderId);
		
	}
	@PutMapping("/allorder/editorder/{orderId}")
	public Orders editOrder(@PathVariable("orderId") int orderId) {
		return orderServiceImpl.editOrder(orderId);
	}
	
	@PutMapping("/allorder/editorder/paymentmode/{orderId}")
	public Orders editModeofPay(@PathVariable("orderId")  int orderId) {
		return orderServiceImpl.editModeofPay(orderId);
	}
	
}
