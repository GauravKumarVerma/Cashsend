package com.coop.cashsends.dto;

public class SenderTypesDto {
	
	public Integer id;	
	public String CountryIsoCode;
	public String SenderName;
	public String ComplianceCountryRequired;
	public boolean status;
    public String CountryName;
    public String ComplianceStateRequired;
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
	
	
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getComplianceCountryRequired() {
		return ComplianceCountryRequired;
	}
	public void setComplianceCountryRequired(String complianceCountryRequired) {
		ComplianceCountryRequired = complianceCountryRequired;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getComplianceStateRequired() {
		return ComplianceStateRequired;
	}
	public void setComplianceStateRequired(String complianceStateRequired) {
		ComplianceStateRequired = complianceStateRequired;
	}
	
    
    

}
