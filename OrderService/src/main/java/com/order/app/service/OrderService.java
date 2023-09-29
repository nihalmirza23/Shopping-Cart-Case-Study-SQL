package com.order.app.service;

import java.util.List;

import com.order.app.model.Address;
import com.order.app.model.Orders;

public interface OrderService {


	public List<Orders> getAllOrder();

	public Orders getOrderById(int orderId);

	public String deleteOrderById(int orderId);

	public List<Orders> getOrdersByUserId(int UserId);

	public Orders cancelOrderByOrderId(int orderId);

	public Orders editOrder(int orderId);
	
	public Orders editModeofPay(int orderId);

	
	
	
	
	
}
