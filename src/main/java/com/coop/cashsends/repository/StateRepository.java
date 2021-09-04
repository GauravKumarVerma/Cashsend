package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.State;

public interface StateRepository extends CrudRepository<State, Integer> {
	
	@Query("SELECT p FROM State p WHERE p.CountryIsoCode = :isocode and p.status =:status")
	 List<State> getstates(String isocode,boolean status);
	

}
