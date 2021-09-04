package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.model.Town;

public interface TownRepository extends CrudRepository<Town, Integer>{
	
	 @Query("SELECT p FROM Town p WHERE p.CountryIsoCode = :countryIsoCode and p.StateId =:stateId and p.CityId =:cityid and p.status =:status")
	 List<Town> gettowns(String countryIsoCode, String stateId,Integer cityid,boolean status);

	 @Query("SELECT p FROM Town p WHERE  p.CityId =:cityid and p.status =:status")
	List<Town> getTownsbycity(Integer cityid, boolean status);	

}
