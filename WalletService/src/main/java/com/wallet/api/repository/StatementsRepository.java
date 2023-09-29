package com.wallet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.api.model.Statement;

@Repository
public interface StatementsRepository extends JpaRepository<Statement, Integer> {




}
