package com.coop.cashsends.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
import com.coop.cashsends.dto.SendMoneyTransactionDto;
import com.coop.cashsends.dto.TellerTransactionsDto;
import com.coop.cashsends.dto.TransactionDto;
import com.coop.cashsends.dto.WalletHistoryDto;
import com.coop.cashsends.exception.TransactionServiceException;
import com.coop.cashsends.model.Banks;
import com.coop.cashsends.model.CancelReason;
import com.coop.cashsends.model.City;
import com.coop.cashsends.model.ComplaintsAndPetitions;
import com.coop.cashsends.model.CoopRecieveMoneyTransInfo;
import com.coop.cashsends.model.CoopRecieverTransaction;
import com.coop.cashsends.model.Country;
import com.coop.cashsends.model.CustomerComments;
import com.coop.cashsends.model.CustomerComplaints;
import com.coop.cashsends.model.FormOfPayments;
import com.coop.cashsends.model.Locations;
import com.coop.cashsends.model.LovType;
import com.coop.cashsends.model.Partner;
import com.coop.cashsends.model.PayerRecieverID;
import com.coop.cashsends.model.PayerRemittance;
import com.coop.cashsends.model.PendingLists;
import com.coop.cashsends.model.RecieveMoneyTransInfo;
import com.coop.cashsends.model.RecieverInfo;
import com.coop.cashsends.model.RecieverTransaction;
import com.coop.cashsends.model.SendMoneyTransaction;
import com.coop.cashsends.model.SenderInfo;
import com.coop.cashsends.model.State;
import com.coop.cashsends.model.Teller;
import com.coop.cashsends.model.TellerTransactions;
import com.coop.cashsends.model.Town;
import com.coop.cashsends.model.TransactionHistory;
import com.coop.cashsends.model.TransactionInfo;
import com.coop.cashsends.model.User;
import com.coop.cashsends.model.UserCountrykeys;
import com.coop.cashsends.model.Wallet;
import com.coop.cashsends.model.WalletHistory;
import com.coop.cashsends.repository.BanksRepository;
import com.coop.cashsends.repository.CancelReasonRepository;
import com.coop.cashsends.repository.CityRepository;
import com.coop.cashsends.repository.ComplaintStatusRepository;
import com.coop.cashsends.repository.ComplaintsAndPetitionsRepository;
import com.coop.cashsends.repository.CoopRecieverTransactionRepository;
import com.coop.cashsends.repository.CountryRepository;
import com.coop.cashsends.repository.CustomerComplaintRepository;
import com.coop.cashsends.repository.FormOfPaymentsRepository;
import com.coop.cashsends.repository.LocationsRepository;
import com.coop.cashsends.repository.LovTypesRepository;
import com.coop.cashsends.repository.PartnerRepository;
import com.coop.cashsends.repository.PayerErrorCodesRepository;
import com.coop.cashsends.repository.PayerRecieverIDRepository;
import com.coop.cashsends.repository.PayerRemittanceRepository;
import com.coop.cashsends.repository.PendingListsRepository;
import com.coop.cashsends.repository.RecieverTransactionRepository;
import com.coop.cashsends.repository.SendMoneyTransactionRepository;
import com.coop.cashsends.repository.StateRepository;
import com.coop.cashsends.repository.TellerRepository;
import com.coop.cashsends.repository.TellerTransactionsRepository;
import com.coop.cashsends.repository.TownRepository;
import com.coop.cashsends.repository.TransactionHistoryRepository;
import com.coop.cashsends.repository.TransfastRoutersRepository;
import com.coop.cashsends.repository.UserCountrykeysRepository;
import com.coop.cashsends.repository.UserRepository;
import com.coop.cashsends.repository.WalletHistoryRepository;
import com.coop.cashsends.repository.WalletRepository;
import com.coop.cashsends.service.AuthenticationFacadeService;
import com.coop.cashsends.service.TransactionService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Transactional
@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private TransfastRoutersRepository transfastRoutersRepository;
	 
	 @Autowired
	 private UserCountrykeysRepository userCountrykeysRepository ;
	 
	 RestTemplate restTemplate;
	 
	 @Autowired
	 private LovTypesRepository lovTypesRepository;
	 
	 @Autowired
	 private SendMoneyTransactionRepository sendMoneyTransactionRepository;
	 
	 @Autowired
	 private TellerTransactionsRepository tellerTransactionsRepository;
	 
	 @Autowired
	 private TellerRepository tellerRepository;
	 
	 @Autowired
	 private WalletHistoryRepository walletHistoryRepository;
	 @Autowired
	 private PartnerRepository partnerRepository;
	 
	 @Autowired
	 private WalletRepository walletRepository;
	 
	 @Autowired
	 private RecieverTransactionRepository recieverTransactionRepository;
	 
	 @Autowired
	 private PendingListsRepository pendingListsRepository;
	 
	 @Autowired
	 private TransactionHistoryRepository transactionHistoryRepository;
	 
	 @Autowired
	 private CustomerComplaintRepository customerComplaintRepository;
	 
	 
	 @Autowired
	 private CountryRepository countryRepository;
	 
	 @Autowired
	 private StateRepository stateRepository;
	 
	 @Autowired
	 private CityRepository cityRepository;
	 
	 @Autowired
	 private LocationsRepository locationsRepository;
	 
	 @Autowired
		private FormOfPaymentsRepository formOfPaymentsRepository;
		
		@Autowired
		private PayerRecieverIDRepository  payerRecieverIDRepository;
		
		@Autowired
		private PayerErrorCodesRepository payerErrorCodesRepository;
		
		@Autowired
		private PayerRemittanceRepository payerRemittanceRepository;
		
		@Autowired
		private ComplaintsAndPetitionsRepository complaintsAndPetitionsRepository;
		
	   @Autowired	
	   private CoopRecieverTransactionRepository coopRecieverTransactionRepository;
	   
	   @Autowired
	   private BanksRepository banksRepository;
	   @Autowired
	   private TownRepository townRepository;
	   
	   @Autowired
	   private CancelReasonRepository cancelReasonRepository;
	   
	   @Autowired
	   private ComplaintStatusRepository complaintStatusRepository;
	   
	   //@Autowired
		//private AuthenticationFacadeService authenticationFacadeService;
	
	@Override
	public String sendMoney(TransactionDto transactionDto, String username) {
		  
	     System.out.println("$$$$$"+transactionDto.getSender().getName());	
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("SEND_MONEY_URL"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		 transactionDto.setCreatedby(username);
		 String basecountrycode ="PA";
				 ///transactionDto.getBasecode(;
			/*if(transtype ==null) {
				transtype ="SENDMONEY";
				basecountrycode ="PA";
			}*/
		 userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(basecountrycode,"SENDMONEY");
		  
		try {
		String tfpin =null;
		String postUrl = "http://localhost:3000/v2/sendMoney";
		restTemplate = new RestTemplate();
		transactionDto.setAuthorizationkey(userCountrykeys.getCountrytokenkey());
		transactionDto.setUrl(baseurl);
		System.out.println(transactionDto.getTransactionInfo().getRemittanceId());
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, transactionDto, String.class);
	     //tfpin =postResponse.getBody().toString();
	    
	     String resstring =postResponse.getBody().toString()+"|";
	     System.out.println("resstring"+resstring);
		
	    if(postResponse.getBody().toString() ==null) {
	    	 return "SAVED|"+"Transaction successfully created but failed to save locally please check send list or contact admin";
	    	
	    }else {
	    	StringTokenizer st = new StringTokenizer(resstring,"|");
	    	String nexttoken ="";
	    	 int counter =0;
	    	 System.out.println(st.countTokens());
	  
	    	while(st.hasMoreTokens()) {
	    		if(counter ==0) {
	    			nexttoken =st.nextToken();
	    		}else {
	    			tfpin =st.nextToken();
	    		    		
	    		}
	    		counter =counter+1;
	        }
	    	
			System.out.println("nexttoken"+nexttoken);
			System.out.println("tfpin"+tfpin);
			  
	    	
	    	if(nexttoken.equalsIgnoreCase("ERROR")) {
   			 return "ERROR|"+tfpin;
   			
   		}else {
   			TellerTransactions tellerTransactions =null;
  	    	 User user =null;
  	    	 user = userRepository.findByUsername(username);
  	    	 Teller teller = null;
  	    	 teller = tellerRepository.tellerByUserID(user.getId());
  	    	 String completename =user.getFirstname()+" "+user.getLastname();
  	    	 tellerTransactions = new TellerTransactions();
  	    	 tellerTransactions.setDescription("Transaction generated successfully,Please find the Tfpin :"+tfpin+"");
  	    	 tellerTransactions.setUsername(completename);
  	    	 tellerTransactions.setIpaddress(transactionDto.getIpaddress()); 
  	    	 tellerTransactions.setTellerid(teller.getId());
  	    	 LocalDateTime ldate = LocalDateTime.now();
  	    	 tellerTransactions.setActivitydate(ldate);
  	    	 tellerTransactions.setActivitystatus("SEND MONEY");
  	    	 tellerTransactionsRepository.save(tellerTransactions);
  	    	 
  	    	Teller teller1 = null;
  			teller1 = tellerRepository.tellerByUserID(user.getId());
  			 user =null;
  			user = userRepository.findByUsername(teller1.getCreated_by());
  			Partner partner =null;
  			partner = partnerRepository.partnerDetailsByUserId(user.getId());
  			Wallet wallet =null;
  			wallet = walletRepository.findwalletbyUserAndCode(partner.getId(),"TST");
  			float transactionamount =Float.parseFloat(transactionDto.TransactionInfo.getSentAmount())+ transactionDto.getServicefees()+transactionDto.getTaxamount();
  			float newbalance = wallet.getWalletamount()+transactionamount;
  			wallet.setWalletamount(newbalance);
  			walletRepository.save(wallet);
  			
  			float newcreditlimit = partner.getCreditamount()-transactionamount;
  			partner.setCreditamount(newcreditlimit);
  			partnerRepository.save(partner);
  		
  			
  			SendMoneyTransaction sendMoneyTransaction = null;
  			sendMoneyTransaction =sendMoneyTransactionRepository.findbyTfPin(tfpin);
  			sendMoneyTransaction.setPayerid(String.valueOf(user.getId()));
  			sendMoneyTransactionRepository.save(sendMoneyTransaction);
  			
  			WalletHistory walletHistory =null;
  			walletHistory = new WalletHistory();
  			walletHistory.setAccountnumber(wallet.getAccountnumber());
  			walletHistory.setCurrentbalance(newbalance);
  			walletHistory.setTransactionamount(transactionamount);
  			walletHistory.setTransactionstatus("DEBIT");
  			walletHistory.setWalletid(wallet.getId());
  			walletHistory.setTransactiondescription("An amount of ("+transactionamount+") has been used during send money transaction reference tfpin :"+tfpin+" ");
  			walletHistory.setTransactiondate(LocalDateTime.now());
  			walletHistory.setAccountcode("TST");
  			walletHistory.setPartnerid(partner.getId());
  			walletHistoryRepository.save(walletHistory);
  	    	
  	    	 user =null;
  	    	 teller =null;
  	    	 tellerTransactions =null;
  	    	// walletHistory =null;
  	    	 //wallet =null;
  	    	 return "SUCCESS|"+tfpin;	
   			
   		}
	    	
	    	 
	    
	    	
	    }
	    
	   
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR|"+null;
		}
		
		
	 	
		
	}

	@Override
	public String SendMoneylocal(TransactionDto transactionDto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String cancelTransaction(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException {
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("SEND_MONEY_URL"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(cancelorComplaintDto.getBasecode(),"SENDMONEY");
		cancelorComplaintDto.setAuthorizationkey(userCountrykeys.getCountrytokenkey());
		cancelorComplaintDto.setUrl(baseurl);
		
		String postUrl = "http://localhost:3000/v2/canceltransaction";
		restTemplate = new RestTemplate();
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, cancelorComplaintDto, String.class);
	    System.out.println("Response for Post Request: " + postResponse.getBody().toString());
		 return postResponse.getBody().toString();
	}

	@Override
	public String raiseComplaint(CancelorComplaintDto cancelorComplaintDto)throws TransactionServiceException {
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("SEND_MONEY_URL"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(cancelorComplaintDto.getBasecode(),"SENDMONEY");
		cancelorComplaintDto.setAuthorizationkey(userCountrykeys.getCountrytokenkey());
		cancelorComplaintDto.setUrl(baseurl);
		String postUrl = "http://localhost:3000/v2/createcomplaint";
		restTemplate = new RestTemplate();
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, cancelorComplaintDto, String.class);
		 if(postResponse.getBody().toString().equalsIgnoreCase("SUCCESS")) {
		 try {
			 Twilio.init("AC58bc3668ea1544a8bb69f745f642a933", "9185158d2ea6518e1178805630b68f0b");
			 
				SendMoneyTransaction sendMoneyTransaction =null;
				sendMoneyTransaction = sendMoneyTransactionRepository.findbyTfPin(cancelorComplaintDto.getTfPin());
				if(sendMoneyTransaction != null) {
				sendMoneyTransaction.setStatusname("CANCEL");
				sendMoneyTransactionRepository.save(sendMoneyTransaction);
				}

				String phoneno ="+50763516303";
				String message1 ="A complaint has been raised for send money transaction for tfpin :"+cancelorComplaintDto.getTfPin()+" / Description :"+cancelorComplaintDto.getDescription()+" ";
				Message message = Message.creator(new PhoneNumber(phoneno), new PhoneNumber("+17027896606"),
						message1).create();
				System.out.println(message);
		        }catch(Exception e) {
		        	//e.printStackTrace();
		        }
		 }
	    System.out.println("Response for Post Request: " + postResponse.getBody().toString());
	    
		 return postResponse.getBody().toString();
	}

	@Override
	public List<TellerTransactionsDto> telleractivity() {
		List<TellerTransactionsDto> tellerTransactionsDtos = new ArrayList<>();
		tellerTransactionsRepository.findByCreatedDate().iterator().forEachRemaining(tellertransactions -> tellerTransactionsDtos.add(tellertransactions.toTellerTransactionsDto()));
		return tellerTransactionsDtos;
	}

	@Override
	public List<TellerTransactionsDto> tellerActivityagent(String username) {
		List<TellerTransactionsDto> tellerTransactionsDtos = new ArrayList<>();
		tellerTransactionsRepository.findBytransactionsbyAgent(username).iterator().forEachRemaining(tellertransactions -> tellerTransactionsDtos.add(tellertransactions.toTellerTransactionsDto()));
		return tellerTransactionsDtos;
	
	}

	@Override
	public List<TellerTransactionsDto> tellerActivitymanager(String username) {
		List<TellerTransactionsDto> tellerTransactionsDtos = new ArrayList<>();
		tellerTransactionsRepository.findBytransactionsbyManager(username).iterator().forEachRemaining(tellertransactions -> tellerTransactionsDtos.add(tellertransactions.toTellerTransactionsDto()));
		return tellerTransactionsDtos;
	
	}

	@Override
	public List<WalletHistoryDto> walletHistory(Integer walletid) throws TransactionServiceException {
		List<WalletHistoryDto> walletHistoryDtos = new ArrayList<>();
		walletHistoryRepository.walletHistoryById(walletid).iterator().forEachRemaining(wallethistory -> walletHistoryDtos.add(wallethistory.toWalletHistoryDto()));
		return walletHistoryDtos;
	}

	@Override
	public int creditLimit(CreditLimitDto creditLimitDto) throws TransactionServiceException {
		int status =0;
		Partner partner =null;
		
		Optional<Partner> partners =partnerRepository.findById(creditLimitDto.getWalletid());
		if(partners.isPresent()) {
			partner = partners.get();
		float newbalance =0;
		if(creditLimitDto.getTransactiontype().equalsIgnoreCase("CREDIT")) {
		 newbalance =partner.getCreditamount()+creditLimitDto.getWalletamount();
		}else {
			newbalance =partner.getCreditamount()-creditLimitDto.getWalletamount();	
		}
        partner.setCreditamount(newbalance);
		
		   WalletHistory walletHistory =null;
			walletHistory = new WalletHistory();
			walletHistory.setAccountnumber("");
			walletHistory.setCurrentbalance(newbalance);
			walletHistory.setTransactionamount(creditLimitDto.getWalletamount());
			walletHistory.setTransactionstatus(creditLimitDto.getTransactiontype());
			walletHistory.setTransactiondescription(creditLimitDto.getDescription());
			walletHistory.setTransactiondate(LocalDateTime.now());
			walletHistory.setPartnerid(partner.getId());
			status =walletHistoryRepository.save(walletHistory).getId();
		
        return partnerRepository.save(partner).getId();
		}else {
			return status;	
		}
		   
		
		
	}

	@Override
	public List<SendMoneyTransactionDto> allTransactions(Integer userid) throws TransactionServiceException {
		List<SendMoneyTransactionDto> sendMoneyTransactionDtos = new ArrayList<>();
		if(userid ==0) {
		sendMoneyTransactionRepository.findbyOrder().iterator().forEachRemaining(Sendmoneytransaction -> sendMoneyTransactionDtos.add(Sendmoneytransaction.toSendMoneyTransactionDto()));
		}else {
		 
		User user = null;
		user =userRepository.findById(userid).get();
		String username = user.getUsername();
		
		user =null;
		String tellers = userRepository.findByPartners(username);
		
		sendMoneyTransactionRepository.findbyOrderByTellers(tellers).iterator().forEachRemaining(Sendmoneytransaction -> sendMoneyTransactionDtos.add(Sendmoneytransaction.toSendMoneyTransactionDto()));
			
		}
		return sendMoneyTransactionDtos;
	}

	@Override
	public List<RecieverTransactionDto> recievertransactions(String startdate, String enddate, String role,
			String username) throws TransactionServiceException {
		List<RecieverTransactionDto> recieverTransactionDtos = new ArrayList<>();
		if(role.equalsIgnoreCase("ADMIN")) {
		recieverTransactionRepository.getallPaidTransactions(startdate,enddate).iterator().forEachRemaining(recievertransaction -> recieverTransactionDtos.add(recievertransaction.toRecieverTransactionDto()));
		}else {
			recieverTransactionRepository.getallPaidTransactionsPartner(startdate,enddate,username,username).iterator().forEachRemaining(recievertransaction -> recieverTransactionDtos.add(recievertransaction.toRecieverTransactionDto()));
				
		}
		return recieverTransactionDtos;
	}

	@Override
	public String recieveMoney(PaidDto paidDto, String username) throws TransactionServiceException {
		 // System.out.println("$$$$$"+transactionDto.getSender().getName());	
			 LovType lovType =null;
			 lovType = lovTypesRepository.getLovType("CASH_PICKUP"); 
			 String baseurl =lovType.getLovValues().get(0).getValue();
			 UserCountrykeys userCountrykeys =null;
			 paidDto.setCreatedby(username);
			userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(paidDto.getBasecode(),paidDto.getTransactiontype());
			try {
			String tfpin =null;
			/*try {
			RecieverTransaction recieverTransaction =null;
   			recieverTransaction = new RecieverTransaction();
   			recieverTransaction.setTfpin(paidDto.getTfPin());
   			recieverTransaction.setSendercountry(paidDto.getSendercountry());
   			recieverTransaction.setSendercity(paidDto.getSendercity());
   			recieverTransaction.setSenderstate(paidDto.getSenderstate());
   			recieverTransaction.setSendername(paidDto.getSendername());
   			recieverTransaction.setRecievercountry(paidDto.getRecievercountry());
   			recieverTransaction.setRecievername(paidDto.getRecieverfullname());
   			recieverTransaction.setRecieverstate(paidDto.getRecieverstate());
   			recieverTransaction.setRecievercurrency(paidDto.getRecievercurrency());
   			recieverTransaction.setRecievercity(paidDto.getRecievercity());
   			recieverTransaction.setTransactiondate(LocalDateTime.now());
   			recieverTransaction.setAmount(paidDto.getRecieveramount());
   			recieverTransaction.setTransactiontype(paidDto.getTransactiontype());
   			RecieveMoneyTransInfo recieveMoneyTransInfo =null;
   			recieveMoneyTransInfo  = new RecieveMoneyTransInfo();
   			recieveMoneyTransInfo.setServicefees(paidDto.getServicefees());
   			recieveMoneyTransInfo.setTax(paidDto.getTaxes());
   			recieveMoneyTransInfo.setRecievertransaction(recieverTransaction);
   			
   			recieverTransaction.setRecieveMoneytransInfo(recieveMoneyTransInfo);
   			
   			recieverTransactionRepository.save(recieverTransaction);
   			
   			User user =null;
  	    	user = userRepository.findByUsername(username);	
  	    	Teller teller1 = null;
  	    	Partner partner =null;
   		if(paidDto.getRole().equalsIgnoreCase("TELLER")) {
   			
   			teller1 = tellerRepository.tellerByUserID(user.getId());
  			 user =null;
  			user = userRepository.findByUsername(teller1.getCreated_by());
  			partner = partnerRepository.partnerDetailsByUserId(user.getId());	
   			
   		}else {
   		partner = partnerRepository.partnerDetailsByUserId(user.getId());
   		}
			Wallet wallet =null;
			wallet = walletRepository.findwalletbyUser(partner.getId());
			float transactionamount =paidDto.getRecieveramount() + paidDto.getServicefees()+paidDto.getTaxes();
			float newbalance = wallet.getWalletamount() + paidDto.getRecieveramount(); 
			wallet.setWalletamount(newbalance);
			walletRepository.save(wallet);
			
			WalletHistory walletHistory =null;
			walletHistory = new WalletHistory();
			walletHistory.setAccountnumber(wallet.getAccountnumber());
			walletHistory.setCurrentbalance(newbalance);
			walletHistory.setTransactionamount(transactionamount);
			walletHistory.setTransactionstatus("CREDIT");
			walletHistory.setWalletid(wallet.getId());
			walletHistory.setTransactiondescription("Amount has been credited during reciever transfer transaction reference tfpin :"+tfpin+" ");
			walletHistory.setTransactiondate(LocalDateTime.now());
			walletHistoryRepository.save(walletHistory);
	    	
	    	 user =null;
	    	 walletHistory =null;
	    	 wallet =null;
   			
  	      
  	     
			}catch(Exception e) {
				e.printStackTrace();
			}*/
			
			
			
			String postUrl = "http://localhost:3000/v2/recieveMoney";
			restTemplate = new RestTemplate();
			paidDto.setAuthorizationkey(userCountrykeys.getCountrytokenkey());
			paidDto.setBaseurl(baseurl);
			 ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, paidDto, String.class);
		     //tfpin =postResponse.getBody().toString();
		    
		     String resstring =postResponse.getBody().toString()+"|";
		    // System.out.println("resstring"+resstring);
			
		    if(postResponse.getBody().toString() ==null) {
		    	 return "SAVED|"+"Transaction successfully created but failed to save locally please check send list or contact admin";
		    	
		    }else {
		    	StringTokenizer st = new StringTokenizer(resstring,"|");
		    	String nexttoken ="";
		    	 int counter =0;
		    	 System.out.println(st.countTokens());
		  
		    	while(st.hasMoreTokens()) {
		    		if(counter ==0) {
		    			nexttoken =st.nextToken();
		    		}else {
		    			tfpin =st.nextToken();
		    		    		
		    		}
		    		counter =counter+1;
		        }
		    	
				//System.out.println("nexttoken"+nexttoken);
				//System.out.println("tfpin"+tfpin);
				  
		    	
		    	if(nexttoken.equalsIgnoreCase("ERROR")) {
	   			 return "ERROR|"+tfpin;
	   			
	   		}else {
	   			RecieverTransaction recieverTransaction =null;
	   			recieverTransaction = new RecieverTransaction();
	   			recieverTransaction.setTfpin(paidDto.getTfPin());
	   			recieverTransaction.setSendercountry(paidDto.getSendercountry());
	   			recieverTransaction.setSendercity(paidDto.getSendercity());
	   			recieverTransaction.setSenderstate(paidDto.getSenderstate());
	   			recieverTransaction.setSendername(paidDto.getSendername());
	   			recieverTransaction.setRecievercountry(paidDto.getRecievercountry());
	   			recieverTransaction.setRecievername(paidDto.getRecieverfullname());
	   			recieverTransaction.setRecieverstate(paidDto.getRecieverstate());
	   			recieverTransaction.setRecievercurrency(paidDto.getRecievercurrency());
	   			recieverTransaction.setRecievercity(paidDto.getRecievercity());
	   			recieverTransaction.setTransactiondate(LocalDateTime.now());
	   			recieverTransaction.setAmount(paidDto.getRecieveramount());
	   			recieverTransaction.setTransactiontype(paidDto.getTransactiontype());
	   			recieverTransaction.setStatus("PAID");
	   			RecieveMoneyTransInfo recieveMoneyTransInfo =null;
	   			recieveMoneyTransInfo  = new RecieveMoneyTransInfo();
	   			recieveMoneyTransInfo.setServicefees(paidDto.getServicefees());
	   			recieveMoneyTransInfo.setTax(paidDto.getTaxes());
	   			recieveMoneyTransInfo.setRecievertransaction(recieverTransaction);
	   			recieveMoneyTransInfo.setBankname(paidDto.getBankname());
	   			recieveMoneyTransInfo.setAccountnumber(paidDto.getAccountnumber());
	   			recieveMoneyTransInfo.setAccounttype(paidDto.getRecieveraccounttype());
	   			recieveMoneyTransInfo.setCommamountforeign(paidDto.getCommamountforeign());
	   			recieveMoneyTransInfo.setCommamountlocal(paidDto.getCommamountlocal());
	   			recieveMoneyTransInfo.setPurposeofremittanceid(paidDto.getPurposeofremittanceid());
	   			//recieveMoneyTransInfo.setba
	   			recieverTransaction.setRecieveMoneytransInfo(recieveMoneyTransInfo);
	   			
	   				
	   			User user =null;
	  	    	user = userRepository.findByUsername(username);
	  	    	Teller teller1 = null;
	  	    	Partner partner =null;
	   		if(paidDto.getRole().equalsIgnoreCase("TELLER")) {
	   			
	   			teller1 = tellerRepository.tellerByUserID(user.getId());
	  			 user =null;
	  			user = userRepository.findByUsername(teller1.getCreated_by());
	  			partner = partnerRepository.partnerDetailsByUserId(user.getId());	
	   			
	   		}else {
	   		partner = partnerRepository.partnerDetailsByUserId(user.getId());
	   		}
	   		recieverTransaction.setPayerid(String.valueOf(partner.getUserid()));
	   		recieverTransactionRepository.save(recieverTransaction);
	   		
   			Wallet wallet =null;
   			String accounttype =null;
   			if(paidDto.getPaymentModeId().equalsIgnoreCase("C")) {
   				accounttype ="TCP";
   			}else {
   				accounttype ="TBD";
   			}
   			wallet = walletRepository.findwalletbyUserAndCode(partner.getId(),accounttype);
   			float transactionamount =paidDto.getRecieveramount() + paidDto.getServicefees()+paidDto.getTaxes();
   			float newbalance = wallet.getWalletamount() + paidDto.getRecieveramount(); 
   			wallet.setWalletamount(newbalance);
   			walletRepository.save(wallet);
   			
   			float newcreditlimit = partner.getCreditamount()+transactionamount;
  			partner.setCreditamount(newcreditlimit);
  			partnerRepository.save(partner);
   			
   			WalletHistory walletHistory =null;
   			walletHistory = new WalletHistory();
   			walletHistory.setAccountnumber(wallet.getAccountnumber());
   			walletHistory.setCurrentbalance(newbalance);
   			walletHistory.setTransactionamount(transactionamount);
   			walletHistory.setTransactionstatus("CREDIT");
   			walletHistory.setWalletid(wallet.getId());
   			walletHistory.setTransactiondescription("An amount of "+transactionamount+" "+paidDto.getReceiverCountryIsoCode()+" has been recieved , transaction reference tfpin :"+tfpin+" ");
   			walletHistory.setTransactiondate(LocalDateTime.now());
   			walletHistory.setAccountcode(accounttype);
   			walletHistory.setPartnerid(partner.getId());
   			walletHistoryRepository.save(walletHistory);
   	    	
   	    	 user =null;
   	    	 //walletHistory =null;
   	    	 //wallet =null;
	   			
	  	     return "SUCCESS|"+tfpin;	
	   			
	   		}
		   	
		    }
		    
		   
			}catch(Exception e) {
				e.printStackTrace();
				return "ERROR|"+null;
			}
			
			
	}

	@Override
	public RecieverTransactionDto paidtransction(String tfpin) throws TransactionServiceException {
		RecieverTransactionDto recieverTransactionDto =null;
		recieverTransactionDto = recieverTransactionRepository.getPaidTransactionbyTfPin(tfpin).toRecieverTransactionDto();
		return recieverTransactionDto;
	}

	@Override
	public SendMoneyTransactionDto sendmoneytractions(String tfpin) throws TransactionServiceException {
		SendMoneyTransactionDto sendMoneyTransactionDto =null;
		sendMoneyTransactionDto = sendMoneyTransactionRepository.findbyTfPin(tfpin).toSendMoneyTransactionDto();
		return sendMoneyTransactionDto;
	}

	@Override
	public List<RecieverTransactionDto> recievertransactions(Integer partnerid) {
		List<RecieverTransactionDto> recieverTransactionDtos = new ArrayList<>();
		if(partnerid ==0) {
			recieverTransactionRepository.findbyOrder().iterator().forEachRemaining(recievertransaction -> recieverTransactionDtos.add(recievertransaction.toRecieverTransactionDto()));
		}else {
		 
		User user = null;
		user =userRepository.findById(partnerid).get();
		String username = user.getUsername();
		
		user =null;
		//String tellers = userRepository.findByPartners(username);
		
		recieverTransactionRepository.findbyPartnerName(username).iterator().forEachRemaining(recievertransaction -> recieverTransactionDtos.add(recievertransaction.toRecieverTransactionDto()));
			
		}
		return recieverTransactionDtos;
	}

	@Override
	public List<PendingListsDto> pendingLists(String countrycode) throws TransactionServiceException {
		List<PendingListsDto >pendingListsDtos = new  ArrayList<>();
		
		pendingListsRepository.allPendingList(countrycode).iterator().forEachRemaining(pendinglists -> pendingListsDtos.add(pendinglists.toPendingListsDto()));
		
		return pendingListsDtos;
	}

	@Override
	public int savePendingList(RecieverPendingDto recieverPendingDto)throws TransactionServiceException {
		int status =0;
		
		List<PendingListsDto> recieverPendingDtos =recieverPendingDto.getPendinglists();
		for (PendingListsDto stats : recieverPendingDtos) {
			PendingLists pendingLists  =null;
			pendingLists = new PendingLists();
			pendingLists.setReceiveAmount(stats.getReceiveAmount());
			pendingLists.setReceiveCurrencyIsoCode(stats.getReceiveCurrencyIsoCode());
			pendingLists.setReceiverCountryName(stats.getReceiverCountryName());
			pendingLists.setReceiverFullName(stats.getReceiverFullName());
			pendingLists.setSenderCountryName(stats.getSenderCountryName());
			pendingLists.setReceiverCountryIsoCode(stats.getReceiverCountryIsoCode());
			pendingLists.setSenderFullName(stats.getSenderFullName());
			pendingLists.setStatusName(stats.getStatusName());
			pendingLists.setTfPin(stats.getTfPin());
			pendingLists.setTransactionDate(stats.getTransactionDate());
			pendingLists.setPaymentModeName(stats.getPaymentModeName());
		    status =	pendingListsRepository.save(pendingLists).getId();
			
			
		}
		return status;
	}

	@Override
	public int deletePendinglists(String tfpin) throws TransactionServiceException {
		int status =0;
		PendingLists pendingLists  =null;
		pendingLists  =pendingListsRepository.getByTfPin(tfpin);
		pendingListsRepository.delete(pendingLists);
		
		return status;
	}

	@Override
	public String reciverComplaint(CancelorComplaintDto cancelorComplaintDto) throws TransactionServiceException {
		 LovType lovType =null;
		 lovType = lovTypesRepository.getLovType("CASH_PICKUP"); 
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 UserCountrykeys userCountrykeys =null;
		userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(cancelorComplaintDto.getBasecode(),cancelorComplaintDto.getTransactionType());
		cancelorComplaintDto.setAuthorizationkey(userCountrykeys.getCountrytokenkey());
		cancelorComplaintDto.setUrl(baseurl);
		String postUrl = "http://localhost:3000/v2/recievercomplaint";
		restTemplate = new RestTemplate();
		 ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, cancelorComplaintDto, String.class);
	    System.out.println("Response for Post Request: " + postResponse.getBody().toString());
	    PendingLists pendinglists =null;
	    pendinglists  =pendingListsRepository.getByTfPin(cancelorComplaintDto.getTfPin());
	    if(pendinglists !=null) {
	    pendinglists.setStatusName("CANCEL");
	    pendingListsRepository.save(pendinglists);
	    }
	    if(postResponse.getBody().toString().equalsIgnoreCase("SUCCESS")) {
	    	
	    	RecieverTransaction recieverTransaction =null;
   			recieverTransaction = recieverTransactionRepository.getPaidTransactionbyTfPin(cancelorComplaintDto.getTfPin());
   			recieverTransaction.setStatus("CANCEL");
   			recieverTransactionRepository.save(recieverTransaction);
	    
	    try {
	    	Twilio.init("AC58bc3668ea1544a8bb69f745f642a933", "9185158d2ea6518e1178805630b68f0b");

			String phoneno ="+50763516303";
			String message1 ="A complaint has been raised for reciever money transaction for tfpin :"+cancelorComplaintDto.getTfPin()+" / Description :"+cancelorComplaintDto.getDescription()+" ";
			Message message = Message.creator(new PhoneNumber(phoneno), new PhoneNumber("+17027896606"),
					message1).create();
	        }catch(Exception e) {
	        	
	        }
	    }
	    
		 return postResponse.getBody().toString();
	}

	@Override
	public List<SendMoneyTransactionDto> retrivesendmoneytractions(Integer userid, String rolename,String transactiontype,
			String startdate, String enddate )throws TransactionServiceException {
		List<SendMoneyTransactionDto> sendMoneyTransactionDtos = new ArrayList<>();
		User user = null;
		user =userRepository.findById(userid).get();
		String username = user.getUsername();
		if(rolename.equalsIgnoreCase("TELLER")) {
		if(startdate != null && enddate !=null) {
		sendMoneyTransactionRepository.getTransactionsbyTellerdates(username,transactiontype,startdate,enddate).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
		}else {
		sendMoneyTransactionRepository.getTransactionsbyTeller(username,transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
		}
		}else {
	    user =null;
		//String tellers = userRepository.findByPartners(username);
	    if(startdate != null && enddate !=null) {
	    	   sendMoneyTransactionRepository.getTransactionsbyPartnerdates(username,transactiontype,startdate,enddate).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
	    		  	
	    }else {
	    sendMoneyTransactionRepository.getTransactionsbyPartner(username,transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
	    }	
		}
		return sendMoneyTransactionDtos;
	}

	@Override
	public String coopSendMoney(TransactionDto transactionDto, String username) throws TransactionServiceException {
		User user = null;
		user  = userRepository.findByUsername(username);
		Teller teller = null;
		teller = tellerRepository.tellerByUserID(user.getId());
		Locations locations = null;
		locations  = locationsRepository.getLocationsbyBranchId(transactionDto.getTransactionInfo().getPayingBranchId());
	    if(teller.getLocationid() ==locations.getId()) {
	    	
	    return "SAME_BRANCH";	
	    }else {
		
		String tfpin =null;
		Random random = new Random();
		int r = 100000 + random.nextInt(900000);
		tfpin =userRepository.uniqueTransactionNumber()+String.valueOf(r);
		SendMoneyTransaction sendMoneyTransaction = null;
		sendMoneyTransaction = new SendMoneyTransaction();
		sendMoneyTransaction.setCanbecancelled(true);
		
		sendMoneyTransaction.setStatusid("R");
		sendMoneyTransaction.setStatusname("Pending Release");
		sendMoneyTransaction.setTfpin(tfpin);
		sendMoneyTransaction.setTransactiondate(LocalDateTime.now());
		sendMoneyTransaction.setTransactiontype("COOPTRANSFER");
		sendMoneyTransaction.setTellername(username);
		sendMoneyTransaction.setPayerid(transactionDto.getTransactionInfo().getPayerId());
		sendMoneyTransaction.setPayingbranchid(transactionDto.getTransactionInfo().getPayingBranchId());
		
		SenderInfo senderInfo = null;
		senderInfo = new SenderInfo();
		senderInfo.setAddress(transactionDto.getSender().getAddress());
		senderInfo.setSenderid(String.valueOf(user.getId()));
		senderInfo.setName(transactionDto.getSender().getName());
		senderInfo.setZipcode(transactionDto.getSender().getZipCode());
		senderInfo.setPhonehome(transactionDto.getSender().getPhoneHome());
		senderInfo.setPhonemobile(transactionDto.getSender().getPhoneMobile());
		senderInfo.setPhonework(transactionDto.getSender().getPhoneWork());
		senderInfo.setIssindividual(true);
		senderInfo.setCityid(transactionDto.getSender().getCityId());
		senderInfo.setStateid(transactionDto.getSender().getStateId());
		senderInfo.setCountrycode(transactionDto.getSender().getCountryIsoCode());
		senderInfo.setEmail(transactionDto.getSender().getEmail());
		senderInfo.setTypeofid(transactionDto.getSender().getTypeOfId());
		senderInfo.setIdnumber(transactionDto.getSender().getIdNumber());
		senderInfo.setIdexpirydate(transactionDto.getSender().getIdExpiryDate());
		senderInfo.setDateofbirth(transactionDto.getSender().getSenderDateOfBirth());
		senderInfo.setNationalityIsoCode(transactionDto.getSender().getNationalityIsoCode());
		Country country = null;
		country = countryRepository.findbyCountryCode(transactionDto.getSender().getCountryIsoCode());
		senderInfo.setCountryname(country.getName());
		State state = null;
		Optional<State> states = stateRepository.findById(Integer.parseInt(transactionDto.getSender().getStateId()));
		if(states.isPresent()) {
			state = states.get();
			senderInfo.setStatename(state.getStateName());
		}
		
		City city = null;
		Optional<City> cities = cityRepository.findById(Integer.parseInt(transactionDto.getSender().getCityId()));
		if(cities.isPresent()) {
			city = cities.get();
			senderInfo.setCityname(city.getCityName());
		}
		senderInfo.setSendmoneytransaction(sendMoneyTransaction);
		
		RecieverInfo recieverInfo = null;
		recieverInfo  = new RecieverInfo();
		recieverInfo.setFullname(transactionDto.getReceiver().getFirstName()+ " "+transactionDto.getReceiver().getLastName());
		recieverInfo.setFirstname(transactionDto.getReceiver().getFirstName());
		recieverInfo.setLastname(transactionDto.getReceiver().getLastName());
		recieverInfo.setSecondname(transactionDto.getReceiver().getSecondLastName());
		recieverInfo.setCompleteaddress(transactionDto.getReceiver().getCompleteAddress());
		recieverInfo.setStateid(transactionDto.getReceiver().getStateId());
		recieverInfo.setCityid(transactionDto.getReceiver().getCityId());
		recieverInfo.setCountrycode(transactionDto.getReceiver().getCountryIsoCode());
		recieverInfo.setMobilephone(transactionDto.getReceiver().getMobilePhone());
		recieverInfo.setHomephone(transactionDto.getReceiver().getHomePhone());
		recieverInfo.setWorkphone(transactionDto.getReceiver().getWorkPhone());
		recieverInfo.setZipcode(transactionDto.getReceiver().getZipCode());
		recieverInfo.setNationalityisocode(transactionDto.getReceiver().getNationalityIsoCode());
		recieverInfo.setTownid(transactionDto.getReceiver().getTownId());
		
		country = null;
		country = countryRepository.findbyCountryCode(transactionDto.getReceiver().getCountryIsoCode());
		recieverInfo.setCountryname(country.getName());
		state = null;
		states = null;
		states = stateRepository.findById(Integer.parseInt(transactionDto.getReceiver().getStateId()));
		if(states.isPresent()) {
			state = states.get();
			recieverInfo.setStatename(state.getStateName());
		}
		
		city = null;
		cities = null;
		cities = cityRepository.findById(Integer.parseInt(transactionDto.getReceiver().getCityId()));
		if(cities.isPresent()) {
			city = cities.get();
			recieverInfo.setCityname(city.getCityName());
		}
		
		Town town = null;
		if(transactionDto.getReceiver().getTownId() !=null  && !transactionDto.getReceiver().getTownId().equalsIgnoreCase("SELECT")) {
		Optional<Town> towns =townRepository.findById(Integer.parseInt(transactionDto.getReceiver().getTownId()));
		if(towns.isPresent()) {
			town = towns.get();
			recieverInfo.setTownname(town.getTownName());
			recieverInfo.setTownid(transactionDto.getReceiver().getTownId());
		
		}
		}
		
		
		
		recieverInfo.setSendmoneytransaction(sendMoneyTransaction);
		
		TransactionInfo transactionInfo = null;
		transactionInfo = new TransactionInfo();
		transactionInfo.setPaymentmodeid(transactionDto.getTransactionInfo().getPaymentModeId());
		transactionInfo.setRecievercurrencycode(transactionDto.getTransactionInfo().getReceiveCurrencyIsoCode());
		transactionInfo.setBankbranchid(transactionDto.getTransactionInfo().getBankBranchId());
		transactionInfo.setAccounttypeid(transactionDto.getTransactionInfo().getAccountTypeId());
		transactionInfo.setAccounttypename(transactionDto.getTransactionInfo().getAccount());
		transactionInfo.setBankid(transactionDto.getTransactionInfo().getBankId());
        if(transactionDto.getTransactionInfo().getBankId() !=null && !transactionDto.getTransactionInfo().getBankId().equalsIgnoreCase("SELECT")) {
		Banks bank = null;
		Optional<Banks> banks = banksRepository.findById(Integer.parseInt(transactionDto.getTransactionInfo().getBankId()));
		if(banks.isPresent()) {
			bank =banks.get();
			transactionInfo.setBankname(bank.getBankName());
		}
        }
		transactionInfo.setPayingbranchid(transactionDto.getTransactionInfo().getPayingBranchId());
		transactionInfo.setPayerid(transactionDto.getTransactionInfo().getPayerId());
		Partner partner =null;
		partner = partnerRepository.partnerDetailsByUserId(Integer.parseInt(transactionDto.getTransactionInfo().getPayerId()));
		transactionInfo.setPayername(partner.getBusinessname());
	    transactionInfo.setPayerbranchaddress(locations.getAddress());
		transactionInfo.setPayingbranchname(locations.getLocationame());
		transactionInfo.setPayerbranchphone1(locations.getPayerbranchphone1());
		transactionInfo.setPayerbranchphone2(locations.getPayerbranchphone2());
		transactionInfo.setPurposeofremittance(transactionDto.getTransactionInfo().getPurposeOfRemittanceId());
		transactionInfo.setRecieveamount(Float.parseFloat(transactionDto.getTransactionInfo().getReceiveAmount()));
		transactionInfo.setSourcecurrencycode(transactionDto.getTransactionInfo().getSourceCurrencyIsoCode());
		transactionInfo.setServicefees(Float.parseFloat(transactionDto.getTransactionInfo().getServiceFee()));
		transactionInfo.setTax(transactionDto.getTransactionInfo().getTax());
		transactionInfo.setSendmoneytransaction(sendMoneyTransaction);
		transactionInfo.setTotalsentamount(Float.parseFloat(transactionDto.getTransactionInfo().getTotalSentAmount()));
		transactionInfo.setSentamount(Float.parseFloat(transactionDto.getTransactionInfo().getSentAmount()));
		transactionInfo.setRate(Float.parseFloat(transactionDto.getTransactionInfo().getRate()));
		sendMoneyTransaction.setSenderinfo(senderInfo);
		sendMoneyTransaction.setRecieverinfo(recieverInfo);
		sendMoneyTransaction.setTransactioninfo(transactionInfo);
		
		int result =sendMoneyTransactionRepository.save(sendMoneyTransaction).getId();
		
		TransactionHistory transactionHistory = null;
		transactionHistory = new TransactionHistory();
		transactionHistory.setStatusid("R");
		transactionHistory.setStatusname("Pending Release");
		transactionHistory.setTfpin(tfpin);
		transactionHistoryRepository.save(transactionHistory);
		
		
		    Teller teller1 = null;
			teller1 = tellerRepository.tellerByUserID(user.getId());
			 user =null;
			user = userRepository.findByUsername(teller1.getCreated_by());
			partner =null;
			partner = partnerRepository.partnerDetailsByUserId(user.getId());
			Wallet wallet =null;
			wallet = walletRepository.findwalletbyUserAndCode(partner.getId(),"CST");
			float transactionamount =Float.parseFloat(transactionDto.TransactionInfo.getSentAmount())+ transactionDto.getServicefees()+transactionDto.getTaxamount();
			float newbalance = wallet.getWalletamount() +transactionamount; 
			wallet.setWalletamount(newbalance);
			walletRepository.save(wallet);
			float newcreditlimit = partner.getCreditamount()-transactionamount;
  			partner.setCreditamount(newcreditlimit);
  			partnerRepository.save(partner);
			
			WalletHistory walletHistory =null;
			walletHistory = new WalletHistory();
			walletHistory.setAccountnumber(wallet.getAccountnumber());
			walletHistory.setCurrentbalance(newbalance);
			walletHistory.setTransactionamount(transactionamount);
			walletHistory.setTransactionstatus("DEBIT");
			walletHistory.setWalletid(wallet.getId());
			walletHistory.setTransactiondescription("Amount of "+transactionamount+" "+transactionDto.getTransactionInfo().getSourceCurrencyIsoCode()+" has been used during send money transaction reference tfpin :"+tfpin+" ");
			walletHistory.setTransactiondate(LocalDateTime.now());
			walletHistory.setAccountcode("CST");
			walletHistory.setPartnerid(partner.getId());
			walletHistoryRepository.save(walletHistory);
		
		if(result ==0) {
			tfpin ="FAILED";
		}
		return tfpin;
	    }
	}

	@Override
	public String coopTranfercancel(CancelorComplaintDto cancelorComplaintDto) throws TransactionServiceException {
		SendMoneyTransaction sendMoneyTransaction = null;
		sendMoneyTransaction = new SendMoneyTransaction();
		sendMoneyTransaction = sendMoneyTransactionRepository.findbyTfPin(cancelorComplaintDto.getTfPin());
		sendMoneyTransaction.setStatusid("C");
		sendMoneyTransaction.setStatusname("CANCELLED");
		sendMoneyTransaction.setCancelreasonid(String.valueOf(cancelorComplaintDto.getReasonId()));
		
		Optional<CancelReason> options = cancelReasonRepository.findById(cancelorComplaintDto.getReasonId());
		if(options.isPresent()) {
			CancelReason cancelReason = null;
			cancelReason = options.get();
			sendMoneyTransaction.setCancelreasonname(cancelReason.getReasonName());
		}
		
		
		int recs =sendMoneyTransactionRepository.save(sendMoneyTransaction).getId();
		if(recs>0) {
			TransactionHistory transactionHistory = null;
			transactionHistory = new TransactionHistory();
			transactionHistory.setStatusid("C");
			transactionHistory.setStatusname("CANCELLED");
			transactionHistory.setTfpin(cancelorComplaintDto.getTfPin());
			transactionHistoryRepository.save(transactionHistory);
			return "SUCCESS";	
				
		}else {
		return "FAILURE";
		}
	}

	@Override
	public String coopTransfercomplaint(CancelorComplaintDto cancelorComplaintDto) throws TransactionServiceException {
		CustomerComplaints customerComplaints = null;
		customerComplaints = new CustomerComplaints();
		customerComplaints.setDescription(cancelorComplaintDto.getDescription());
		customerComplaints.setPetitiontype(cancelorComplaintDto.getPetitionType());
		ComplaintsAndPetitions complaintsAndPetition = null;
		Optional<ComplaintsAndPetitions> complaintsAndPetitions =complaintsAndPetitionsRepository.findById(Integer.parseInt(cancelorComplaintDto.getPetitionType()));
		if(complaintsAndPetitions.isPresent()) {
			complaintsAndPetition =complaintsAndPetitions.get();
			customerComplaints.setPetitiontype(complaintsAndPetition.getComplaintName());
		}
		customerComplaints.setTfpin(cancelorComplaintDto.getTfPin());
		customerComplaints.setStatus("NEW");
		customerComplaints.setTransactiontype(cancelorComplaintDto.getTransactionType());
		int recs = customerComplaintRepository.save(customerComplaints).getId();
		if(recs>0) {
					SecurityContext securityContext = SecurityContextHolder.getContext();
				    Authentication authentication = securityContext.getAuthentication();
				    String username  =null;
				    if (authentication.getPrincipal() instanceof UserDetails) {
				    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
				    }
				else if(authentication.getPrincipal() instanceof String) {
					username = (String) authentication.getPrincipal();
				}
	  
			//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
			User user = null;
			user = userRepository.findByUsername(username);
			 Twilio.init("AC58bc3668ea1544a8bb69f745f642a933", "9185158d2ea6518e1178805630b68f0b");
		    String phoneno ="+50763516303";
			String message1 ="A new complaint has been raised for tfpin :"+cancelorComplaintDto.getTfPin()+" / Description :"+cancelorComplaintDto.getDescription()+" ";
				Message.creator(new PhoneNumber(phoneno), new PhoneNumber("+17027896606"),
							message1).create();	
					
		String message2 ="A new complaint has been raised for tfpin :"+cancelorComplaintDto.getTfPin()+" / Description :"+cancelorComplaintDto.getDescription()+" ";
		 Message.creator(new PhoneNumber(String.valueOf(user.getMobilenumber())), new PhoneNumber("+17027896606"),
				 message2).create();				
		return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}

	@Override
	public List<SendMoneyTransactionDto> recieversendtransaction(Integer userid, String rolename, String transactiontype,String startdate,String enddate)
			throws TransactionServiceException {
		List<SendMoneyTransactionDto> sendMoneyTransactionDtos = new ArrayList<>();
		User user = null;
		user =userRepository.findById(userid).get();
			if(rolename.equalsIgnoreCase("TELLER")) {
			Teller teller = null;
			teller = tellerRepository.tellerByUserID(userid);
			Locations location  = null;
			Optional<Locations> locations  = locationsRepository.findById(teller.getLocationid());
			if(locations.isPresent()) {
			location = locations.get(); 
			if(startdate !=null && enddate!=null) {
		    sendMoneyTransactionRepository.getTransactionsbyBranchId(location.getBranchId(),"T",transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
			}else {
				 sendMoneyTransactionRepository.getTransactionsbyBranchIdAndDates(location.getBranchId(),"T",transactiontype,startdate,enddate).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
						
			}
			}
			}else {
				if(startdate !=null && enddate!=null) {
	    sendMoneyTransactionRepository.getTransactionsbyPartnerPayerId(String.valueOf(userid),"T",transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
				}else {
					  sendMoneyTransactionRepository.getTransactionsbyPartnerPayerIdDates(String.valueOf(userid),"T",transactiontype,startdate,enddate).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
								
				}
		}
		return sendMoneyTransactionDtos;
	}

	@Override
	public SendMoneyTransactionDto recievertansactionbytfpin(String tfpin,String statusid,Integer userid, String rolename) throws TransactionServiceException {
		SendMoneyTransactionDto sendMoneyTransactionDto = null;
		User user = null;
		user =userRepository.findById(userid).get();
		if(rolename.equalsIgnoreCase("TELLER")) {
			Teller teller = null;
			teller = tellerRepository.tellerByUserID(userid);
			Locations location  = null;
			Optional<Locations> locations  = locationsRepository.findById(teller.getLocationid());
		if(locations.isPresent()) {
			location = locations.get(); 
			sendMoneyTransactionDto = sendMoneyTransactionRepository.findByTfpinAndBranch(tfpin,statusid,location.getBranchId(),"CASHPICKUP").toSendMoneyTransactionDto();
			
		  	}
		}else {
			java.util.List<String> types = new ArrayList<>();
			types.add("CASHPICKUP");
			types.add("BANKDEPOSIT");
			sendMoneyTransactionDto = sendMoneyTransactionRepository.findByTfpinAndPayerId(tfpin,statusid,String.valueOf(userid),types).toSendMoneyTransactionDto();
			
		}
		return sendMoneyTransactionDto;
	}

	@Override
	public String cooprecievemoney(PaidDto paidDto, String username) throws TransactionServiceException {
		CoopRecieverTransaction coopRecieverTransaction = null;
		coopRecieverTransaction = new CoopRecieverTransaction();
		coopRecieverTransaction.setFormofpaymentid(paidDto.getFormOfPaymentId());
	    FormOfPayments	 formOfPayment = null;
	    Optional<FormOfPayments> formOfPayments = formOfPaymentsRepository.findById(Integer.parseInt(paidDto.getFormOfPaymentId()));
	    if(formOfPayments.isPresent()) {
	    	formOfPayment =formOfPayments.get();
	    	coopRecieverTransaction.setFormofpayment(formOfPayment.getPaymentName());
	    }
	    coopRecieverTransaction.setIdentificationnumber(paidDto.getIdNumber());
	    coopRecieverTransaction.setIdtype(paidDto.getIdType());
	    
	     Optional<PayerRecieverID> payerRecieverIDs= payerRecieverIDRepository.findById(Integer.parseInt(paidDto.getIdType()));
	     if(payerRecieverIDs.isPresent()) {
	    	 PayerRecieverID payerRecieverID =null;	 
	    	 payerRecieverID = payerRecieverIDs.get();
	    	 coopRecieverTransaction.setIdtypename(payerRecieverID.getIdentifierName());
	    	 
	     }
	    
	    coopRecieverTransaction.setIdexpirationdate(paidDto.getIdExpirationDate());
	    coopRecieverTransaction.setIssuedate(paidDto.getIdDateOfIssue());
	    coopRecieverTransaction.setReceiptno(userRepository.uniqueSequenceNumber());
	    coopRecieverTransaction.setRecieveraddress(paidDto.getReceiverAddress());
	    coopRecieverTransaction.setRecievername(paidDto.getRecieverfullname());
	    coopRecieverTransaction.setRecievergender(paidDto.getReceiverGender());
	    coopRecieverTransaction.setRecieverhome(paidDto.getReceiverPhoneHome());
	    coopRecieverTransaction.setRecieverrelationship(paidDto.getReceiverRelationToSender());
	    coopRecieverTransaction.setRemittancepurposeid(String.valueOf(paidDto.getPurposeofremittanceid()));
	    PayerRemittance payerRemittance = null;
	    Optional<PayerRemittance> payerRemittances = payerRemittanceRepository.findById(paidDto.getPurposeofremittanceid());
	    if(payerRemittances.isPresent()) {
	    	payerRemittance =payerRemittances.get();
	    	coopRecieverTransaction.setRemittancepurpose(payerRemittance.getRemittanceName());
	    }
	    coopRecieverTransaction.setRecievermobile(paidDto.getReceiverPhone());
	    coopRecieverTransaction.setRecieverwork(paidDto.getReceiverPhoneMobile());
	    coopRecieverTransaction.setTfpin(paidDto.getTfPin());
	    coopRecieverTransaction.setTransactiontype(paidDto.getTransactiontype());
	    
	    
	    Country country = null;
		country = countryRepository.findbyCountryCode(paidDto.getRecievercountry());
		coopRecieverTransaction.setRecievercountry(country.getName());
		State state = null;
		Optional<State> states = null;
		states = stateRepository.findById(Integer.parseInt(paidDto.getReceiverStateId()));
		if(states.isPresent()) {
			state = states.get();
			coopRecieverTransaction.setRecieverstate(state.getStateName());
		}
		
		City city = null;
		Optional<City> cities = null;
		cities = cityRepository.findById(Integer.parseInt(paidDto.getRecievercity()));
		if(cities.isPresent()) {
			city = cities.get();
			coopRecieverTransaction.setRecievercity(city.getCityName());
		}
		
		CoopRecieveMoneyTransInfo coopRecieveMoneyTransInfo = null;
		coopRecieveMoneyTransInfo = new CoopRecieveMoneyTransInfo();
		coopRecieveMoneyTransInfo.setAccountnumber(paidDto.getAccountnumber());
		coopRecieveMoneyTransInfo.setAccounttype(paidDto.getRecieveraccounttype());
		coopRecieveMoneyTransInfo.setAmount(paidDto.getRecieveramount()); 
		coopRecieveMoneyTransInfo.setBankname(paidDto.getBankname());
		coopRecieveMoneyTransInfo.setServicefees(paidDto.getServicefees());
		coopRecieveMoneyTransInfo.setTax(paidDto.getTaxes());
		coopRecieveMoneyTransInfo.setTotalamount(paidDto.getTotalamount());
		coopRecieveMoneyTransInfo.setSendercurrencycode(paidDto.getSendercurrency());
		coopRecieveMoneyTransInfo.setRecievercurrencycode(paidDto.getRecievercurrency());
		coopRecieveMoneyTransInfo.setCooprecievertransaction(coopRecieverTransaction);
		
		coopRecieverTransaction.setCoopRecieveMoneyTransInfo(coopRecieveMoneyTransInfo);
		coopRecieverTransaction.setStatus("P");
	    
		int recs =coopRecieverTransactionRepository.save(coopRecieverTransaction).getId();
		if(recs>0) {
			SendMoneyTransaction sendMoneyTransaction = null;
			sendMoneyTransaction = sendMoneyTransactionRepository.findbyTfPin(paidDto.getTfPin());
			sendMoneyTransaction.setStatusid("P");
			sendMoneyTransaction.setStatusname("PAID");
			
			recs =sendMoneyTransactionRepository.save(sendMoneyTransaction).getId();
		}
		if(recs>0) {

   			User user =null;
  	    	user = userRepository.findByUsername(username);
  	    	Teller teller1 = null;
  	    	Partner partner =null;
   		if(paidDto.getRole().equalsIgnoreCase("TELLER")) {
   			
   			teller1 = tellerRepository.tellerByUserID(user.getId());
  			 user =null;
  			user = userRepository.findByUsername(teller1.getCreated_by());
  			partner = partnerRepository.partnerDetailsByUserId(user.getId());	
   			
   		}else {
   		partner = partnerRepository.partnerDetailsByUserId(user.getId());
   		}
			Wallet wallet =null;
			String accountype =null;
			if(paidDto.getPaymentModeId().equalsIgnoreCase("CASHPICKUP")) {
				accountype ="CCP";
			}else {
				accountype ="CBD";
			}
			wallet = walletRepository.findwalletbyUserAndCode(partner.getId(),accountype);
			float transactionamount =paidDto.getRecieveramount() + paidDto.getServicefees()+paidDto.getTaxes();
			float newbalance = wallet.getWalletamount() + paidDto.getRecieveramount(); 
			wallet.setWalletamount(newbalance);
			walletRepository.save(wallet);
			
			float newcreditlimit = partner.getCreditamount()+transactionamount;
  			partner.setCreditamount(newcreditlimit);
  			partnerRepository.save(partner);
			
			WalletHistory walletHistory =null;
			walletHistory = new WalletHistory();
			walletHistory.setAccountnumber(wallet.getAccountnumber());
			walletHistory.setCurrentbalance(newbalance);
			walletHistory.setTransactionamount(transactionamount);
			walletHistory.setTransactionstatus("CREDIT");
			walletHistory.setWalletid(wallet.getId());
			walletHistory.setTransactiondescription("An amount of "+transactionamount+" "+paidDto.getReceiverCountryIsoCode()+" has been recieved , transaction reference tfpin :"+paidDto.getTfPin()+" ");
			walletHistory.setAccountcode(accountype);
			walletHistory.setPartnerid(partner.getId());
			walletHistory.setTransactiondate(LocalDateTime.now());
			walletHistoryRepository.save(walletHistory);
			return "SUCCESS";	
		}else {
			return "FAILURE";	
		}
		
	}

	@Override
	public List<SendMoneyTransactionDto> cooppaidtransaction(Integer userid, String rolename, String transactiontype, String startdate,
			String enddate) throws TransactionServiceException {
		List<SendMoneyTransactionDto> sendMoneyTransactionDtos = new ArrayList<>();
		User user = null;
		user =userRepository.findById(userid).get();
			if(rolename.equalsIgnoreCase("TELLER")) {
			Teller teller = null;
			teller = tellerRepository.tellerByUserID(userid);
			Locations location  = null;
			Optional<Locations> locations  = locationsRepository.findById(teller.getLocationid());
			if(locations.isPresent()) {
			location = locations.get(); 
			if(startdate !=null && enddate !=null) {
				 sendMoneyTransactionRepository.getTransactionsbyBranchIdAndDates(location.getBranchId(),"P",transactiontype,startdate,enddate)
				 .iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
						
			}else {
			 sendMoneyTransactionRepository.getTransactionsbyBranchId(location.getBranchId(),"P",transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
			}
			}
			}else {
				if(startdate !=null && enddate !=null) {
					 sendMoneyTransactionRepository.getTransactionsbyPartnerPayerIdDates(String.valueOf(userid),"P",transactiontype,startdate,enddate).iterator()
					 .forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
							
					
				}else {
	    sendMoneyTransactionRepository.getTransactionsbyPartnerPayerId(String.valueOf(userid),"P",transactiontype).iterator().forEachRemaining(sendmoneytransaction -> sendMoneyTransactionDtos.add(sendmoneytransaction.toSendMoneyTransactionDto()));
				}	
		}
		return sendMoneyTransactionDtos;
	}

	@Override
	public CoopRecieverTransactionDto paidtransactiobyTfpin(String tfpin) throws TransactionServiceException {
		CoopRecieverTransactionDto coopRecieverTransactionDto = null;
			coopRecieverTransactionDto = coopRecieverTransactionRepository.getbyTfPin(tfpin).tocoopRecieverTransactionDto();
		return coopRecieverTransactionDto;
	}

	@Override
	public int sendtransfers(Integer partnerid, String transactiontype, String statusid)
			throws TransactionServiceException {
		if(statusid.equalsIgnoreCase("ALL") && transactiontype.equalsIgnoreCase("COOPTRANSFER")) {
		
			return sendMoneyTransactionRepository.findbyCoopPartners(String.valueOf(partnerid),transactiontype);
				
		}
		else if(statusid.equalsIgnoreCase("ALL") && transactiontype.equalsIgnoreCase("TRANSFAST")) {
			
			return sendMoneyTransactionRepository.findbyTransfastPartners(transactiontype,String.valueOf(partnerid));
				
		}
		else if(statusid.equalsIgnoreCase("PAID") && transactiontype.equalsIgnoreCase("ALL")) {
			
			int recs =recieverTransactionRepository.findbyTransfastPaidRecords(String.valueOf(partnerid));
			int recs1 =sendMoneyTransactionRepository.findbyCoopPaidRecords(String.valueOf(partnerid));
			
		return recs+recs1;
		
		}
		else  if(statusid.equalsIgnoreCase("TRANSMIT") && transactiontype.equalsIgnoreCase("ALL")) {
    	   
    	   int recs =sendMoneyTransactionRepository.findbyCoopPartnersbyStatus(String.valueOf(partnerid),"COOPTRANSFER");
    	   int recs1 =sendMoneyTransactionRepository.findbyTransfastPartnersbyStatus("TRANSFAST",String.valueOf(partnerid));
			
			return recs+recs1;
				
		}else {
			return 0;
		}
		
		
		
	}

	@Override
	public int complaintscomments(CustomerCommentsDto customerCommentsDto) throws TransactionServiceException {
		CustomerComplaints customerComplaint = null;
		Optional<CustomerComplaints> customerComplaints = customerComplaintRepository.findById(customerCommentsDto.getId());
		int recs =0;
		if(customerComplaints.isPresent()) {
			customerComplaint =customerComplaints.get();
			 List<CustomerComments> customerComments = null;
			 customerComments = new ArrayList<>();
			 CustomerComments stDtos =null;
			 stDtos  =new CustomerComments();
			 stDtos.setComments(customerCommentsDto.getComments());
			 stDtos.setCustomercomplaints(customerComplaint);
			 stDtos.setSatus(customerCommentsDto.getNewstatus());
			 customerComments.add(stDtos);
			 customerComplaint.setCustomercomments(customerComments);
			 customerComplaint.setStatus(customerCommentsDto.getNewstatus());
			recs = customerComplaintRepository.save(customerComplaint).getId();
			
			
			User user = null;
			user = userRepository.findByUsername(customerComplaint.getCreated_by());
			 Twilio.init("AC58bc3668ea1544a8bb69f745f642a933", "9185158d2ea6518e1178805630b68f0b");
		    String phoneno ="+50763516303";
			String message1 =" Please find the complaint status ("+customerCommentsDto.getNewstatus()+") for your  tfpin("+customerComplaint.getTfpin()+") ";
				Message.creator(new PhoneNumber(phoneno), new PhoneNumber("+17027896606"),
							message1).create();	
					
		 
				/*Message.creator(new PhoneNumber(String.valueOf(user.getMobilenumber())), new PhoneNumber("+17027896606"),
				 message1).create();*/		
			return recs;
			
		}else {
			return recs;
		}
		
		
	}

	@Override
	public int updatecomplaintstatus(String tfpin, String status) throws TransactionServiceException {
		CustomerComplaints customerComplaint = null;
		customerComplaint = customerComplaintRepository.findByTfpin(tfpin);
		customerComplaint.setStatus(status);
		return customerComplaintRepository.save(customerComplaint).getId();
		
	}

	@Override
	public List<ComplaintStatusDto> complaintstatuses(String status) throws TransactionServiceException {
		List<ComplaintStatusDto> complaintStatusDtos = new ArrayList<>();
		System.out.println("status"+status);
		complaintStatusRepository.getnewComplaitStatus(status).iterator().forEachRemaining(complaintstatus -> complaintStatusDtos.add(complaintstatus.toComplaintStatusDto()));
		return complaintStatusDtos;
	}

	@Override
	public List<CustomerComplaintsDto> coopTransfercomplaint(Integer userid, String role)
			throws TransactionServiceException {
		List<CustomerComplaintsDto> customerComplaintsDtos = new ArrayList<>();
		if(role.equalsIgnoreCase("ADMIN")) {
			
			
			customerComplaintRepository.findByOrder().iterator().forEachRemaining(customerComplaint -> customerComplaintsDtos.add(customerComplaint.toCustomerComplaintsDto()));
			return customerComplaintsDtos;	
		}else if(role.equalsIgnoreCase("PARTNER")) {
			User user = null;
			Optional <User> users = userRepository.findById(userid);
			if(users.isPresent()) {
				user = users.get();
				customerComplaintRepository.findByPartnerName(user.getUsername(),user.getUsername()).iterator().forEachRemaining(customerComplaint -> customerComplaintsDtos.add(customerComplaint.toCustomerComplaintsDto()));
				return customerComplaintsDtos;		
				
			}
			return customerComplaintsDtos;
			
			
		}else{
		User user = null;
		Optional <User> users = userRepository.findById(userid);
		if(users.isPresent()) {
			user = users.get();
			customerComplaintRepository.findByUserName(user.getUsername()).iterator().forEachRemaining(customerComplaint -> customerComplaintsDtos.add(customerComplaint.toCustomerComplaintsDto()));
			return customerComplaintsDtos;		
			
		   }else {
			   return customerComplaintsDtos;
		   }
			
		}
	
	}

	@Override
	public List<WalletHistoryDto> walletHistory(Integer partnerid, String accountcode, String startdate,
			String enddate) {
		List<WalletHistoryDto> walletHistoryDtos = new ArrayList<>();
		walletHistoryRepository.walletHistoryByDates(partnerid,accountcode,startdate,enddate).iterator().forEachRemaining(wallethistory -> walletHistoryDtos.add(wallethistory.toWalletHistoryDto()));
		return walletHistoryDtos;
	}

	
	

}
