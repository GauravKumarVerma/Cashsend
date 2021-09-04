package com.coop.cashsends.dto;

public class ComplaintsAndPetitionsDto {
	
	  public Integer id;
	  public String ComplaintName;
	  public boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComplaintName() {
		return ComplaintName;
	}
	public void setComplaintName(String complaintName) {
		ComplaintName = complaintName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	  
	  

}
