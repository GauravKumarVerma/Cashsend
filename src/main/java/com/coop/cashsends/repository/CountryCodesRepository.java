package com.coop.cashsends.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.CountryCodes;


public interface CountryCodesRepository  extends CrudRepository<CountryCodes, Integer>{
	
	 @Query("SELECT p FROM CountryCodes p WHERE p.countrycode = :countrycode")
	 CountryCodes countryPhoneCodes(String countrycode);

}
