package com.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallet.api.model.EWallet;

@Repository
public interface EWalletRepository extends JpaRepository<EWallet,Integer> {

	

	EWallet findByUserId(int userId);

}
