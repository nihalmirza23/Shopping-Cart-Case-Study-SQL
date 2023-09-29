package com.order.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.app.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
