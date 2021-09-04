package com.coop.cashsends.dto;

public class CancelReasonDto {
	
	public Integer id;	
	public String ReasonName;
	private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getReasonName() {
		return ReasonName;
	}
	public void setReasonName(String reasonName) {
		ReasonName = reasonName;
	}
	
	
	

}
