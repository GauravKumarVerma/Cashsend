package com.coop.cashsends.service;

import java.util.List;

import com.coop.cashsends.dto.CancelorComplaintDto;
import com.coop.cashsends.dto.ComplaintStatusDto;
import com.coop.cashsends.dto.CoopRecieverTransactionDto;
import com.coop.cashsends.dto.CreditLimitDto;
import com.coop.cashsends.dto.CustomerCommentsDto;
import com.coop.cashsends.dto.CustomerComplaintsDto;
import com.coop.cashsends.dto.PaidDto;
import com.coop.cashsends.dto.PendingListsDto;
import com.coop.cashsends.dto.RecieverPendingDto;
import com.coop.cashsends.dto.RecieverTransactionDto;
import com.coop.cashsends.dto.SendMoneyDto;
import com.coop.cashsends.dto.SendMoneyTransactionDto;
import com.coop.cashsends.dto.TellerTransactionsDto;
import com.coop.cashsends.dto.TransactionDto;
import com.coop.cashsends.dto.WalletHistoryDto;
import com.coop.cashsends.exception.TransactionServiceException;

public interface TransactionService {

	String sendMoney(TransactionDto TransactionDto, String username) throws TransactionServiceException;

	String SendMoneylocal(TransactionDto transactionDto);

	String cancelTransaction(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException;;

	String raiseComplaint(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException;

	List<TellerTransactionsDto> telleractivity();

	List<TellerTransactionsDto> tellerActivityagent(String username);

	List<TellerTransactionsDto> tellerActivitymanager(String username);

	List<WalletHistoryDto> walletHistory(Integer walletid)throws TransactionServiceException;

	int creditLimit(CreditLimitDto creditLimitDto)throws TransactionServiceException;

	List<SendMoneyTransactionDto> allTransactions(Integer partnerid)throws TransactionServiceException;

	List<RecieverTransactionDto> recievertransactions(String startdate, String enddate, String role, String username)throws TransactionServiceException;

	String recieveMoney(PaidDto paidDto, String username)throws TransactionServiceException;

	RecieverTransactionDto paidtransction(String tfpin)throws TransactionServiceException;

	SendMoneyTransactionDto sendmoneytractions(String tfpin)throws TransactionServiceException;

	List<RecieverTransactionDto> recievertransactions(Integer partnerid);

	List<PendingListsDto> pendingLists(String countrycode) throws TransactionServiceException;

	int savePendingList(RecieverPendingDto recieverPendingDto) throws TransactionServiceException;

	int deletePendinglists(String tfpin)throws TransactionServiceException;

	String reciverComplaint(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException;

	List<SendMoneyTransactionDto> retrivesendmoneytractions(Integer userid, String rolename,String transactiontype,String startdate,String enddate)throws TransactionServiceException;

	String coopSendMoney(TransactionDto transactionDto, String username)throws TransactionServiceException;

	String coopTranfercancel(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException;

	String coopTransfercomplaint(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException;

	List<SendMoneyTransactionDto> recieversendtransaction(Integer userid, String rolename, String transactiontype,String startdate,String enddate)throws TransactionServiceException;

	SendMoneyTransactionDto recievertansactionbytfpin(String tfpin,String statusid,Integer userid, String rolename)throws TransactionServiceException;

	String cooprecievemoney(PaidDto paidDto, String username)throws TransactionServiceException;

	List<SendMoneyTransactionDto> cooppaidtransaction(Integer userid, String rolename, String transactiontype, String startdate,
			String enddate)throws TransactionServiceException;

	CoopRecieverTransactionDto paidtransactiobyTfpin(String tfpin)throws TransactionServiceException;

	int sendtransfers(Integer partnerid, String transactiontype, String statusid)throws TransactionServiceException;

	int complaintscomments(CustomerCommentsDto customerCommentsDto)throws TransactionServiceException;

	int updatecomplaintstatus(String tfpin, String status)throws TransactionServiceException;

	List<ComplaintStatusDto> complaintstatuses(String status)throws TransactionServiceException;

	List<CustomerComplaintsDto> coopTransfercomplaint(Integer userid, String role)throws TransactionServiceException;

	List<WalletHistoryDto> walletHistory(Integer partnerid, String accountcode, String startdate, String enddate);
	
	

}
