package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.TownDto;


@Entity
@Table(name = "towns")
@EntityListeners(AuditingEntityListener.class)
public class Town extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "name")
    private String TownName;
	@Column(name = "city_id")
    private Integer CityId;
	@Column(name = "state_id")
    private String StateId;
	@Column(name = "country_iso_code")
    private String CountryIsoCode;
	@Column(name = "status")
    private boolean status;
	
	@Column(name = "state_name")
    private String StateName;
	
	@Column(name = "country_name")
    private String CountryName;
	
	@Column(name = "city_name")
    private String CityName;
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
	public TownDto toTownDto() {
		TownDto townDto =null;	
		townDto =new TownDto();
		townDto.setCityId(this.CityId);
        townDto.setCountryIsoCode(this.CountryIsoCode);
        townDto.setStateId(this.StateId);
        townDto.setStatus(this.status);
        townDto.setTownName(this.TownName);
        townDto.setCityName(this.CityName);
        townDto.setCountryName(this.CountryName);
        townDto.setStateName(this.StateName);
        townDto.setId(this.id);
		return townDto;
		
		
	}
	

}
