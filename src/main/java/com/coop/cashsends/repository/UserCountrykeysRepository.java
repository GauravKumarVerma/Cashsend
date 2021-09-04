package com.coop.cashsends.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coop.cashsends.model.TransfastRouter;
import com.coop.cashsends.model.UserCountrykeys;

@Repository
public interface UserCountrykeysRepository extends CrudRepository<UserCountrykeys, Integer> {
	
	@Query("SELECT p FROM UserCountrykeys p WHERE p.countryid = :countryid and p.transactiontype =:transactiontype")
	UserCountrykeys finbyCountryAndUser(String countryid,String transactiontype);

}
