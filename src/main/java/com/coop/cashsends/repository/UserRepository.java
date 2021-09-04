package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.coop.cashsends.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	 User findByUsername(String username);

	 @Query("SELECT p FROM User p WHERE p.mobilenumber = :mobilenumber")
	 User findByMobile(long mobilenumber);
	 
	 @Query("SELECT p FROM User p WHERE p.email = :email")
	 User findByEmail(@Param("email") String email);
	 
	  @Query(value = "SELECT cashsends_seq('sq_my_sequence') as account_next_sequence", nativeQuery = true)
	    String uniqueSequenceNumber();
	  
	  @Query("SELECT p FROM User p JOIN Role r WHERE r.name=:rolename")
	  List<User>insuranceCompanyForApproval(String rolename);

	  @Query(value = "select GROUP_CONCAT(user_name)tellers from user where created_by =?1", nativeQuery = true)
	String findByPartners(String username);
	  
	  @Query(value = "SELECT trans_seq('sq_my_sequence') as account_next_sequence", nativeQuery = true)
	    String uniqueTransactionNumber();
}
