package com.coop.cashsends.dto;

public class TaxesDto {

	public Integer id;	
	public String countrycode;	
	public String taxtype;	
	public String taxname;
	public float taxvalue;
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
	public String getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
	public String getTaxname() {
		return taxname;
	}
	public void setTaxname(String taxname) {
		this.taxname = taxname;
	}
	public float getTaxvalue() {
		return taxvalue;
	}
	public void setTaxvalue(float taxvalue) {
		this.taxvalue = taxvalue;
	}
	
	
}
