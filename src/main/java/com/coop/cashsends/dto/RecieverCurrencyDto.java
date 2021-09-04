package com.coop.cashsends.dto;

public class RecieverCurrencyDto {

	public Integer id;	
	public String CountryIsoCode;
	public Integer CityId;	
	public Integer StateId;
	public String TownId;
	public String PaymentModeId;
	public String CurrencyIsoCode;
	public String IsPaymentCurrency;
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
	public String getCountryIsoCode() {
		return CountryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
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
	public String getTownId() {
		return TownId;
	}
	public void setTownId(String townId) {
		TownId = townId;
	}
	public String getPaymentModeId() {
		return PaymentModeId;
	}
	public void setPaymentModeId(String paymentModeId) {
		PaymentModeId = paymentModeId;
	}
	public String getCurrencyIsoCode() {
		return CurrencyIsoCode;
	}
	public void setCurrencyIsoCode(String currencyIsoCode) {
		CurrencyIsoCode = currencyIsoCode;
	}
	public String isIsPaymentCurrency() {
		return IsPaymentCurrency;
	}
	public void setIsPaymentCurrency(String isPaymentCurrency) {
		IsPaymentCurrency = isPaymentCurrency;
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
