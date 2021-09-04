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
import com.coop.cashsends.dto.CountryDto;

@Entity
@Table(name = "countries")
@EntityListeners(AuditingEntityListener.class)
public class Country extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "name")
    private String Name;
	@Column(name = "iso_code")
    private String IsoCode;	
	@Column(name = "has_town")
    private String HasTown;
	@Column(name = "status")
    private boolean status;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
   public void setName(String name) {
		Name = name;
	}

	public String getIsoCode() {
		return IsoCode;
	}


	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

	public String getHasTown() {
		return HasTown;
	}

	public void setHasTown(String hasTown) {
		HasTown = hasTown;
	}
   public boolean isStatus() {
		return status;
	}
   public void setStatus(boolean status) {
		this.status = status;
	}

	public CountryDto toCountryDto() {
	CountryDto 	countryDto =null;
	countryDto = new CountryDto();
	countryDto.setHasTown(this.HasTown);
	countryDto.setId(this.id);	
	countryDto.setIsoCode(this.IsoCode);
	countryDto.setName(this.Name);
	countryDto.setStatus(this.status);
	return countryDto;
	}
	
	

}
