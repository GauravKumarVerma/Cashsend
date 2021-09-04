package com.coop.cashsends.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;

import com.coop.cashsends.model.Teller;

public interface TellerRepository extends CrudRepository<Teller, Integer> {

	 @Query(value="SELECT * from tellers where created_by= ?1 ",nativeQuery=true)
	 List<Teller> allTellers(String username);

	 @Query("SELECT p FROM Teller p WHERE p.partnerid =:partnerid")
	List<Teller> tellersForadmmin(Integer partnerid);
	 
	 @Query("SELECT p FROM Teller p WHERE p.userid =:userid")
		Teller tellerByUserID(Integer userid);

	 

}
