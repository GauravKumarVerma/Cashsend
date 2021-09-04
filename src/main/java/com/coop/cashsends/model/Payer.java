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
import com.coop.cashsends.dto.PayerDto;

@Entity
@Table(name = "payers")
@EntityListeners(AuditingEntityListener.class)
public class Payer extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "payer_id")
    private Integer PayerId;
	
	@Column(name = "payer_name")
    private String PayerName;
	
	@Column(name = "city_id")
    private Integer CityId;
	
	@Column(name = "state_id")
    private Integer StateId;
	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;
	
	@Column(name = "payment_mode_id")
    private String PaymentModeId;
	
	@Column(name = "reciever_currency_iso_code")
    private String RecieverCurrencyIsoCode;
	
	@Column(name = "source_currency_iso_code")
    private String SourceCurrencyIsoCode;
	
	@Column(name = "town_id")
    private Integer TownId;
	
	@Column(name = "status")
    private boolean status;
	
	@Column(name = "state_name")
    private String StateName;
	
	@Column(name = "country_name")
    private String CountryName;
	
	@Column(name = "city_name")
	private String CityName;
	
	@Column(name = "town_name")
	private String TownName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayerId() {
		return PayerId;
	}

	public void setPayerId(Integer payerId) {
		PayerId = payerId;
	}

	public String getPayerName() {
		return PayerName;
	}

	public void setPayerName(String payerName) {
		PayerName = payerName;
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

	public String getCountryIsoCode() {
		return CountryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		CountryIsoCode = countryIsoCode;
	}

	public String getPaymentModeId() {
		return PaymentModeId;
	}

	public void setPaymentModeId(String paymentModeId) {
		PaymentModeId = paymentModeId;
	}

	public String getRecieverCurrencyIsoCode() {
		return RecieverCurrencyIsoCode;
	}

	public void setRecieverCurrencyIsoCode(String recieverCurrencyIsoCode) {
		RecieverCurrencyIsoCode = recieverCurrencyIsoCode;
	}

	public String getSourceCurrencyIsoCode() {
		return SourceCurrencyIsoCode;
	}

	public void setSourceCurrencyIsoCode(String sourceCurrencyIsoCode) {
		SourceCurrencyIsoCode = sourceCurrencyIsoCode;
	}

	public Integer getTownId() {
		return TownId;
	}

	public void setTownId(Integer townId) {
		TownId = townId;
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

	public String getTownName() {
		return TownName;
	}

	public void setTownName(String townName) {
		TownName = townName;
	}

	public PayerDto toPayerDto() {
		PayerDto payerDto = null;
		payerDto = new PayerDto();
		payerDto.setCityId(this.CityId);
		payerDto.setCountryIsoCode(this.CountryIsoCode);
		payerDto.setId(this.id);
		payerDto.setPayerId(this.PayerId);
		payerDto.setPayerName(this.PayerName);
		payerDto.setPaymentModeId(this.PaymentModeId);
		payerDto.setRecieverCurrencyIsoCode(this.RecieverCurrencyIsoCode);
		payerDto.setSourceCurrencyIsoCode(this.SourceCurrencyIsoCode);
		payerDto.setStateId(this.StateId);
		payerDto.setStatus(this.status);
		payerDto.setTownId(this.TownId);
		payerDto.setCountryName(this.CountryName);
		payerDto.setCityName(this.CityName);
		payerDto.setStateName(this.StateName);
		payerDto.setTownName(this.TownName);
		
		return payerDto;
		 
	 }
		

}
