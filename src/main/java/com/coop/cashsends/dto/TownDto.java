package com.coop.cashsends.dto;

public class TownDto {

	 public Integer id;
	 public String TownName;
	 public Integer CityId;
	 public String StateId;
	 public String CountryIsoCode;
	 public boolean status;
	 public String StateName;
	 public String CountryName;
	 public String CityName;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTownName() {
		return TownName;
	}
	public void setTownName(String townName) {
		TownName = townName;
	}
	public Integer getCityId() {
		return CityId;
	}
	public void setCityId(Integer cityId) {
		CityId = cityId;
	}
	
	
	public String getStateId() {
		return StateId;
	}
	public void setStateId(String stateId) {
		StateId = stateId;
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
	 
	 
	
	

}
