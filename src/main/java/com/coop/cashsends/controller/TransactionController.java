package com.coop.cashsends.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.cashsends.dto.ApiResponse;
import com.coop.cashsends.dto.CancelorComplaintDto;
import com.coop.cashsends.dto.CreditLimitDto;
import com.coop.cashsends.dto.CustomerCommentsDto;
import com.coop.cashsends.dto.CustomerComplaintsDto;
import com.coop.cashsends.dto.PaidDto;
import com.coop.cashsends.dto.PendingListsDto;
import com.coop.cashsends.dto.RecieverPendingDto;
import com.coop.cashsends.dto.SendMoneyDto;
import com.coop.cashsends.dto.TransactionDto;
import com.coop.cashsends.dto.UserDto;
import com.coop.cashsends.exception.ResourceNotFoundException;
import com.coop.cashsends.exception.TransactionServiceException;
import com.coop.cashsends.exception.UserServiceException;
import com.coop.cashsends.service.AuthenticationFacadeService;
import com.coop.cashsends.service.TransactionService;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

	public static final String SUCCESS = "success";
	public static final String ROLE_COUNTRY_MANAGER = "ROLE_COUNTRY_MANAGER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_PARTNER = "ROLE_PARTNER";
	public static final String ROLE_TELLER = "ROLE_TELLER";	
	
	//@Autowired
	private AuthenticationFacadeService authenticationFacadeService;
	
	@Autowired
	private TransactionService transactionService;
	
	//@Secured({ROLE_TELLER})
	@PreAuthorize("hasRole('TELLER')")
	@PostMapping(value = "sendmoney")
	@CrossOrigin
	public ApiResponse SendMoney(@RequestBody TransactionDto transactionDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to send money by teller %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
			SecurityContext securityContext = SecurityContextHolder.getContext();
		    Authentication authentication = securityContext.getAuthentication();
		    String username  =null;
		    if (authentication.getPrincipal() instanceof UserDetails) {
		    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
		    }
		else if(authentication.getPrincipal() instanceof String) {
			username = (String) authentication.getPrincipal();
		}
	  
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.sendMoney(transactionDto,username));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "sendmoneylocal")
	@CrossOrigin
	public ApiResponse SendMoneylocal(@RequestBody TransactionDto transactionDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.SendMoneylocal(transactionDto));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "cancel")
	@CrossOrigin
	public ApiResponse cancelTransaction(@RequestBody CancelorComplaintDto cancelorComplaintDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.cancelTransaction(cancelorComplaintDto));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "complaint")
	@CrossOrigin
	public ApiResponse raiseComplaint(@RequestBody CancelorComplaintDto cancelorComplaintDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.raiseComplaint(cancelorComplaintDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "telleractivity")
	@CrossOrigin
	public ApiResponse telleractivity() throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.telleractivity());
	}
	
	//@Secured({ROLE_PARTNER})
	@PreAuthorize("hasRole('PARTNER')")
	@GetMapping(value = "telleractivityagent")
	@CrossOrigin
	public ApiResponse tellerActivityagent() throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString(); 
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    String username  =null;
	    if (authentication.getPrincipal() instanceof UserDetails) {
	    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
	    }
	else if(authentication.getPrincipal() instanceof String) {
		username = (String) authentication.getPrincipal();
	}
  
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.tellerActivityagent(username));
	}
	
	//@Secured({ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "telleractivitymanager")
	@CrossOrigin
	public ApiResponse tellerActivitymanager() throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    String username  =null;
	    if (authentication.getPrincipal() instanceof UserDetails) {
	    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
	    }
	else if(authentication.getPrincipal() instanceof String) {
		username = (String) authentication.getPrincipal();
	}
  
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.tellerActivitymanager(username));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "wallethistory/{partnerid}/{accountcode}/{startdate}/{enddate}")
	@CrossOrigin
	public ApiResponse walletHistory(@PathVariable Integer partnerid,@PathVariable String accountcode,@PathVariable String startdate,@PathVariable String enddate) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get wallethistory %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.walletHistory(partnerid,accountcode,startdate,enddate));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "creditlimit")
	@CrossOrigin
	public ApiResponse creditLimit(@RequestBody CreditLimitDto creditLimitDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get wallethistory %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.creditLimit(creditLimitDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "alltransactions/{partnerid}")
	@CrossOrigin
	public ApiResponse allTransactions(@PathVariable Integer partnerid) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get all transactions %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.allTransactions(partnerid));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recievertransactions/{startdate}/{enddate}/{role}")
	@CrossOrigin
	public ApiResponse recievertransactions(@PathVariable String startdate,@PathVariable String enddate,String role) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get all transactions %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  //String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
			SecurityContext securityContext = SecurityContextHolder.getContext();
		    Authentication authentication = securityContext.getAuthentication();
		    String username  =null;
		    if (authentication.getPrincipal() instanceof UserDetails) {
		    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
		    }
		else if(authentication.getPrincipal() instanceof String) {
			username = (String) authentication.getPrincipal();
		}

	 return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.recievertransactions(startdate,enddate,role,username));
	}

	//@Secured({ROLE_COUNTRY_MANAGER,ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "recievemoney")
	@CrossOrigin
	public ApiResponse recievemoney(@RequestBody PaidDto paidDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to recieve money by country manager %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
	SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    String username  =null;
    if (authentication.getPrincipal() instanceof UserDetails) {
    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
    }
else if(authentication.getPrincipal() instanceof String) {
	username = (String) authentication.getPrincipal();
}

	  
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.recieveMoney(paidDto,username));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER,ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "paidtransction/{tfpin}")
	@CrossOrigin
	public ApiResponse paidtransction(@PathVariable String tfpin) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get paid transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
	SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    String username  =null;
    if (authentication.getPrincipal() instanceof UserDetails) {
    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
    }
