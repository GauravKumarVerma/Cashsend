package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.PayerRemittance;

public interface PayerRemittanceRepository  extends CrudRepository<PayerRemittance, Integer>{
	
	@Query("SELECT p FROM PayerRemittance p WHERE p.CountryIsoCode =:countryIsoCode and p.status = :status")
	List<PayerRemittance> findActiveRemittance(String countryIsoCode, boolean status);

}
