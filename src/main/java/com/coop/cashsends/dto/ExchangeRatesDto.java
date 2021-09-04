package com.coop.cashsends.dto;

public class ExchangeRatesDto {
	
	public Integer id;	
	public String SourceCurrencyCode;
	public String RecieverCurrencyCode;
	public float Rate;
	public boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSourceCurrencyCode() {
		return SourceCurrencyCode;
	}
	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		SourceCurrencyCode = sourceCurrencyCode;
	}
	public String getRecieverCurrencyCode() {
		return RecieverCurrencyCode;
	}
	public void setRecieverCurrencyCode(String recieverCurrencyCode) {
		RecieverCurrencyCode = recieverCurrencyCode;
	}
	public float getRate() {
		return Rate;
	}
	public void setRate(float rate) {
		Rate = rate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
