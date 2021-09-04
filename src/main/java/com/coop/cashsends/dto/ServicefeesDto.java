package com.coop.cashsends.dto;

public class ServicefeesDto {

	public Integer id;	
	public String partnertype;	
	public String servicetype;
	public String transactiontype;
	public String paymentmode;
	public String sendercountry;
	public String recievercountry;
	public float startrange;
	public float flatrate;
	public float endrange;
	public float percentagevalue;
	public String priority;
	public String description;
	public String currencycode;
	public float amount;
	
	
	
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPartnertype() {
		return partnertype;
	}
	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getSendercountry() {
		return sendercountry;
	}
	public void setSendercountry(String sendercountry) {
		this.sendercountry = sendercountry;
	}
	public String getRecievercountry() {
		return recievercountry;
	}
	public void setRecievercountry(String recievercountry) {
		this.recievercountry = recievercountry;
	}
	public float getStartrange() {
		return startrange;
	}
	public void setStartrange(float startrange) {
		this.startrange = startrange;
	}
	public float getFlatrate() {
		return flatrate;
	}
	public void setFlatrate(float flatrate) {
		this.flatrate = flatrate;
	}
	public float getEndrange() {
		return endrange;
	}
	public void setEndrange(float endrange) {
		this.endrange = endrange;
	}
	public float getPercentagevalue() {
		return percentagevalue;
	}
	public void setPercentagevalue(float percentagevalue) {
		this.percentagevalue = percentagevalue;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
