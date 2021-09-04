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
import com.coop.cashsends.dto.PayerRemittanceDto;

@Entity
@Table(name = "payer_remittance")
@EntityListeners(AuditingEntityListener.class)
public class PayerRemittance extends Auditable<String> {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "remittance_name")
    private String RemittanceName;
	
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

	public String getRemittanceName() {
		return RemittanceName;
	}

	public void setRemittanceName(String remittanceName) {
		RemittanceName = remittanceName;
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
	
	public PayerRemittanceDto toPayerRemittanceDto() {
		PayerRemittanceDto payerRemittanceDto = null;
		payerRemittanceDto = new PayerRemittanceDto();
		payerRemittanceDto.setCountryIsoCode(this.CountryIsoCode);
		payerRemittanceDto.setCountryName(this.CountryName);
		payerRemittanceDto.setId(this.id);
		payerRemittanceDto.setRemittanceName(this.RemittanceName);
		payerRemittanceDto.setStatus(this.status);
		return payerRemittanceDto;
		
	}

}
