package com.coop.cashsends.dto;

public class ComplaintsDto {
	
	 private Integer id;	
	 private String petitiontype;
	 private String complainttype;
	 private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPetitiontype() {
		return petitiontype;
	}
	public void setPetitiontype(String petitiontype) {
		this.petitiontype = petitiontype;
	}
	public String getComplainttype() {
		return complainttype;
	}
	public void setComplainttype(String complainttype) {
		this.complainttype = complainttype;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	 
	 
	 
	 

}
