package com.coop.cashsends.controller;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.cashsends.exception.UserServiceException;
import com.coop.cashsends.service.AuthenticationFacadeService;
import com.coop.cashsends.service.UserService;
import com.coop.cashsends.dto.UserDto;
import com.coop.cashsends.dto.ApiResponse;
import com.coop.cashsends.dto.ChangePasswordDto;
import com.coop.cashsends.dto.PartnerDto;
import com.coop.cashsends.dto.SendMoneyDto;
import com.coop.cashsends.dto.TellerDto;
import com.coop.cashsends.exception.ResourceNotFoundException;
import com.coop.cashsends.exception.TransactionServiceException;


@RestController
@RequestMapping("api/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public static final String SUCCESS = "success";
	public static final String ROLE_COUNTRY_MANAGER = "ROLE_COUNTRY_MANAGER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_PARTNER = "ROLE_PARTNER";
	public static final String ROLE_TELLER = "ROLE_TELLER";
	
	//@Autowired
	private AuthenticationFacadeService authenticationFacadeService;
	@Autowired
	private UserService userService;
	//@Autowired
    //private TokenStore tokenStore;
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "createpartner")
	@CrossOrigin
	public ApiResponse createPartner(@RequestBody UserDto user) throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.createUser(user));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER})


	@PostMapping(value = "createcountryadmin")
	@PreAuthorize("hasRole('ADMIN')")
	@CrossOrigin
	public ApiResponse createCountryadmin(@RequestBody UserDto user) throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to create country admin %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.createUser(user));
	}
	
	//@Secured({ROLE_PARTNER})
    @PreAuthorize("hasRole('PARTNER')")
	@PostMapping(value = "createteller")
	@CrossOrigin
	public ApiResponse createTeller(@RequestBody UserDto user) throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to create teller %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.createUser(user));
	}
	
	//@Secured({ROLE_ADMIN})
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allpartners")
	@CrossOrigin
	public ApiResponse allPartners() throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.allpartners(username));
	}
	
	
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "partnerdetails/{userid}")
	@CrossOrigin
	public ApiResponse partnerDetails(@PathVariable Integer userid) throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to get partner details %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.partnerDetails(userid));
	}
	
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "alltellers")
	@CrossOrigin
	public ApiResponse allTellers() throws ResourceNotFoundException, UserServiceException{
	////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
	  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.allTellers(username));
	}
	 	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
		@CrossOrigin
	    @GetMapping(value = "findbyUsername/{username}")
	    public ApiResponse findbyUsername(@PathVariable String username) throws UserServiceException{
	     // //log.info(String.format("received request to find by username %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		 return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findbyUsername(username));
	    }
	 
	 
	 	//@Secured({ROLE_PARTNER,ROLE_ADMIN,ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
		@PostMapping(value = "updatepartner")
		@CrossOrigin
		public ApiResponse updatePartner(@RequestBody PartnerDto partnerDto) throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to update partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.updatePartner(partnerDto));
		} 
	 
	 	//@Secured({ROLE_PARTNER,ROLE_ADMIN})
	 	@PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER')")
		@PostMapping(value = "updateteller")
		@CrossOrigin
		public ApiResponse updateTeller(@RequestBody TellerDto tellerDto) throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to update teller %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.updateTeller(tellerDto));
		}
	 
	 	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	    @GetMapping(value = "findbyUserId/{userid}")
        @CrossOrigin
	    public ApiResponse findbyUserId(@PathVariable Integer userid) throws UserServiceException{
	    //  //log.info(String.format("received request to find by username %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		 return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findbyUserId(userid));
	    }
	 
	    @PostMapping(value = "testmoney")
		@CrossOrigin
		public ApiResponse testmoney(@RequestBody SendMoneyDto sendMoneyDto) throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to create partner %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.testmoney(sendMoneyDto));
		}
	 
	 	//@Secured({ROLE_PARTNER})
	    @PreAuthorize("hasRole('ADMIN')")
		@GetMapping(value = "mydetails")
		@CrossOrigin
		public ApiResponse partnerdetails() throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    String username  =null;
	    if (authentication.getPrincipal() instanceof UserDetails) {
	    	username = ((UserDetails) authentication.getPrincipal()).getUsername();
	    }
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.partnerdetails(username));
		}
	 
	 
	 	//@Secured({ROLE_ADMIN})
	 	@PreAuthorize("hasRole('ADMIN')")
		@GetMapping(value = "countrymanagerpartners")
		@CrossOrigin
		public ApiResponse countryManagers() throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.countryManagers(username));
		}
	 
	 	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('ADMIN') or hasRole('COUNTRY_MANAGER')")
		@GetMapping(value = "managerdetails/{userid}")
		@CrossOrigin
		public ApiResponse managerDetailsById(@PathVariable Integer userid) throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get manager details %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.managerDetailsById(userid));
		}
	 
	 	//@Secured({ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('COUNTRY_MANAGER')")
		@GetMapping(value = "mycountrymanager")
		@CrossOrigin
		public ApiResponse mycountrymanager() throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
	System.out.println("logged in user name " +username);
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.mycountrymanager(username));
		}
	 
	 	//@Secured({ROLE_COUNTRY_MANAGER})
	 	@PreAuthorize("hasRole('COUNTRY_MANAGER')")
		@GetMapping(value = "managerpartners")
		@CrossOrigin
		public ApiResponse managerPartners() throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get all partners %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.managerPartners(username));
		}
	 
	 	//@Secured({ROLE_ADMIN})
	 	@PreAuthorize("hasRole('ADMIN')")
		@GetMapping(value = "tellersforadmmin/{partnerid}")
		@CrossOrigin
		public ApiResponse tellersForadmmin(@PathVariable Integer partnerid) throws ResourceNotFoundException, UserServiceException{
		////log.info(String.format("received request to get all tellers for admin based on partner id %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.tellersForadmmin(partnerid));
		}
	 
	 //@Secured({ROLE_COUNTRY_MANAGER,ROLE_TELLER,ROLE_PARTNER})
	 @PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	 @PostMapping(value="changepassword")
	    @CrossOrigin
	    public ApiResponse changePassword(@RequestBody ChangePasswordDto changePasswordDto)throws ResourceNotFoundException,UserServiceException{
	        //log.info(String.format("received request to change password %s", authenticationFacadeService.getAuthentication().getPrincipal()));
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
	        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.changePassword(username,changePasswordDto));
	    }
	 
	 @PostMapping(value="forgotpassword")
	    @CrossOrigin
	    public ApiResponse forgotPassword(@RequestBody UserDto userDto)throws ResourceNotFoundException,UserServiceException{
	        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.forgotPassword(userDto));
	    }
	 
	    //@Secured({ROLE_TELLER})
	 	@PreAuthorize("hasRole('TELLER')")
		@GetMapping(value = "tellerpartnerdetails/{userid}")
		@CrossOrigin
		public ApiResponse tellerpartnerdetails(@PathVariable Integer userid) throws ResourceNotFoundException, UserServiceException{
		//log.info(String.format("received request to get partner details %s", authenticationFacadeService.getAuthentication().getPrincipal()));
		  return new ApiResponse(HttpStatus.OK, SUCCESS, userService.tellerpartnerdetails(userid));
		}
	 
	 @GetMapping(value ="logout")
	    @CrossOrigin
	    public ApiResponse logout(Principal principal,HttpServletRequest request, HttpServletResponse response) {
	       
	    	SecurityContext securityContext = SecurityContextHolder.getContext();
	        Authentication authentication = securityContext.getAuthentication();
	        String username  =null;
	        if (authentication.getPrincipal() instanceof UserDetails) {
	        	username = ((UserDetails) authentication.getPrincipal()).getUsername();
	        }
	        else if(authentication.getPrincipal() instanceof String) {
	        	username = (String) authentication.getPrincipal();
	        }
//	   		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientIdAndUserName("cashsends-client", username);
//			for (OAuth2AccessToken tokenx : tokens) {
//				tokenStore.removeAccessToken(tokenx);
//
//			}
			return new ApiResponse(HttpStatus.OK, SUCCESS, "SUCCESS");	
	 }	

}
