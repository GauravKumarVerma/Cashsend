package com.coop.cashsends.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coop.cashsends.dto.ChangePasswordDto;
import com.coop.cashsends.dto.CountryManagerDto;
import com.coop.cashsends.dto.PartnerDto;
import com.coop.cashsends.dto.SendMoneyDto;
import com.coop.cashsends.dto.TellerDto;
import com.coop.cashsends.dto.UserDto;
import com.coop.cashsends.exception.UserServiceException;
import com.coop.cashsends.model.CountryCodes;
import com.coop.cashsends.model.CountryManager;
import com.coop.cashsends.model.Partner;
import com.coop.cashsends.model.Role;
import com.coop.cashsends.model.RoleType;
import com.coop.cashsends.model.Teller;
import com.coop.cashsends.model.User;
import com.coop.cashsends.model.Wallet;
import com.coop.cashsends.model.WalletHistory;
import com.coop.cashsends.repository.UserRepository;
import com.coop.cashsends.repository.WalletHistoryRepository;
import com.coop.cashsends.repository.WalletRepository;
import com.coop.cashsends.service.UserService;
import com.twilio.Twilio;
import com.coop.cashsends.repository.CountryCodesRepository;
import com.coop.cashsends.repository.CountryManagerRepository;
import com.coop.cashsends.repository.PartnerRepository;
import com.coop.cashsends.repository.RoleRepository;
import com.coop.cashsends.repository.TellerRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;




