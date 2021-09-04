package com.coop.cashsends.dto;

public class PaymentModesDto {

	public Integer id;	
	public String CountryIsoCode;
	public Integer CityId;
	public String ModeName;
	public boolean status;
	public String RequiredBank;
	public String RequiredAccount;
	public String StateName;
	public String CountryName;
	public String CityName;
	public String StateId;
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
	
	
	
	public String getModeName() {
		return ModeName;
	}
	public void setModeName(String modeName) {
		ModeName = modeName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String getRequiredBank() {
		return RequiredBank;
	}
	public void setRequiredBank(String requiredBank) {
		RequiredBank = requiredBank;
	}
	public String getRequiredAccount() {
		return RequiredAccount;
	}
	public void setRequiredAccount(String requiredAccount) {
		RequiredAccount = requiredAccount;
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
	public String getStateId() {
		return StateId;
	}
	public void setStateId(String stateId) {
		StateId = stateId;
	}
	
	
}
