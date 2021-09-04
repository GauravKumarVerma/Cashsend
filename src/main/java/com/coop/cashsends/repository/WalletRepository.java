package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {
	
	@Query("SELECT p FROM Wallet p WHERE p.partner.id = :partnerid")
	 List<Wallet> findwalletbyUser(Integer partnerid);
	
	@Query("SELECT p FROM Wallet p WHERE p.id = :walletid")
	 Wallet findwalletbyID(Integer walletid);

	@Query("SELECT p FROM Wallet p WHERE p.partner.id = :id and p.accountcode =:code")
	Wallet findwalletbyUserAndCode(Integer id, String code);

}