@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	 @Autowired
	 private UserRepository userRepository;

	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	 
	 @Autowired
	 private RoleRepository roleRepository;
	 
	 @Autowired
	 private PartnerRepository partnerRepository;
	 
	 @Autowired
	 private TellerRepository tellerRepository;
	 
	 @Autowired
	 private WalletRepository walletRepository;
	 
	 @Autowired
	 private CountryManagerRepository countryManagerRepository;
	 
	 @Autowired
	 private WalletHistoryRepository walletHistoryRepository;
	 
	 @Autowired
	 private CountryCodesRepository countryCodesRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		   User user = userRepository.findByUsername(userId);
	        if(user == null){
	            log.error("Invalid username or password.");
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        Set<GrantedAuthority> grantedAuthorities = getAuthorities(user);


	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

	}
	
	 private Set<GrantedAuthority> getAuthorities(User user) {
	        Set<Role> roleByUserId = user.getRoles();
	        final Set<GrantedAuthority> authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().toString().toUpperCase())).collect(Collectors.toSet());
	        return authorities;
	    }

	@Override
	public int createUser(UserDto userDto) throws UserServiceException {
     int pkid =0;
     
       String password ="";
       if(userDto.getId() ==null) {
    	   password =userDto.getPassword();
    	   password= passwordEncoder.encode(userDto.getPassword());
       
       }else {
    	   password =userDto.getPassword();
       }

		User user =null;
		user = new User();
		user.setId(userDto.getId());
		user.setCheckpassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setMobilenumber(userDto.getMobilenumber());
		user.setIsactive(userDto.isIsactive());
		user.setUsername(userDto.getUsername());
		user.setPassword(password);
		user.setIsfirstuser(userDto.isIsfirstuser());
		List<RoleType> roleTypes = new ArrayList<>();
        userDto.getRole().stream().map(role -> roleTypes.add(RoleType.valueOf(role)));
        user.setRoles(roleRepository.find(userDto.getRole()));
        int userid = userRepository.save(user).getId();
        user =null;
        
        if(userDto.getUsertype().equalsIgnoreCase("PARTNER")) {
        
        Partner partner =null;
        partner = new Partner();
        partner.setId(userDto.getPartnerid());
        partner.setAddress(userDto.getAddress());
        partner.setBusinessname(userDto.getBusinessname());	
        partner.setCityid(userDto.getCityid());
        partner.setClosehours(userDto.getClosehours());
        partner.setCloseampm(userDto.getCloseampm());
        partner.setCountryid(userDto.getCountryid());
        partner.setEmail(userDto.getEmail());
        partner.setLatitude(0);
        partner.setLongitude(0);
        partner.setMobilenumber(userDto.getMobilenumber());
        partner.setRucnumber(userDto.getRucnumber());
        partner.setStateid(userDto.getStateid());
        partner.setTimezone(userDto.getTimezone());
        partner.setOpenampm(userDto.getOpenampm());
        partner.setOpenhour(userDto.getOpenhour());
        partner.setWhitelist(userDto.getWhitelist());
        partner.setFirstname(userDto.getFirstname());
        partner.setLastname(userDto.getLastname());
        partner.setCreditamount(userDto.getWalletamount());
        partner.setUserid(userid);
        if(userDto.getPartnerid() ==null) {
        
        List<Wallet> wallets = null;
        wallets = new ArrayList<>();
        
        Wallet wallet =null;
        wallet =new Wallet();
        wallet.setIsactive(true);
        wallet.setWalletamount(0);
        String uniquenumber =userRepository.uniqueSequenceNumber();
        String countrycode =userDto.getCountryid();
        String accountnumber =countrycode+"TST"+uniquenumber;
        wallet.setAccountnumber(accountnumber);
        wallet.setAccountcode("TST");
        wallet.setPartner(partner);
        
        Wallet wallet1 =null;
        wallet1 =new Wallet();
        wallet1.setIsactive(true);
        wallet1.setWalletamount(0);
        String uniquenumber1 =userRepository.uniqueSequenceNumber();
        String countrycode1 =userDto.getCountryid();
        String accountnumber1 =countrycode1+"TBD"+uniquenumber1;
        wallet1.setAccountnumber(accountnumber1);
        wallet1.setAccountcode("TBD");
        wallet1.setPartner(partner);
        
        Wallet wallet2 =null;
        wallet2 =new Wallet();
        wallet2.setIsactive(true);
        wallet2.setWalletamount(0);
        String uniquenumber2 =userRepository.uniqueSequenceNumber();
        String countrycode2 =userDto.getCountryid();
        String accountnumber2 =countrycode2+"TCP"+uniquenumber2;
        wallet2.setAccountnumber(accountnumber2);
        wallet2.setAccountcode("TCP");
        wallet2.setPartner(partner);
        

        Wallet wallet3 =null;
        wallet3 =new Wallet();
        wallet3.setIsactive(true);
        wallet3.setWalletamount(0);
        String uniquenumber3 =userRepository.uniqueSequenceNumber();
        String countrycode3 =userDto.getCountryid();
        String accountnumber3 =countrycode3+"CST"+uniquenumber3;
        wallet3.setAccountnumber(accountnumber3);
        wallet3.setAccountcode("CST");
        wallet3.setPartner(partner);
        
        Wallet wallet4 =null;
        wallet4 =new Wallet();
        wallet4.setIsactive(true);
        wallet4.setWalletamount(0);
        String uniquenumber4 =userRepository.uniqueSequenceNumber();
        String countrycode4 =userDto.getCountryid();
        String accountnumber4 =countrycode4+"CBD"+uniquenumber4;
        wallet4.setAccountnumber(accountnumber4);
        wallet4.setAccountcode("CBD");
        wallet4.setPartner(partner);
        
        Wallet wallet5 =null;
        wallet5 =new Wallet();
        wallet5.setIsactive(true);
        wallet5.setWalletamount(0);
        String uniquenumber5 =userRepository.uniqueSequenceNumber();
        String countrycode5 =userDto.getCountryid();
        String accountnumber5 =countrycode5+"CCP"+uniquenumber5;
        wallet5.setAccountnumber(accountnumber5);
        wallet5.setAccountcode("CCP");
        wallet5.setPartner(partner);
       
        wallets.add(wallet);
        wallets.add(wallet1);
        wallets.add(wallet2);
        wallets.add(wallet3);
        wallets.add(wallet4);
        wallets.add(wallet5);
       
        partner.setWallet(wallets);
        
        /*WalletHistory walletHistory =null;
		walletHistory = new WalletHistory();
		walletHistory.setAccountnumber(wallet.getAccountnumber());
		walletHistory.setCurrentbalance(userDto.getWalletamount());
		walletHistory.setTransactionamount(userDto.getWalletamount());
		walletHistory.setTransactionstatus("CREDIT");
		walletHistory.setWalletid(wallet.getId());
		walletHistory.setTransactiondescription("Amount of  "+userDto.getWalletamount()+" USD has been credited to your wallet ");
		walletHistory.setTransactiondate(LocalDateTime.now());
		walletHistoryRepository.save(walletHistory);*/
        
        }else {
        	List<Wallet> wallets = walletRepository.findwalletbyUser(userDto.getPartnerid());	
        	//wallet.setWalletamount(userDto.getWalletamount());
        	partner.setWallet(wallets);
        }
        
        
        pkid =partnerRepository.save(partner).getId();
        
        }else if (userDto.getUsertype().equalsIgnoreCase("TELLER")) {
        Teller teller =null;
        teller = new Teller();
        teller.setId(userDto.getTellerid());
        teller.setFirstname(userDto.getFirstname());
        teller.setLastname(userDto.getLastname());
        teller.setLocationid(userDto.getLocationid());
        teller.setMobilenumber(String.valueOf(userDto.getMobilenumber()));
        teller.setUserid(userid);
        teller.setCountryid(userDto.getCountryid());
        teller.setIsactive(userDto.isIsactive());
        teller.setPartnerid(userDto.getPartnerid());
        pkid =tellerRepository.save(teller).getId();	
        }
        else if (userDto.getUsertype().equalsIgnoreCase("COUNTRY_MANAGER")) {
            CountryManager countryManager =null;
            countryManager = new CountryManager();
            System.out.println(userDto.getTellerid());
            countryManager.setId(userDto.getTellerid());
            countryManager.setFirstname(userDto.getFirstname());
            countryManager.setLastname(userDto.getLastname());
            countryManager.setMobilenumber(userDto.getMobilenumber());
            countryManager.setEmail(userDto.getEmail());
            countryManager.setCountryid(userDto.getCountryid());
            countryManager.setUserid(userid);
            countryManager.setAddress(userDto.getAddress());
            countryManager.setIsactive(userDto.isIsactive());
            pkid =countryManagerRepository.save(countryManager).getId();	
            }
        
        try {
        Twilio.init("ACa0c9f31a8eb425d443b5e02fe08a2297", "ad65a74d8da1a612f02796d0b99271b3");
		String phoneno =String.valueOf(userDto.getMobilenumber());
		String message1 =" Welcome to Cashsends please find your login Details username:"+userDto.getUsername()+" Password :"+userDto.getPassword()+" ";
		Message message = Message.creator(new PhoneNumber(phoneno), new PhoneNumber("+17027896606"),
				message1).create();
        }catch(Exception e) {
        	
        }
        
		return pkid;
	}

	@Override
	public List<PartnerDto> allpartners(String username) throws UserServiceException {
		List<PartnerDto> partnerDto = new ArrayList<>();
		partnerRepository.findAllByOrder().iterator().forEachRemaining(partner -> partnerDto.add(partner.toPartnerDto()));
		return partnerDto;
	}

	@Override
	public PartnerDto partnerDetails(Integer userid) {
		PartnerDto  partnerDto =null;
		partnerDto =partnerRepository.partnerDetailsByUserId(userid).toPartnerDto();
		return partnerDto;
		
	}

	@Override
	public List<TellerDto> allTellers(String username) throws UserServiceException {
		List<TellerDto> tellerDto = new ArrayList<>();
		tellerRepository.allTellers(username).iterator().forEachRemaining(teller -> tellerDto.add(teller.toTellerDto()));
		return tellerDto;
	}

	@Override
	public UserDto findbyUsername(String username) throws UserServiceException {
		UserDto userDto =null;
		userDto = new UserDto();
		userDto =userRepository.findByUsername(username).toUserDto();
		return userDto;
	}

	@Override
	public int updatePartner(PartnerDto partnerDto) throws UserServiceException{
		int pkid =0;
		 Partner partner =null;
	        partner = new Partner();
	        partner.setAddress(partnerDto.getAddress());
	        partner.setBusinessname(partnerDto.getBusinessname());	
	        partner.setCityid(partnerDto.getCityid());
	        partner.setClosehours(partnerDto.getClosehours());
	        partner.setCloseampm(partnerDto.getCloseampm());
	        partner.setCountryid(partnerDto.getCountryid());
	        partner.setEmail(partnerDto.getEmail());
	        partner.setLatitude(0);
	        partner.setLongitude(0);
	        partner.setMobilenumber(partnerDto.getMobilenumber());
	        partner.setRucnumber(partnerDto.getRucnumber());
	        partner.setStateid(partnerDto.getStateid());
	        partner.setTimezone(partnerDto.getTimezone());
	        partner.setOpenampm(partnerDto.getOpenampm());
	        partner.setOpenhour(partnerDto.getOpenhour());
	        partner.setWhitelist(partnerDto.getWhitelist());
	        partner.setUserid(partnerDto.getUserid());
	        partner.setCreditamount(partnerDto.getCreditamount());
	        List<Wallet> wallet = null;
	        wallet = walletRepository.findwalletbyUser(partnerDto.getId());
	        partner.setWallet(wallet);
	        partner.setId(partnerDto.getId());
	        
	        pkid =partnerRepository.save(partner).getId();
		
		return pkid;
	}

	@Override
	public int updateTeller(TellerDto tellerDto) throws UserServiceException {
		int pkid =0;
		Teller teller =null;
		teller = new Teller();
		teller.setFirstname(tellerDto.getFirstname());
		teller.setLastname(tellerDto.getLastname());
		teller.setMobilenumber(tellerDto.getMobilenumber());
		teller.setId(tellerDto.getId());
		teller.setUserid(tellerDto.getUserid());
		
		return 0;
	}

	@Override
	public UserDto findbyUserId(Integer userid) throws UserServiceException {
		UserDto userDto =null;
		userDto = new UserDto();
		userDto =userRepository.findById(userid).get().toUserDto();
		return userDto;
	}

	@Override
	public String testmoney(SendMoneyDto sendMoneyDto) throws UserServiceException {
		//System.out.println("%%%%"+sendMoneyDto.getMyname());
		return null;
	}

	@Override
	public List<PartnerDto> partnerdetails(String username) throws UserServiceException {
		User user = null;
		 user = userRepository.findByUsername(username);
		 List<PartnerDto> partnerDto = new ArrayList<>();
			partnerRepository.partnerdetails(user.getId()).iterator().forEachRemaining(partner -> partnerDto.add(partner.toPartnerDto()));
			return partnerDto;
		
	}

	@Override
	public List<CountryManagerDto> countryManagers(String username) throws UserServiceException {
		List<CountryManagerDto> countryManagerDto = new ArrayList<>();
		countryManagerRepository.countryManagers(username).iterator().forEachRemaining(countrymanager -> countryManagerDto.add(countrymanager.tocCountryManagerDto()));
		return countryManagerDto;
	}

	@Override
	public List<CountryManagerDto> managerDetails(Integer userid) throws UserServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryManagerDto managerDetailsById(Integer userid) throws UserServiceException {
		CountryManagerDto  countryManagerDto =null;
		countryManagerDto =countryManagerRepository.managerDetailsByUserId(userid).tocCountryManagerDto();
		return countryManagerDto;
	}

	@Override
	public List<CountryManagerDto> mycountrymanager(String username) {
		User user = null;
		 user = userRepository.findByUsername(username);
		System.out.println("logged in user id " +user.getId());
		List<CountryManagerDto> countryManagerDto = new ArrayList<>();
		countryManagerRepository.mycountrymanager(user.getId()).iterator().forEachRemaining(countrymanager -> countryManagerDto.add(countrymanager.tocCountryManagerDto()));
		return countryManagerDto;
	}

	@Override
	public List<PartnerDto> managerPartners(String username) throws UserServiceException {
		List<PartnerDto> partnerDto = new ArrayList<>();
		partnerRepository.allPartners(username).iterator().forEachRemaining(partner -> partnerDto.add(partner.toPartnerDto()));
		return partnerDto;
	}

	@Override
	public List<TellerDto> tellersForadmmin(Integer partnerid) throws UserServiceException {
		List<TellerDto> tellerDto = new ArrayList<>();
		tellerRepository.tellersForadmmin(partnerid).iterator().forEachRemaining(teller -> tellerDto.add(teller.toTellerDto()));
		return tellerDto;
	}

	@Override
	public int changePassword(String username, ChangePasswordDto changePasswordDto) throws UserServiceException {
		int status =0;
		User user =null;
		user = userRepository.findByUsername(username);
		
		//byte[] decodedBytes = Base64.getDecoder().decode(changePasswordDto.getNewpassword());
		//String decodedString = new String(decodedBytes);
		user.setPassword(passwordEncoder.encode(changePasswordDto.getNewpassword()));
		user.setIsfirstuser(false);
		status =userRepository.save(user).getId();
		
		return status;
	}

	@Override
	public int forgotPassword(UserDto userDto) throws UserServiceException {
		int status =0;
		User user =null;
		user = userRepository.findByUsername(userDto.getUsername());
		
		//byte[] decodedBytes = Base64.getDecoder().decode(userDto.getPassword());
		//String decodedString = new String(decodedBytes);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		status =userRepository.save(user).getId();
		
		return status;
	}

	@Override
	public PartnerDto tellerpartnerdetails(Integer userid) throws UserServiceException {
		Teller teller = null;
		teller = tellerRepository.tellerByUserID(userid);
		User user =null;
		user = userRepository.findByUsername(teller.getCreated_by());
		PartnerDto partnerDto =null;
		partnerDto = new PartnerDto();
		partnerDto =partnerRepository.partnerDetailsByUserId(user.getId()).toPartnerDto();
		return partnerDto;
	}

	

	
	
	
}