else if(authentication.getPrincipal() instanceof String) {
	username = (String) authentication.getPrincipal();
}

	  
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.paidtransction(tfpin));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "sendmoneytractions/{tfpin}")
	@CrossOrigin
	public ApiResponse sendmoneytractions(@PathVariable String tfpin) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get send money transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.sendmoneytractions(tfpin));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recievertransactions/{partnerid}")
	@CrossOrigin
	public ApiResponse recievertransactions(@PathVariable Integer partnerid) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get all transactions %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.recievertransactions(partnerid));
	}
	
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "pendinglists/{countrycode}")
	@CrossOrigin
	public ApiResponse pendingLists(@PathVariable String countrycode) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get all pending lists %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.pendingLists(countrycode));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "savePendinglist")
	@CrossOrigin
	public ApiResponse savePendingList(@RequestBody RecieverPendingDto recieverPendingDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("saving the pending lists %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.savePendingList(recieverPendingDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER,ROLE_TELLER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "deletependinglists/{tfpin}")
	@CrossOrigin
	public ApiResponse deletePendinglists(@PathVariable String tfpin) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to delete tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.deletePendinglists(tfpin));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "recivercomplaint")
	@CrossOrigin
	public ApiResponse reciverComplaint(@RequestBody CancelorComplaintDto cancelorComplaintDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.reciverComplaint(cancelorComplaintDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "retrivesendmoneytractions/{userid}/{rolename}/{transactiontype}/{startdate}/{enddate}")
	@CrossOrigin
	public ApiResponse retrivesendmoneytractions(@PathVariable Integer userid,@PathVariable String rolename,@PathVariable String transactiontype,
			@PathVariable String startdate,@PathVariable String enddate) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get send money transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.retrivesendmoneytractions(userid,rolename,transactiontype,startdate,enddate ));
	}
	
	//@Secured({ROLE_TELLER})
	@PreAuthorize("hasRole('TELLER')")
	@PostMapping(value = "coopsendmoney")
	@CrossOrigin
	public ApiResponse coopSendMoney(@RequestBody TransactionDto transactionDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to send money by teller %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
	SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    String username  =null;
    if (authentication.getPrincipal() instanceof UserDetails) {
    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
    }
else if(authentication.getPrincipal() instanceof String) {
	username = (String) authentication.getPrincipal();
}

	  
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.coopSendMoney(transactionDto,username));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "cooptranfercancel")
	@CrossOrigin
	public ApiResponse coopTranfercancel(@RequestBody CancelorComplaintDto cancelorComplaintDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.coopTranfercancel(cancelorComplaintDto));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "cooptransfercomplaint")
	@CrossOrigin
	public ApiResponse coopTransfercomplaint(@RequestBody CancelorComplaintDto cancelorComplaintDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.coopTransfercomplaint(cancelorComplaintDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recieversendtransaction/{userid}/{rolename}/{transactiontype}/{startdate}/{enddate}")
	@CrossOrigin
	public ApiResponse recieversendtransaction(@PathVariable Integer userid,@PathVariable String rolename,@PathVariable String transactiontype,
			@PathVariable String startdate,@PathVariable String enddate) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get send money transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.recieversendtransaction(userid,rolename,transactiontype,startdate,enddate));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recievertansactionbytfpin/{tfpin}/{statusid}/{userid}/{rolename}")
	@CrossOrigin
	public ApiResponse recievertansactionbytfpin(@PathVariable String tfpin,@PathVariable String statusid,@PathVariable Integer userid,
			@PathVariable String rolename) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get send money transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.recievertansactionbytfpin(tfpin,statusid,userid,rolename));
	}
	

	//@Secured({ROLE_COUNTRY_MANAGER,ROLE_TELLER,ROLE_PARTNER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "cooprecievemoney")
	@CrossOrigin
	public ApiResponse cooprecievemoney(@RequestBody PaidDto paidDto) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to coop recieve money by country manager %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	//String username = authenticationFacadeService.getAuthentication().getPrincipal().toString();
	SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    String username  =null;
    if (authentication.getPrincipal() instanceof UserDetails) {
    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
    }
