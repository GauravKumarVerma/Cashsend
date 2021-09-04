package com.coop.cashsends.dto;

public class CoopRecieveMoneyTransInfoDto {
	
	 public Integer id;
	 public float amount;
	 public float servicefees;
	 public float tax;
	 public float totalamount;
	 public float sentamount;
	 public float exchangerate;
	 public String bankname;
	 public String accountnumber;
	 public String accounttype;
	 public String sendercurrencycode;
	 public String recievercurrencycode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getServicefees() {
		return servicefees;
	}
	public void setServicefees(float servicefees) {
		this.servicefees = servicefees;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public float getSentamount() {
		return sentamount;
	}
	public void setSentamount(float sentamount) {
		this.sentamount = sentamount;
	}
	public float getExchangerate() {
		return exchangerate;
	}
	public void setExchangerate(float exchangerate) {
		this.exchangerate = exchangerate;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getSendercurrencycode() {
		return sendercurrencycode;
	}
	public void setSendercurrencycode(String sendercurrencycode) {
		this.sendercurrencycode = sendercurrencycode;
	}
	public String getRecievercurrencycode() {
		return recievercurrencycode;
	}
	public void setRecievercurrencycode(String recievercurrencycode) {
		this.recievercurrencycode = recievercurrencycode;
	}
	 
	 
	 
	 

}
