package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.PayerRecieverID;

public interface PayerRecieverIDRepository  extends CrudRepository<PayerRecieverID, Integer>{
	
	@Query("SELECT p FROM PayerRecieverID p WHERE p.CountryIsoCode =:countryIsoCode and p.status = :status")
	List<PayerRecieverID> findByCountryIsoCode(String countryIsoCode, boolean status);

}
