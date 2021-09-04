package com.coop.cashsends.dto;

public class CashpickupTransactionsDto {
	
	private Integer id;	
	private String tfpin;
	private String recieverfirstname;
	private String recieverlastname;
	private String recievermiddlename;
	private String recieverbankename;
	private String recieveraccountnumber;
	private String recieveraccounttype;
	private String recieveraddress;
	private String recievercountry;
	private String recieverstate;
	private String recievercity;
	private String sendername;
	private String sendermobile;
	private String senderaddress;
	private String senderemail;
	private CashpickupSummaryDto cashpickupSummary;
	private CashpickupInvoiceDto cashpickupInvoice;
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
	public CashpickupSummaryDto getCashpickupSummary() {
		return cashpickupSummary;
	}
	public void setCashpickupSummary(CashpickupSummaryDto cashpickupSummary) {
		this.cashpickupSummary = cashpickupSummary;
	}
	public CashpickupInvoiceDto getCashpickupInvoice() {
		return cashpickupInvoice;
	}
	public void setCashpickupInvoice(CashpickupInvoiceDto cashpickupInvoice) {
		this.cashpickupInvoice = cashpickupInvoice;
	}
	
	
	

}
