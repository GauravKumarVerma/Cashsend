package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.coop.cashsends.model.TellerTransactions;

public interface TellerTransactionsRepository  extends CrudRepository<TellerTransactions, Integer>{
  
	 @Query(value="SELECT * from teller_transactions order by created_date desc",nativeQuery=true)
	 List<TellerTransactions> findByCreatedDate();
	 
	 @Query(value="SELECT * from teller_transactions where teller_id in(select id from tellers where created_by =?1) order by created_date desc",nativeQuery=true)
	 List<TellerTransactions> findBytransactionsbyAgent(String username);
	 
	 @Query(value="SELECT * from teller_transactions where teller_id in(select id from tellers where created_by =(select user_name from user where id in(select id from agent where created_by =?1))) order by created_date desc",nativeQuery=true)
	 List<TellerTransactions> findBytransactionsbyManager(String username);

}
