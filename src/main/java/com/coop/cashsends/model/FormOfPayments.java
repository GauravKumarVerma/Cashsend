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
import com.coop.cashsends.dto.FormOfPaymentsDto;

@Entity
@Table(name = "form_of_payments")
@EntityListeners(AuditingEntityListener.class)
public class FormOfPayments extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "payment_name")
    private String PaymentName;	
	
	@Column(name = "status")
    private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentName() {
		return PaymentName;
	}

	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public FormOfPaymentsDto toFormOfPaymentsDto() {
		FormOfPaymentsDto formOfPaymentsDto = null;	
		formOfPaymentsDto = new FormOfPaymentsDto();
		formOfPaymentsDto.setId(this.id);
		formOfPaymentsDto.setPaymentName(this.PaymentName);
		formOfPaymentsDto.setStatus(this.status);
		return formOfPaymentsDto;
	}
	

}
