package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.CountryManager;
import com.coop.cashsends.model.Partner;

public interface CountryManagerRepository extends CrudRepository<CountryManager, Integer> {
	
	@Query(value="SELECT * from country_manager where created_by= ?1 ",nativeQuery=true)
	List<CountryManager> countryManagers(String username);
	
	@Query("SELECT p FROM CountryManager p WHERE p.userid = :userid")
	CountryManager managerDetailsByUserId(Integer userid);
	
	
	 @Query("SELECT p FROM CountryManager p WHERE p.userid = :id")
	List<CountryManager> mycountrymanager(Integer id);

}
