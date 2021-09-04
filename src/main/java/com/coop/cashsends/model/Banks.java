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
import com.coop.cashsends.dto.BanksDto;

@Entity
@Table(name = "banks")
@EntityListeners(AuditingEntityListener.class)
public class Banks extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "bank_id")
    private String BankId;
	@Column(name = "name")
    private String BankName;
	@Column(name = "country_iso_code")
    private String CountryIsoCode;
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
	public String getBankId() {
		return BankId;
	}
	public void setBankId(String bankId) {
		BankId = bankId;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
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
	
	
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public BanksDto toBanksDto() {
	BanksDto banksDto = null;	
	banksDto = new BanksDto();
	banksDto.setBankId(this.BankId);
	banksDto.setBankName(this.BankName);
	banksDto.setCountryIsoCode(this.CountryIsoCode);
	banksDto.setId(this.id);
	banksDto.setStatus(this.status);
	banksDto.setCountryName(this.CountryName);
	return banksDto;
		
	}

}
