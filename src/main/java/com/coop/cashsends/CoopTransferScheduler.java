package com.coop.cashsends;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.coop.cashsends.model.SendMoneyTransaction;
import com.coop.cashsends.model.TransactionHistory;
import com.coop.cashsends.repository.SendMoneyTransactionRepository;
import com.coop.cashsends.repository.TransactionHistoryRepository;

@Component
public class CoopTransferScheduler {

	@Autowired
	 private SendMoneyTransactionRepository sendMoneyTransactionRepository;
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	
	public static final String PENDING_RELEASE ="R";
	public static final String WEB ="W";
	public static final String PRE_STORE ="X";
	public static final String INPROCESS ="I";
	public static final String TRANSMIT ="T";
	
	public static final String PENDING_RELEASE_NAME ="PENDINGRELEASE";
	public static final String WEB_NAME ="WEB";
	public static final String PRE_STORE_NAME ="PRESTORE";
	public static final String INPROCESS_NAME ="INPROCESS";
	public static final String TRANSMIT_NAME ="TRANSMIT";
	 
	//@Scheduled(cron = "0 * * * * ?")
    public void TransactionWorkFlow() {
	  
	 try {
		 List<SendMoneyTransaction> sendMoneyTransactions =null;
		 sendMoneyTransactions = sendMoneyTransactionRepository.getCoopTransferTransactions();
		 for (SendMoneyTransaction stats : sendMoneyTransactions) {
			 
		  String tfpin =stats.getTfpin();
		  String status = stats.getStatusid();
		  String statusid = null;
		  String statusname = null;
		  
		  int timediff = sendMoneyTransactionRepository.getTimeDiff(tfpin);
		   if(timediff >=1  && status.equalsIgnoreCase(PENDING_RELEASE)) {
			   // 
		   sendMoneyTransactionRepository.updateCoopTransfer(WEB,WEB_NAME,tfpin);
		   statusid =WEB;
		   statusname =WEB_NAME;
		   TransactionHistory transactionHistory = null;
			transactionHistory = new TransactionHistory();
			transactionHistory.setStatusid(statusid);
			transactionHistory.setStatusname(statusname);
			transactionHistory.setTfpin(tfpin);
			transactionHistoryRepository.save(transactionHistory);
		  }
		   else if(timediff >=10  && status.equalsIgnoreCase(WEB)) {
			   // 
		   sendMoneyTransactionRepository.updateCoopTransfer(PRE_STORE,PRE_STORE_NAME,tfpin);
		   statusid =PRE_STORE;
		   statusname =PRE_STORE_NAME;
		   TransactionHistory transactionHistory = null;
			transactionHistory = new TransactionHistory();
			transactionHistory.setStatusid(statusid);
			transactionHistory.setStatusname(statusname);
			transactionHistory.setTfpin(tfpin);
			transactionHistoryRepository.save(transactionHistory);
		  }
		   else if(timediff >=11  && status.equalsIgnoreCase(PRE_STORE)) {
			   // 
		   sendMoneyTransactionRepository.updateCoopTransfer(INPROCESS,INPROCESS_NAME,tfpin);
		   statusid =INPROCESS;
		   statusname =INPROCESS_NAME;
		   TransactionHistory transactionHistory = null;
			transactionHistory = new TransactionHistory();
			transactionHistory.setStatusid(statusid);
			transactionHistory.setStatusname(statusname);
			transactionHistory.setTfpin(tfpin);
			transactionHistoryRepository.save(transactionHistory);
		  }else if(timediff >=12  && status.equalsIgnoreCase(INPROCESS)) {
			   // 
		   sendMoneyTransactionRepository.updateCoopTransfer(TRANSMIT,TRANSMIT_NAME,tfpin);
		   statusid =TRANSMIT;
		   statusname =TRANSMIT_NAME;
		   TransactionHistory transactionHistory = null;
			transactionHistory = new TransactionHistory();
			transactionHistory.setStatusid(statusid);
			transactionHistory.setStatusname(statusname);
			transactionHistory.setTfpin(tfpin);
			transactionHistoryRepository.save(transactionHistory);
		  }
		   
		    
		   
		 }
		 
		 
	 }catch(Exception e) {
		 
	 }
	 
	}
}
