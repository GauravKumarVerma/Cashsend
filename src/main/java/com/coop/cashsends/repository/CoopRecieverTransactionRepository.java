package com.coop.cashsends.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.CoopRecieverTransaction;


public interface CoopRecieverTransactionRepository extends CrudRepository<CoopRecieverTransaction, Integer> {

	@Query("SELECT p FROM CoopRecieverTransaction p WHERE  p.tfpin =:tfpin ")
	CoopRecieverTransaction getbyTfPin(String tfpin);

}
