package com.coop.cashsends.dto;

public class CityDto {
	public Integer id;		
	public String CityName;
	public String CountryIsoCode;
	public String StateId;
	public boolean status;
	public String StateName;
	public String CountryName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getCountryIsoCode() {
		return CountryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
	}
	public String getStateId() {
		return StateId;
	}
	public void setStateId(String stateId) {
		StateId = stateId;
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
	
	
	
	  
}
