package com.coop.cashsends.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coop.cashsends.dto.SendMoneyTransactionDto;
import com.coop.cashsends.model.LovValue;
import com.coop.cashsends.model.SendMoneyTransaction;

@Repository
public interface SendMoneyTransactionRepository extends CrudRepository<SendMoneyTransaction, Integer> {
	
	@Query("SELECT p from SendMoneyTransaction p where p.id =:id ")
	 SendMoneyTransaction fetchTransaction(Integer id);

	@Query("SELECT p from SendMoneyTransaction p order by p.transactiondate desc  ")
	List<SendMoneyTransaction> findbyOrder();

	@Query("SELECT p from SendMoneyTransaction p where p.tellername IN (:tellers) order by p.transactiondate desc  ")
	//@Query("SELECT p from SendMoneyTransaction p order by p.transactiondate desc  ")
    List<SendMoneyTransaction> findbyOrderByTellers(String tellers);

	@Query("SELECT p from SendMoneyTransaction p where p.tfpin =:tfpin ")
	SendMoneyTransaction findbyTfPin(String tfpin);

	@Query("SELECT p from SendMoneyTransaction p where p.tellername =:username and p.transactiontype =:transactiontype order by  p.transactiondate desc ")
	List<SendMoneyTransaction> getTransactionsbyTeller(String username,String transactiontype);

	@Query(value="SELECT * from sendmoney_transaction where teller_name in(select user_name from user where created_by = ?1) and transaction_type =?2 order by transaction_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getTransactionsbyPartner(String username,String transactiontype);

	@Query(value="SELECT * from sendmoney_transaction where  date(transaction_date) =date(current_date()) order  by  transaction_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getSendTransactionsbyDate();
	
	@Modifying
	@Transactional
	@Query(value ="update sendmoney_transaction set status_id =?1 ,status_name =?2 where tfpin =?3 ",nativeQuery=true)
	int updatesendmoneytransaction(String statusid, String statusname, String tfpin);

	@Query(value="select TIMESTAMPDIFF(MINUTE,transaction_date,now())timediff from sendmoney_transaction where tfpin =?1 ",nativeQuery=true)
	int getTimeDiff(String tfpin);
	
	
	@Query(value="select *  from sendmoney_transaction where status_id in ('W','R','X','I') and transaction_type ='COOPTRANSFER'",nativeQuery=true)
	List<SendMoneyTransaction> getCoopTransferTransactions();

	@Modifying
	@Transactional
	@Query(value ="update sendmoney_transaction set status_id =?1 ,status_name =?2 where tfpin =?3 ",nativeQuery=true)
    int updateCoopTransfer(String web, String statusname,String tfpin);

	@Query("SELECT p from SendMoneyTransaction p where p.payingbranchid =:branchId and p.statusid =:statusid and p.transactiontype =:transactiontype order by  p.transactiondate desc ")
	List<SendMoneyTransaction> getTransactionsbyBranchId(String branchId,String statusid,String transactiontype);
   
	
	@Query("SELECT p from SendMoneyTransaction p where p.payerid =:userid and p.statusid =:statusid and p.transactiontype =:transactiontype order by  p.transactiondate desc ")
	List<SendMoneyTransaction> getTransactionsbyPartnerPayerId(String userid,String statusid, String transactiontype);

	@Query("SELECT p from SendMoneyTransaction p where p.tfpin =:tfpin and p.statusid =:statusid and p.payerid =:userid and p.transactioninfo.paymentmodeid IN (:types) order by  p.transactiondate desc ")
	SendMoneyTransaction findByTfpinAndPayerId(String tfpin ,String statusid,String userid,List<String> types);

	@Query("SELECT p from SendMoneyTransaction p where p.tfpin =:tfpin and p.statusid =:statusid and p.payingbranchid =:branchId"
			+ " and p.transactioninfo.paymentmodeid =:type order by  p.transactiondate desc ")
	SendMoneyTransaction findByTfpinAndBranch(String tfpin, String statusid, String branchId, String type);

	@Query(value="SELECT * from sendmoney_transaction  where paying_branch_id =?1 and status_id =?2 and transaction_type=?3 and"
			+ " DATE_FORMAT(updated_date, '%Y-%m-%d') between DATE_FORMAT(?4,'%Y-%m-%d')  and DATE_FORMAT(?5,'%Y-%m-%d') order by updated_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getTransactionsbyBranchIdAndDates(String branchId, String statusid, String transactiontype,
			String startdate, String enddate);
 
	@Query(value="SELECT * from sendmoney_transaction  where payer_id =?1 and status_id =?2 and transaction_type=?3 and "
			+ " DATE_FORMAT(updated_date, '%Y-%m-%d') between DATE_FORMAT(?4,'%Y-%m-%d')  and DATE_FORMAT(?5,'%Y-%m-%d') order by updated_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getTransactionsbyPartnerPayerIdDates(String payerid, String statusid, String transactiontype,
			String startdate, String enddate);
	
	
	@Query(value="SELECT * from sendmoney_transaction  where teller_name =?1 and transaction_type=?2 and "
			+ " DATE_FORMAT(transaction_date, '%Y-%m-%d') between DATE_FORMAT(?3,'%Y-%m-%d')  and DATE_FORMAT(?4,'%Y-%m-%d') order by transaction_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getTransactionsbyTellerdates(String username,String transactiontype,String startdate,String enddate);

	@Query(value="SELECT * from sendmoney_transaction where teller_name in(select user_name from user where created_by = ?1) and transaction_type =?2 "
			+ " and DATE_FORMAT(transaction_date, '%Y-%m-%d') between DATE_FORMAT(?3,'%Y-%m-%d')  and DATE_FORMAT(?4,'%Y-%m-%d') order by transaction_date desc",nativeQuery=true)	
	List<SendMoneyTransaction> getTransactionsbyPartnerdates(String username,String transactiontype,String startdate, String enddate);

	@Query(value ="select count(*)counts from sendmoney_transaction where payer_id =?1 and transaction_type= ?2 ",nativeQuery=true)
	int findbyCoopPartners(String partnerid, String transactiontype);
	
	@Query(value ="select count(*)counts from sendmoney_transaction where  transaction_type= ?1 and teller_name in(select user_name from user where created_by in (select user_name from user where id =?2)) ",nativeQuery=true)
	int findbyTransfastPartners(String transactiontype,String partnerid);
	
	@Query(value ="select count(*)counts from sendmoney_transaction where payer_id =?1 and transaction_type= ?2 and status_id in('W','R','X','I') ",nativeQuery=true)
	int findbyCoopPartnersbyStatus(String partnerid, String transactiontype);
	
	@Query(value ="select count(*)counts from sendmoney_transaction where status_id in('W','R','X','I') and  transaction_type= ?1 and teller_name in(select user_name from user where created_by in (select user_name from user where id =?2)) ",nativeQuery=true)
	int findbyTransfastPartnersbyStatus(String transactiontype,String partnerid);
  
	@Query(value ="select count(*)counts from sendmoney_transaction where payer_id =?1 and status_id ='P' ",nativeQuery=true)
	int findbyCoopPaidRecords(String payerid);

	
	
	

}
