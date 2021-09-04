package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.SenderTypes;

public interface SenderTypesRepository extends CrudRepository<SenderTypes, Integer> {
	
	@Query("SELECT p FROM SenderTypes p WHERE p.CountryIsoCode = :countryIsoCode and p.status =:status")
	 List<SenderTypes> getSenderTypes(String countryIsoCode,boolean status);	

}
