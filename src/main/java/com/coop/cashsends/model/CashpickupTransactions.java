package com.coop.cashsends.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;

@Entity
@Table(name = "cashpickup_transactions")
@EntityListeners(AuditingEntityListener.class)
public class CashpickupTransactions extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
    @Column(name = "tfpin")
    private String tfpin;
    
    @Column(name = "reciever_first_name")
    private String recieverfirstname;
    @Column(name = "reciever_last_name")
    private String recieverlastname;
    @Column(name = "reciever_middle_name")
    private String recievermiddlename;
    @Column(name = "reciever_bank_name")
    private String recieverbankename;
    @Column(name = "reciever_account_number")
    private String recieveraccountnumber;
    @Column(name = "reciever_account_type")
    private String recieveraccounttype;
    @Column(name = "reciever_address")
    private String recieveraddress;
    @Column(name = "reciever_country")
    private String recievercountry;
    @Column(name = "reciever_state")
    private String recieverstate;
    @Column(name = "reciever_city")
    private String recievercity;
    @Column(name = "sender_name")
    private String sendername;
    @Column(name = "sender_mobile")
    private String sendermobile;
    @Column(name = "sender_address")
    private String senderaddress;
    @Column(name = "sender_email")
    private String senderemail;
    
    @OneToOne(mappedBy = "cashpickuptransactions", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
     private CashpickupSummary cashpickupSummary;
    
    @OneToOne(mappedBy = "cashpickuptransactions", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
     private CashpickupInvoice cashpickupInvoice;
    
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
	public String getRecieverfirstname() {
		return recieverfirstname;
	}
	public void setRecieverfirstname(String recieverfirstname) {
		this.recieverfirstname = recieverfirstname;
	}
	public String getRecieverlastname() {
		return recieverlastname;
	}
	public void setRecieverlastname(String recieverlastname) {
		this.recieverlastname = recieverlastname;
	}
	public String getRecievermiddlename() {
		return recievermiddlename;
	}
	public void setRecievermiddlename(String recievermiddlename) {
		this.recievermiddlename = recievermiddlename;
	}
	public String getRecieverbankename() {
		return recieverbankename;
	}
	public void setRecieverbankename(String recieverbankename) {
		this.recieverbankename = recieverbankename;
	}
	public String getRecieveraccountnumber() {
		return recieveraccountnumber;
	}
	public void setRecieveraccountnumber(String recieveraccountnumber) {
		this.recieveraccountnumber = recieveraccountnumber;
	}
	public String getRecieveraccounttype() {
		return recieveraccounttype;
	}
	public void setRecieveraccounttype(String recieveraccounttype) {
		this.recieveraccounttype = recieveraccounttype;
	}
	public String getRecieveraddress() {
		return recieveraddress;
	}
	public void setRecieveraddress(String recieveraddress) {
		this.recieveraddress = recieveraddress;
	}
	public String getRecievercountry() {
		return recievercountry;
	}
	public void setRecievercountry(String recievercountry) {
		this.recievercountry = recievercountry;
	}
	public String getRecieverstate() {
		return recieverstate;
	}
	public void setRecieverstate(String recieverstate) {
		this.recieverstate = recieverstate;
	}
	public String getRecievercity() {
		return recievercity;
	}
	public void setRecievercity(String recievercity) {
		this.recievercity = recievercity;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getSendermobile() {
		return sendermobile;
	}
	public void setSendermobile(String sendermobile) {
		this.sendermobile = sendermobile;
	}
	public String getSenderaddress() {
		return senderaddress;
	}
	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}
	public String getSenderemail() {
		return senderemail;
	}
	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}
	public CashpickupSummary getCashpickupSummary() {
		return cashpickupSummary;
	}
	public void setCashpickupSummary(CashpickupSummary cashpickupSummary) {
		this.cashpickupSummary = cashpickupSummary;
	}
    
    
    
    
    

}
