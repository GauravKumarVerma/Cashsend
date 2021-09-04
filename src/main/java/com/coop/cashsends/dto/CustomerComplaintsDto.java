package com.coop.cashsends.dto;

import java.util.Date;
import java.util.List;

public class CustomerComplaintsDto {

	 private Integer id;
	 private String description;
	 private String petitiontype;
	 private String tfpin;
	 private String status;
	 private String createdby;
	 private Date createddate;
	 private String transactiontype;
	 private List<CustomerCommentsDto> customercomments;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPetitiontype() {
		return petitiontype;
	}
	public void setPetitiontype(String petitiontype) {
		this.petitiontype = petitiontype;
	}
	public String getTfpin() {
		return tfpin;
	}
	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public List<CustomerCommentsDto> getCustomercomments() {
		return customercomments;
	}
	public void setCustomercomments(List<CustomerCommentsDto> customercomments) {
		this.customercomments = customercomments;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	 
	 
	 

}
