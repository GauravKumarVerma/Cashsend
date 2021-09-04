package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.PayerErrorCodes;

public interface PayerErrorCodesRepository  extends CrudRepository<PayerErrorCodes, Integer> {

	@Query("SELECT p FROM PayerErrorCodes p WHERE p.status = :status")
	List<PayerErrorCodes> findActiveErrorCodes(boolean status);

}
