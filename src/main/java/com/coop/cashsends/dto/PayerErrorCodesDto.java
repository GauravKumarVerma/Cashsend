package com.coop.cashsends.dto;

public class PayerErrorCodesDto {
	
	public Integer id;
	public String ErrorCodes;
	public boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getErrorCodes() {
		return ErrorCodes;
	}
	public void setErrorCodes(String errorCodes) {
		ErrorCodes = errorCodes;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

}
