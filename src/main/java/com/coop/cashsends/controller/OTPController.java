package com.coop.cashsends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.cashsends.dto.OTPRequestDto;
import com.coop.cashsends.dto.OTPVerifyDto;
import com.coop.cashsends.exception.OTPServiceException;
import com.coop.cashsends.exception.ResourceNotFoundException;
import com.coop.cashsends.service.OTPService;



@RestController
@RequestMapping("api/otp")
public class OTPController {
	
	private static final String SUCCESS = "Success";
	@Autowired
    private OTPService otpService;

	@PostMapping(path = "/generateotp", produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> generateOTPCall(@RequestBody OTPRequestDto request) throws ResourceNotFoundException, OTPServiceException {
		return ResponseEntity.ok(otpService.generateOTP(request.getPhone_number()));
	}
	
	@PostMapping(path ="/verifyOTP" , produces =  MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
	public boolean verifyOTPCall(@RequestBody OTPVerifyDto verifyDto) throws ResourceNotFoundException, OTPServiceException {
		return otpService.verifyOTP(verifyDto);
	}
		
	
}
