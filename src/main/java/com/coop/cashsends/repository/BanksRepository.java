package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.Banks;


public interface BanksRepository extends CrudRepository<Banks, Integer> {
	
	 @Query("SELECT p FROM Banks p WHERE p.CountryIsoCode = :countryIsoCode and p.status =:status")
	 List<Banks> getbanks(String countryIsoCode,boolean status);	

}
