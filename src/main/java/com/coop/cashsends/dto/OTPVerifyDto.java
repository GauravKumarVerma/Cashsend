package com.coop.cashsends.dto;

public class OTPVerifyDto {

private String mobilenumber;
private String otp;

public String getOtp() {
	return otp;
}

public void setOtp(String otp) {
	this.otp = otp;
}

public String getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}



}
