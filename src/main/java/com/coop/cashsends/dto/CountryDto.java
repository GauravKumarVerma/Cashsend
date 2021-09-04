package com.coop.cashsends.dto;

public class CountryDto {
	
	public Integer id;
	public String Name;
	public String IsoCode;
	public String HasTown;
	public boolean status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIsoCode() {
		return IsoCode;
	}
	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}
	public String getHasTown() {
		return HasTown;
	}
	public void setHasTown(String hasTown) {
		HasTown = hasTown;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	

}
