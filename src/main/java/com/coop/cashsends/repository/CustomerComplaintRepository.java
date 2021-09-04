package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.CustomerComplaints;
import com.coop.cashsends.model.LovValue;

public interface CustomerComplaintRepository extends CrudRepository<CustomerComplaints, Integer>{
    
	@Query("SELECT p FROM CustomerComplaints p where p.tfpin= :tfpin")
	CustomerComplaints findByTfpin(String tfpin);
  
	@Query(value ="SELECT * from customer_complaints order by updated_date desc ",nativeQuery = true)
    List<CustomerComplaints> findByOrder();
   
	@Query(value ="SELECT * from customer_complaints where created_by =?1 order by updated_date desc ",nativeQuery = true)
	List<CustomerComplaints> findByUserName(String username);

	@Query(value ="SELECT * from customer_complaints where created_by =?1 or created_by in (select user_name from user where created_by= ?2) order by updated_date desc ",nativeQuery = true)
    List<CustomerComplaints> findByPartnerName(String username,String username1);
	
	

}
