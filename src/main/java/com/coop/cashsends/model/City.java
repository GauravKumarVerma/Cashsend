package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.CityDto;


@Entity
@Table(name = "cities")
public class City extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "name")
    private String CityName;	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;
	@Column(name = "state_id")
    private String StateId;
	@Column(name = "status")
    private boolean status;
	
	@Column(name = "state_name")
    private String StateName;
	
	@Column(name = "country_name")
    private String CountryName;
	
	
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
	


	public boolean getStatus() {
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

	public CityDto toCityDto() {
		CityDto cityDto =null;
		cityDto = new CityDto();
		cityDto.setCountryIsoCode(this.CountryIsoCode);
		cityDto.setId(this.id);
		cityDto.setCityName(this.CityName);
		cityDto.setStateId(this.StateId);
		cityDto.setStatus(this.status);
		cityDto.setCountryName(this.CountryName);
		cityDto.setStateName(this.StateName);
		return cityDto;
		
	}
	

}
