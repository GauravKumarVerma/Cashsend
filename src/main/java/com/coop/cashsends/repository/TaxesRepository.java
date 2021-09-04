package com.coop.cashsends.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.Taxes;

public interface TaxesRepository extends CrudRepository<Taxes, Integer> {

	 @Query("SELECT p FROM Taxes p WHERE p.countrycode = :countryiso")
	Taxes findByCountry(String countryiso);

}
