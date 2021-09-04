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
import com.coop.cashsends.dto.RecieverCurrencyDto;

@Entity
@Table(name = "reciever_currency")
@EntityListeners(AuditingEntityListener.class)
public class RecieverCurrency extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;	
	@Column(name = "city_id")
    private Integer CityId;	
	@Column(name = "state_id")
    private Integer StateId;
	@Column(name = "town_id")
    private String TownId;
	@Column(name = "payment_mode_id")
    private String PaymentModeId;
	@Column(name = "currency_iso_code")
    private String CurrencyIsoCode;
	@Column(name = "is_payment_currency")
    private String IsPaymentCurrency;
	
	@Column(name = "state_name")
    private String StateName;
	
	@Column(name = "country_name")
    private String CountryName;
	
	@Column(name = "city_name")
	private String CityName;
	
	@Column(name = "town_name")
	private String TownName;
	
	@Column(name = "status")
    private boolean status;
	
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
	public Integer getStateId() {
		return StateId;
	}
	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	public String getTownId() {
		return TownId;
	}
	public void setTownId(String townId) {
		TownId = townId;
	}
	public String getPaymentModeId() {
		return PaymentModeId;
	}
	public void setPaymentModeId(String paymentModeId) {
		PaymentModeId = paymentModeId;
	}
	public String getCurrencyIsoCode() {
		return CurrencyIsoCode;
	}
	public void setCurrencyIsoCode(String currencyIsoCode) {
		CurrencyIsoCode = currencyIsoCode;
	}
	public String isIsPaymentCurrency() {
		return IsPaymentCurrency;
	}
	public void setIsPaymentCurrency(String isPaymentCurrency) {
		IsPaymentCurrency = isPaymentCurrency;
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
	public String getTownName() {
		return TownName;
	}
	public void setTownName(String townName) {
		TownName = townName;
	}
	public String getIsPaymentCurrency() {
		return IsPaymentCurrency;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public RecieverCurrencyDto toRecieverCurrencyDto() {
	RecieverCurrencyDto recieverCurrencyDto = null;	
	recieverCurrencyDto = new RecieverCurrencyDto();
	recieverCurrencyDto.setCityId(this.CityId);
	recieverCurrencyDto.setCountryIsoCode(this.CountryIsoCode);
	recieverCurrencyDto.setCurrencyIsoCode(this.CurrencyIsoCode);
	recieverCurrencyDto.setId(this.id);
	recieverCurrencyDto.setIsPaymentCurrency(this.IsPaymentCurrency);
	recieverCurrencyDto.setPaymentModeId(this.PaymentModeId);
	recieverCurrencyDto.setStateId(this.StateId);
	recieverCurrencyDto.setTownId(this.TownId);
	recieverCurrencyDto.setStatus(this.status);
	recieverCurrencyDto.setCountryName(this.CountryName);
	recieverCurrencyDto.setCityName(this.CityName);
	recieverCurrencyDto.setStateName(this.StateName);
	recieverCurrencyDto.setTownName(this.TownName);
	return recieverCurrencyDto;
		
	}

}
