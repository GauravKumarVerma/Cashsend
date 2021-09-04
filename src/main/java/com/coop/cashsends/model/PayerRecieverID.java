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
import com.coop.cashsends.dto.PayerRecieverIDDto;

@Entity
@Table(name = "payer_reciever_id")
@EntityListeners(AuditingEntityListener.class)
public class PayerRecieverID  extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "identifier_name")
    private String IdentifierName;
	
	@Column(name = "country_iso_code")
    private String CountryIsoCode;	
	
	@Column(name = "country_name")
    private String CountryName;	
	
	@Column(name = "status")
    private boolean status;

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
	
	
	public PayerRecieverIDDto toPayerRecieverIDDto() {
		PayerRecieverIDDto payerRecieverIDDto = null;
		payerRecieverIDDto = new PayerRecieverIDDto();
		payerRecieverIDDto.setCountryIsoCode(this.CountryIsoCode);
		payerRecieverIDDto.setCountryName(this.CountryName);
		payerRecieverIDDto.setId(this.id);
		payerRecieverIDDto.setIdentifierName(this.IdentifierName);
		payerRecieverIDDto.setStatus(this.status);
		return payerRecieverIDDto;
		
	}
	

}
