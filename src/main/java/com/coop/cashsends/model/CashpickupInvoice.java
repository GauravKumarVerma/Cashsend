package com.coop.cashsends.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;


@Entity
@Table(name = "cashpickup_invoice")
@EntityListeners(AuditingEntityListener.class)
public class CashpickupInvoice extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
    @Column(name = "tfpin")
    private String tfpin;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "relationship")
    private String relationship;
    @Column(name = "mobile_number")
    private long mobilenumber;
    @Column(name = "work_phone")
    private long workphone;
    @Column(name = "home_phone")
    private long homephone;
    @Column(name = "email")
    private String email;
    @Column(name = "identification_type")
    private String identificationtype;
    @Column(name = "identification_number")
    private String identificationnumber;
    @Column(name = "identification_date_issued")
    private Date identificationdateissued;
    @Column(name = "identification_expiration")
    private Date identificationexpiration;
    @Column(name = "remittance_purpose")
    private String remittancepurpose;
    @Column(name = "payment_mode")
    private String paymentmode;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashpickup_id")
    private CashpickupTransactions cashpickuptransactions;
    
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
	public CashpickupTransactions getCashpickuptransactions() {
		return cashpickuptransactions;
	}
	public void setCashpickuptransactions(CashpickupTransactions cashpickuptransactions) {
		this.cashpickuptransactions = cashpickuptransactions;
	}
    
    
    

}
