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
import com.coop.cashsends.dto.PaymentModesDto;

@Entity
@Table(name = "payment_modes")
@EntityListeners(AuditingEntityListener.class)
public class PaymentModes extends Auditable<String> {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;	
	
	@Column(name = "city_id")
    private Integer CityId;
	
	@Column(name = "name")
    private String ModeName;
	
	@Column(name = "status")
    private boolean status;
	@Column(name = "required_bank")
    private String RequiredBank;
	
	@Column(name = "required_account")
    private String RequiredAccount;
	
	@Column(name = "state_id")
    private String StateId;
	
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
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
   public String getModeName() {
		return ModeName;
	}
	public void setModeName(String modeName) {
		ModeName = modeName;
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
public String getStateId() {
		return StateId;
	}
	public void setStateId(String stateId) {
		StateId = stateId;
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
public PaymentModesDto toPaymentModesDto() {
	   PaymentModesDto paymentModesDto =null; 
	   paymentModesDto = new PaymentModesDto();
	   paymentModesDto.setCityId(this.CityId);
	   paymentModesDto.setCountryIsoCode(this.CountryIsoCode);
	   paymentModesDto.setId(this.id);
	   paymentModesDto.setModeName(this.ModeName);
	   paymentModesDto.setRequiredAccount(this.RequiredAccount);
	   paymentModesDto.setRequiredBank(this.RequiredBank);
	   paymentModesDto.setStatus(this.status);
	   paymentModesDto.setCityName(this.CityName);
	   paymentModesDto.setCountryName(this.CountryName);
	   paymentModesDto.setStateName(this.StateName);
	   paymentModesDto.setStateId(this.StateId);
	   return paymentModesDto;
    }
	

}
