package com.coop.cashsends.dto;

public class StateDto {

	public Integer id;	
	public String StateName;
	public String CountryIsoCode;
	public String StateIsoCode;
	public boolean status;
	public String CountryName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public String getCountryIsoCode() {
		return CountryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStateIsoCode() {
		return StateIsoCode;
	}
	public void setStateIsoCode(String stateIsoCode) {
		StateIsoCode = stateIsoCode;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	
	
	
	
	

}
