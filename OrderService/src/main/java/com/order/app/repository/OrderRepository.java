package com.order.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.app.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findByUserId(int userId);

}
