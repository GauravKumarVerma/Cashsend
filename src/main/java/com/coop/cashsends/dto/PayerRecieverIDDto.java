package com.coop.cashsends.dto;

public class PayerRecieverIDDto {
	
	public Integer id;
	public String IdentifierName;
	public String CountryIsoCode;	
	public String CountryName;
	public boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentifierName() {
		return IdentifierName;
	}
	public void setIdentifierName(String identifierName) {
		IdentifierName = identifierName;
	}
	public String getCountryIsoCode() {
		return CountryIsoCode;
	}
	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
