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
import com.coop.cashsends.dto.ExchangeRatesDto;

@Entity
@Table(name = "exchange_rates")
@EntityListeners(AuditingEntityListener.class)
public class ExchangeRates extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
	
	@Column(name = "source_currency_code")
	private String SourceCurrencyCode;
	
	@Column(name = "reciever_currency_code")
	private String RecieverCurrencyCode;
	
	@Column(name = "rate")
	private float Rate;
	
	@Column(name = "status")
	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceCurrencyCode() {
		return SourceCurrencyCode;
	}

	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		SourceCurrencyCode = sourceCurrencyCode;
	}

	public String getRecieverCurrencyCode() {
		return RecieverCurrencyCode;
	}

	public void setRecieverCurrencyCode(String recieverCurrencyCode) {
		RecieverCurrencyCode = recieverCurrencyCode;
	}

	public float getRate() {
		return Rate;
	}

	public void setRate(float rate) {
		Rate = rate;
	}
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ExchangeRatesDto toExchangeRatesDto() {
	
		ExchangeRatesDto exchangeRatesDto = null;	
		exchangeRatesDto = new ExchangeRatesDto();
		exchangeRatesDto.setId(this.id);
		exchangeRatesDto.setRate(this.Rate);
		exchangeRatesDto.setRecieverCurrencyCode(this.RecieverCurrencyCode);
		exchangeRatesDto.setSourceCurrencyCode(this.SourceCurrencyCode);
		exchangeRatesDto.setStatus(this.status);
		return exchangeRatesDto;
		
		
	}

}
