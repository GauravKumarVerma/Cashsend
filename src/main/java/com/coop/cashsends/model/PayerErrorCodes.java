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
import com.coop.cashsends.dto.PayerErrorCodesDto;

@Entity
@Table(name = "error_codes")
@EntityListeners(AuditingEntityListener.class)
public class PayerErrorCodes extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "error_codes")
    private String ErrorCodes;
	
	@Column(name = "status")
    private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getErrorCodes() {
		return ErrorCodes;
	}

	public void setErrorCodes(String errorCodes) {
		ErrorCodes = errorCodes;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public PayerErrorCodesDto toPayerErrorCodesDto() {
		PayerErrorCodesDto payerErrorCodesDto = null;
		payerErrorCodesDto = new PayerErrorCodesDto();
		payerErrorCodesDto.setErrorCodes(this.ErrorCodes);
		payerErrorCodesDto.setId(this.id);
		payerErrorCodesDto.setStatus(this.status);
		return payerErrorCodesDto;
		
	}

}
