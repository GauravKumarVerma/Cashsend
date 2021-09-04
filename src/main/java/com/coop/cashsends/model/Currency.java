package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coop.cashsends.dto.CurrencyDto;


@Entity
@Table(name = "currency")
public class Currency {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "currency_name")
	private String currencyname;
	@Column(name = "currency_code")
	private String currencycode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	
	public CurrencyDto toCurrencyDto() {
		CurrencyDto currencyDto =null;	
		currencyDto = new CurrencyDto();
		currencyDto.setCurrencycode(this.currencycode);
		currencyDto.setCurrencyname(this.currencyname);
		currencyDto.setId(this.id);
		return currencyDto;
		
	}
	
}
