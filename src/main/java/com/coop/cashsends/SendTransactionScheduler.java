package com.coop.cashsends;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coop.cashsends.dto.PendingListsDto;
import com.coop.cashsends.dto.SendMoneyResponseDto;
import com.coop.cashsends.model.LovType;
import com.coop.cashsends.model.PendingLists;
import com.coop.cashsends.model.SendMoneyTransaction;
import com.coop.cashsends.model.TransfastRouter;
import com.coop.cashsends.model.UserCountrykeys;
import com.coop.cashsends.repository.LovTypesRepository;
import com.coop.cashsends.repository.PendingListsRepository;
import com.coop.cashsends.repository.SendMoneyTransactionRepository;
import com.coop.cashsends.repository.TransfastRoutersRepository;
import com.coop.cashsends.repository.UserCountrykeysRepository;

@Component
public class SendTransactionScheduler {
	
	RestTemplate restTemplate;
	
	 @Autowired
	 private SendMoneyTransactionRepository sendMoneyTransactionRepository;
	 
	 @Autowired
	 private LovTypesRepository lovTypesRepository;
	 
	 @Autowired
	 private UserCountrykeysRepository userCountrykeysRepository;
	 
	 @Autowired
	 private TransfastRoutersRepository transfastRoutersRepository;
	 
	 @Autowired
	 private PendingListsRepository pendingListsRepository;
	
	 // @Scheduled(cron = "0 * * * * ?")
	    public void updateSendTransactionStatus() {
		  
		 try {
		 List<SendMoneyTransaction> sendMoneyTransactions =null;
		 sendMoneyTransactions = sendMoneyTransactionRepository.getSendTransactionsbyDate();
		 
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("SEND_MONEY_URL"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		 String basecountrycode ="PA";
		 userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(basecountrycode,"SENDMONEY");
		 
		 TransfastRouter  transfastRouter =null;
	     transfastRouter =transfastRoutersRepository.findBySourceType("GET_TRANSACTION");
	     
	     String url =transfastRouter.getSourceurl();
	      url =baseurl+url;
	      
	      HttpHeaders headers = new HttpHeaders();
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			 headers.set("Authorization", userCountrykeys.getCountrytokenkey());
				
			 restTemplate = new RestTemplate();
			 HttpEntity request = new HttpEntity(headers);
			 ResponseEntity<String> response  =null;
		   
		 for (SendMoneyTransaction stats : sendMoneyTransactions) {
		  String tfpin = stats.getTfpin();
		  String replaceval ="1?";
		  url =url.replace(replaceval, tfpin);
		  ResponseEntity<SendMoneyResponseDto> sendMoneyResponseDto =null;
		  
		  sendMoneyResponseDto = restTemplate.exchange(url, HttpMethod.GET, request, SendMoneyResponseDto.class);
		   
		  sendMoneyTransactionRepository.updatesendmoneytransaction(sendMoneyResponseDto.getBody().getStatusId(),
				  sendMoneyResponseDto.getBody().getStatusName(),sendMoneyResponseDto.getBody().getTfPin());
			 
		 }
		 }catch(Exception e) {
			// e.printStackTrace();
		
		 }
	 
	 }
	  
	  
	  
	  //@Scheduled(cron = "0 * * * * ?")
	    public void updatePendingTransactions() {
		  String tfpin =""; 
		 try {
		 List<PendingLists> pendingLists =null;
		 pendingLists = pendingListsRepository.getPendingLists();
		 
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("CASH_PICKUP"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		 String basecountrycode ="PA";
		 userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(basecountrycode,"SENDMONEY");

          String url ="/api/Invoice/InvoiceStatus/?TfPin=1?";
	      url =baseurl+url;
	      
	      HttpHeaders headers = new HttpHeaders();
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			 headers.set("Authorization", userCountrykeys.getCountrytokenkey());
				
			 restTemplate = new RestTemplate();
			 HttpEntity request = new HttpEntity(headers);
			 ResponseEntity<String> response  =null;
		 
		 for (PendingLists stats : pendingLists) {
		  tfpin = stats.getTfPin();
		  String replaceval ="1?";
		  url =url.replace(replaceval, tfpin);
		  ResponseEntity<SendMoneyResponseDto> sendMoneyResponseDto =null;
		  
		  sendMoneyResponseDto = restTemplate.exchange(url, HttpMethod.GET, request, SendMoneyResponseDto.class);
		   
		 if(sendMoneyResponseDto.getBody().getStatusName().equalsIgnoreCase("Cancelled")) {
			 System.out.println("RECORD cancelled"+tfpin);
			 PendingLists pendingLists1  =null;
			 pendingLists1  =pendingListsRepository.getByTfPin(tfpin);
			 pendingListsRepository.delete(pendingLists1);
				
		
		 }
			 
		 }
		 }catch(Exception e) {
			// e.printStackTrace();
			 System.out.println("RECORD DOES NOT EXITS"+tfpin);
			 PendingLists pendingLists  =null;
			 pendingLists  =pendingListsRepository.getByTfPin(tfpin);
			 pendingListsRepository.delete(pendingLists);
				
		
		 }
	 
	 }

}
