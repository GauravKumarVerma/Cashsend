package com.coop.cashsends.service;

import com.coop.cashsends.dto.OTPVerifyDto;
import com.coop.cashsends.exception.OTPServiceException;

public interface OTPService {

	Integer generateOTP(String phone_number) throws OTPServiceException;

	boolean verifyOTP(OTPVerifyDto verifyDto) throws OTPServiceException;

}
