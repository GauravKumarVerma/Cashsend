package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.PayerDetails;

public interface PayerDetailsRepository extends CrudRepository<PayerDetails, Integer>  {

	@Query("SELECT p FROM PayerDetails p WHERE p.PayerRefId = :payerId and p.status =:status")
	List<PayerDetails> findbyPayerid(Integer payerId,boolean status);

}
