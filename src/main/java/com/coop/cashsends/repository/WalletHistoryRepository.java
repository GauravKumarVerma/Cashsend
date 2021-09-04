package com.coop.cashsends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.coop.cashsends.model.LovValue;
import com.coop.cashsends.model.WalletHistory;


public interface WalletHistoryRepository extends  CrudRepository<WalletHistory, Integer> {
	
	@Query("SELECT p FROM WalletHistory p WHERE p.walletid = :walletid")
	 List<WalletHistory> walletHistoryById(Integer walletid);

	@Query( value ="SELECT * from wallet_history where partner_id =?1 and account_code =?2 and  "
			+ " DATE_FORMAT(updated_date, '%Y-%m-%d') between DATE_FORMAT(?3,'%Y-%m-%d')  and DATE_FORMAT(?4,'%Y-%m-%d') order by updated_date desc",nativeQuery =true)
	List<WalletHistory> walletHistoryByDates(Integer partnerid, String accountcode, String startdate, String enddate);
	 	

}
