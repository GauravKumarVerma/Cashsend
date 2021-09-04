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
import com.coop.cashsends.dto.SenderTypesDto;

@Entity
@Table(name = "sender_types")
@EntityListeners(AuditingEntityListener.class)
public class SenderTypes extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
	@Column(name = "country_iso_code")
    private String CountryIsoCode;
	@Column(name = "name")
    private String SenderName;
	@Column(name = "compliance_country_required")
    private String ComplianceCountryRequired;
	@Column(name = "compliance_state_required")
    private String ComplianceStateRequired;
	@Column(name = "status")
    private boolean status;
	@Column(name = "CountryName")
    private String CountryName;
	
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
	
	
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getComplianceCountryRequired() {
		return ComplianceCountryRequired;
	}
	public void setComplianceCountryRequired(String complianceCountryRequired) {
		ComplianceCountryRequired = complianceCountryRequired;
	}
	
	
	
	public String getComplianceStateRequired() {
		return ComplianceStateRequired;
	}
	public void setComplianceStateRequired(String complianceStateRequired) {
		ComplianceStateRequired = complianceStateRequired;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public SenderTypesDto toSenderTypesDto() {
		
	  SenderTypesDto senderTypesDto = null;
	  senderTypesDto = new SenderTypesDto();
	  senderTypesDto.setComplianceCountryRequired(this.ComplianceCountryRequired);
	  senderTypesDto.setCountryIsoCode(this.CountryIsoCode);
	  senderTypesDto.setId(this.id);
	  senderTypesDto.setSenderName(this.SenderName);
	  senderTypesDto.setCountryName(this.CountryName);
	  senderTypesDto.setStatus(this.status);
	  senderTypesDto.setComplianceStateRequired(this.ComplianceStateRequired);
	  return senderTypesDto;
		
	}
	

}
