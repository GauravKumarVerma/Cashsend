package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.Country;


public interface CountryRepository extends CrudRepository<Country, Integer> {

	@Query("select p from Country p where p.status =:status ")
	List<Country> findActiveCountries(boolean status);

	@Query("select p from Country p where p.IsoCode =:countryIsoCode ")
	Country findbyCountryCode(String countryIsoCode);

}
