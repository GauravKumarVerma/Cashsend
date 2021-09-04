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
import com.coop.cashsends.dto.StateDto;


@Entity
@Table(name = "states")
@EntityListeners(AuditingEntityListener.class)
public class State extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
	@Column(name = "name")
    private String StateName;	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;	
	@Column(name = "iso_code")
    private String StateIsoCode;
	@Column(name = "status")
    private boolean status;
	
	@Column(name = "country_name")
    private String CountryName;
	
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

	
	

	public String getStateIsoCode() {
		return StateIsoCode;
	}

	public void setStateIsoCode(String stateIsoCode) {
		StateIsoCode = stateIsoCode;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public StateDto toStateDto() {
	 StateDto stateDto =null;
	 stateDto = new StateDto();
	 stateDto.setStateName(this.StateName);
	 stateDto.setCountryIsoCode(this.CountryIsoCode);
	 stateDto.setId(this.id);
	 stateDto.setStatus(this.status);
	 stateDto.setStateIsoCode(this.StateIsoCode);
	 stateDto.setCountryName(this.CountryName);
	 return stateDto;
	}
	
	
}
