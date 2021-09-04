package com.coop.cashsends.dto;

public class FormOfPaymentsDto {
	
	public Integer id;
	public String PaymentName;	
	public boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaymentName() {
		return PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	} 
	
	

}