else if(authentication.getPrincipal() instanceof String) {
	username = (String) authentication.getPrincipal();
}

	  
	return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.cooprecievemoney(paidDto,username));
	}
	
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "cooppaidtransaction/{userid}/{rolename}/{transactiontype}/{startdate}/{enddate}")
	@CrossOrigin
	public ApiResponse cooppaidtransaction(@PathVariable Integer userid,@PathVariable String rolename,@PathVariable String transactiontype,String startdate,String enddate) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get paid transation list %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.cooppaidtransaction(userid,rolename,transactiontype,startdate,enddate));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "paidtransactiobyTfpin/{tfpin}")
	@CrossOrigin
	public ApiResponse paidtransactiobyTfpin( @PathVariable String tfpin) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get paid transaction by tfpin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.paidtransactiobyTfpin(tfpin));
	}
	
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "sendtransfers/{partnerid}/{transactiontype}/{statusid}")
	@CrossOrigin
	public ApiResponse sendtransfers(@PathVariable Integer partnerid,@PathVariable String transactiontype,@PathVariable String statusid) throws ResourceNotFoundException, TransactionServiceException{
	//log.info(String.format("received request to get transaction history %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		
		return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.sendtransfers(partnerid,transactiontype,statusid));
	}
	
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER,ROLE_COUNTRY_MANAGER,ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "complaintscomments")
	@CrossOrigin
	public ApiResponse complaintscomments(@RequestBody CustomerCommentsDto customerCommentsDto) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.complaintscomments(customerCommentsDto));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER,ROLE_COUNTRY_MANAGER,ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "updatecomplaintstatus/{tfpin}/{status}")
	@CrossOrigin
	public ApiResponse updatecomplaintstatus(@PathVariable String tfpin,@PathVariable String status) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.updatecomplaintstatus(tfpin,status));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER,ROLE_COUNTRY_MANAGER,ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "complaintstatuses/{status}")
	@CrossOrigin
	public ApiResponse complaintstatuses(@PathVariable String status) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.complaintstatuses(status));
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER,ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER')")
	@GetMapping(value = "allcustomercomplaints/{userid}/{role}")
	@CrossOrigin
	public ApiResponse coopTransfercomplaint(@PathVariable Integer userid,@PathVariable String role) throws ResourceNotFoundException, TransactionServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, transactionService.coopTransfercomplaint(userid,role));
	}
}
