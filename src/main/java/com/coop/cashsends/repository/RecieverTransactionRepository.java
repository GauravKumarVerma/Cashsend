package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.dto.RecieverTransactionDto;
import com.coop.cashsends.model.LovValue;
import com.coop.cashsends.model.RecieverTransaction;

public interface RecieverTransactionRepository extends CrudRepository<RecieverTransaction, Integer> {
	
 
	@Query(value="SELECT * from reciever_transaction  where DATE_FORMAT(created_date, '%M %d,%Y') between DATE_FORMAT(?1,'%M %d,%Y')  and DATE_FORMAT(?2,'%M %d,%Y') order by created_date desc",nativeQuery=true)	
     List<RecieverTransaction> getallPaidTransactions(String fromdate, String todate);

	@Query("SELECT p FROM RecieverTransaction p WHERE p.tfpin = :tfpin")
	RecieverTransaction getPaidTransactionbyTfPin(String tfpin);
	
	@Query(value="SELECT * from reciever_transaction  where DATE_FORMAT(created_date, '%M %d,%Y') between DATE_FORMAT(?1,'%M %d,%Y')  and DATE_FORMAT(?2,'%M %d,%Y') and  created_by in(?3) or created_by in(select user_name from user where created_by =?4 ) order by created_date desc",nativeQuery=true)	
    List<RecieverTransaction> getallPaidTransactionsPartner(String fromdate, String todate,String partnername,String name);

	@Query("SELECT p from RecieverTransaction p order by p.transactiondate desc  ")
	List<RecieverTransaction> findbyOrder();

	@Query("SELECT p from RecieverTransaction p  order by p.transactiondate desc  ")
	List<RecieverTransaction> findbyPartnerName(String username);

   @Query(value ="select count(*)counts from reciever_transaction where payer_id =?1 ",nativeQuery=true)
	int findbyTransfastPaidRecords(String payerid);
	
	
	
}
