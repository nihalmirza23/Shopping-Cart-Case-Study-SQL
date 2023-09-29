package com.order.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.app.model.ItemsAddedInCart;

@Repository
public interface ItemsAddedRepo extends JpaRepository<ItemsAddedInCart, Integer>{

}
