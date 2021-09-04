package com.coop.cashsends.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.GrantedAuthority;

import com.coop.cashsends.model.Partner;
import com.coop.cashsends.model.User;

public interface PartnerRepository extends CrudRepository<Partner, Integer> {
	
	 @Query(value="SELECT * from partner where created_by= ?1 order by business_name asc  ",nativeQuery=true)
		List<Partner> allPartners(String username);
	 
	 @Query("SELECT p FROM Partner p WHERE p.userid = :userid")
	 Partner partnerDetailsByUserId(Integer userid);

	 @Query("SELECT p FROM Partner p WHERE p.userid = :id")
	List<Partner> partnerdetails(Integer id);

	 @Query("SELECT p FROM Partner p order by p.businessname asc")
	List<Partner> findAllByOrder();

}
