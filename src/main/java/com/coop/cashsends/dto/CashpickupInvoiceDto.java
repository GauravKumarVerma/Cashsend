package com.coop.cashsends.dto;

import java.util.Date;

public class CashpickupInvoiceDto {
	
	private Integer id;	
	private String tfpin;
	private Date dob;
	private String gender; 
	private String relationship;
	private long mobilenumber;
	private long workphone;
	private long homephone;
	private String email;
	private String identificationtype;
	private String identificationnumber;
	private Date identificationdateissued;
	private Date identificationexpiration;
	private String remittancepurpose;
	private String paymentmode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTfpin() {
		return tfpin;
	}
	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public long getWorkphone() {
		return workphone;
	}
	public void setWorkphone(long workphone) {
		this.workphone = workphone;
	}
	public long getHomephone() {
		return homephone;
	}
	public void setHomephone(long homephone) {
		this.homephone = homephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentificationtype() {
		return identificationtype;
	}
	public void setIdentificationtype(String identificationtype) {
		this.identificationtype = identificationtype;
	}
	public String getIdentificationnumber() {
		return identificationnumber;
	}
	public void setIdentificationnumber(String identificationnumber) {
		this.identificationnumber = identificationnumber;
	}
	public Date getIdentificationdateissued() {
		return identificationdateissued;
	}
	public void setIdentificationdateissued(Date identificationdateissued) {
		this.identificationdateissued = identificationdateissued;
	}
	public Date getIdentificationexpiration() {
		return identificationexpiration;
	}
	public void setIdentificationexpiration(Date identificationexpiration) {
		this.identificationexpiration = identificationexpiration;
	}
	public String getRemittancepurpose() {
		return remittancepurpose;
	}
	public void setRemittancepurpose(String remittancepurpose) {
		this.remittancepurpose = remittancepurpose;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	
	

}
