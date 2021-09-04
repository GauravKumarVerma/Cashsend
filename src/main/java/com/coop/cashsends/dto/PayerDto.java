package com.coop.cashsends.dto;

public class PayerDto {
	
	public Integer id;
	public Integer PayerId;
	public String PayerName;
	public Integer CityId;
	public Integer StateId;
	public String CountryIsoCode;
	public String PaymentModeId;
	public String RecieverCurrencyIsoCode;
	public String SourceCurrencyIsoCode;
	public Integer TownId;
	public boolean status;
	
	public String StateName;
	public String CountryName;
	public String CityName;
	public String TownName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPayerId() {
		return PayerId;
	}
	public void setPayerId(Integer payerId) {
		PayerId = payerId;
	}
	public String getPayerName() {
		return PayerName;
	}
	public void setPayerName(String payerName) {
		PayerName = payerName;
	}
	public Integer getCityId() {
		return CityId;
	}
	public void setCityId(Integer cityId) {
		CityId = cityId;
	}
	public Integer getStateId() {
		return StateId;
	}
	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	public String getCountryIsoCode() {
		return CountryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
	}
	public String getPaymentModeId() {
		return PaymentModeId;
	}
	public void setPaymentModeId(String paymentModeId) {
		PaymentModeId = paymentModeId;
	}
	public String getRecieverCurrencyIsoCode() {
		return RecieverCurrencyIsoCode;
	}
	public void setRecieverCurrencyIsoCode(String recieverCurrencyIsoCode) {
		RecieverCurrencyIsoCode = recieverCurrencyIsoCode;
	}
	public String getSourceCurrencyIsoCode() {
		return SourceCurrencyIsoCode;
	}
	public void setSourceCurrencyIsoCode(String sourceCurrencyIsoCode) {
		SourceCurrencyIsoCode = sourceCurrencyIsoCode;
	}
	public Integer getTownId() {
		return TownId;
	}
	public void setTownId(Integer townId) {
		TownId = townId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getTownName() {
		return TownName;
	}
	public void setTownName(String townName) {
		TownName = townName;
	}
	
	


}
