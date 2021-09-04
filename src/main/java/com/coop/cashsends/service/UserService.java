package com.coop.cashsends.service;


import java.util.List;

import com.coop.cashsends.dto.ChangePasswordDto;
import com.coop.cashsends.dto.CountryManagerDto;
import com.coop.cashsends.dto.PartnerDto;
import com.coop.cashsends.dto.SendMoneyDto;
import com.coop.cashsends.dto.TellerDto;
import com.coop.cashsends.dto.UserDto;
import com.coop.cashsends.exception.UserServiceException;



public interface UserService {

	int createUser(UserDto user)throws UserServiceException;

	List<PartnerDto> allpartners(String username)throws UserServiceException;

	PartnerDto partnerDetails(Integer userid)throws UserServiceException;

	List<TellerDto> allTellers(String username)throws UserServiceException;

	UserDto findbyUsername(String username)throws UserServiceException;

	int updatePartner(PartnerDto partnerDto)throws UserServiceException;

	int updateTeller(TellerDto tellerDto)throws UserServiceException;

	UserDto findbyUserId(Integer userid)throws UserServiceException;

	String testmoney(SendMoneyDto sendMoneyDto)throws UserServiceException;

	List<PartnerDto> partnerdetails(String username)throws UserServiceException;

	List<CountryManagerDto> countryManagers(String username)throws UserServiceException;

	List<CountryManagerDto> managerDetails(Integer userid)throws UserServiceException;


	CountryManagerDto managerDetailsById(Integer userid)throws UserServiceException;

	List<CountryManagerDto> mycountrymanager(String username);

	List<PartnerDto> managerPartners(String username)throws UserServiceException;

	List<TellerDto> tellersForadmmin(Integer partnerid)throws UserServiceException;

	int changePassword(String username, ChangePasswordDto changePasswordDto)throws UserServiceException;

	int forgotPassword(UserDto userDto)throws UserServiceException;

	PartnerDto tellerpartnerdetails(Integer userid)throws UserServiceException;

	

}
