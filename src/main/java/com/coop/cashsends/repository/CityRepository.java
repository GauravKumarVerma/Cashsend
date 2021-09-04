package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.model.City;


public interface CityRepository extends CrudRepository<City, Integer>{
	
	 @Query("SELECT p FROM City p WHERE p.CountryIsoCode = :isocode and p.StateId =:stateid and p.status =:status")
	 List<City> getCities(String isocode, String stateid,boolean status);

	 @Query("SELECT p FROM City p WHERE p.StateId =:stateId and p.status =:status")
	List<City> getcitiesbystate(String stateId, boolean status);

}
