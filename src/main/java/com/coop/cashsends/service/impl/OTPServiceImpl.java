package com.coop.cashsends.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.coop.cashsends.dto.OTPVerifyDto;
import com.coop.cashsends.exception.OTPServiceException;
import com.coop.cashsends.service.OTPService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service(value = "otpService")
public class OTPServiceImpl implements OTPService {
	
	private static final Integer EXPIRE_MINS = 5;
	private LoadingCache<String, Integer> otpCache;

	public OTPServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	@Override
	public Integer generateOTP(String phone_number) throws OTPServiceException {
      Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(phone_number, otp);
		System.out.println(otp);
		try {
			 Twilio.init("AC58bc3668ea1544a8bb69f745f642a933", "9185158d2ea6518e1178805630b68f0b");
            Message message = Message.creator(new PhoneNumber("+"+phone_number), new PhoneNumber("+17027896606"),
				otp + "  is the OTP for your change password").create();
		}catch(Exception e) {
			
		}

		
		return otp;
	}

	@Override
	public boolean verifyOTP(OTPVerifyDto verifyDto) throws OTPServiceException  {
		boolean isOTPVerified = false;
		String number = verifyDto.getMobilenumber();

		try {
			Integer intnumber = otpCache.get(number);
			if(intnumber == Integer.parseInt(verifyDto.getOtp())) {
				isOTPVerified = true;
				 otpCache.invalidate(number);
			} else {
				isOTPVerified = false;
			}
			
		} catch (Exception e) {
			isOTPVerified = false;
		}
		return isOTPVerified;
	}	

}
