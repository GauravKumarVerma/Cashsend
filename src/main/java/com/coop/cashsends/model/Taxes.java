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
import com.coop.cashsends.dto.TaxesDto;

@Entity
@Table(name = "taxes")
@EntityListeners(AuditingEntityListener.class)
public class Taxes extends Auditable<String>  {
	

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "country_code")
	private String countrycode;	
	@Column(name = "tax_name")
	private String taxname;	
	@Column(name = "tax_type")
	private String taxtype;	
	@Column(name = "tax_value")
	private float taxvalue;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getTaxname() {
		return taxname;
	}
	public void setTaxname(String taxname) {
		this.taxname = taxname;
	}
	public String getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
	public float getTaxvalue() {
		return taxvalue;
	}
	public void setTaxvalue(float taxvalue) {
		this.taxvalue = taxvalue;
	}	
	
	public TaxesDto totTaxesDto() {
		TaxesDto taxesDto =null;
		taxesDto = new TaxesDto();
		taxesDto.setCountrycode(this.countrycode);
		taxesDto.setId(this.id);
		taxesDto.setTaxname(this.taxname);
		taxesDto.setTaxtype(this.taxtype);
		taxesDto.setTaxvalue(this.taxvalue);
		
		return taxesDto;
		
	}

}
