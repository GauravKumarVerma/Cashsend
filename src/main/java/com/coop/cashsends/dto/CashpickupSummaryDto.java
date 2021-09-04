package com.coop.cashsends.dto;

public class CashpickupSummaryDto {
	
	 private Integer id;	
	 private String tfpin;
	 private String origin;
	 private String destination;
	 private float amountrecieved;
	 private float servicefees;
	 private float tax;
	 private float total;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getAmountrecieved() {
		return amountrecieved;
	}
	public void setAmountrecieved(float amountrecieved) {
		this.amountrecieved = amountrecieved;
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
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	 
	 

}
