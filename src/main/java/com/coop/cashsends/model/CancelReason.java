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
import com.coop.cashsends.dto.CancelReasonDto;


@Entity
@Table(name = "cancel_reasons")
@EntityListeners(AuditingEntityListener.class)
public class CancelReason extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "reason")
	private String ReasonName;	
	@Column(name = "status")
	private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getReasonName() {
		return ReasonName;
	}
	public void setReasonName(String reasonName) {
		ReasonName = reasonName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}	
	
 public CancelReasonDto toCancelReasonDto() {
	 CancelReasonDto cancelReasonDto = null;
	 cancelReasonDto = new CancelReasonDto();
	 cancelReasonDto.setId(this.id);
	 cancelReasonDto.setReasonName(this.ReasonName);
	 cancelReasonDto.setStatus(this.status);
	 return cancelReasonDto;
	 
 }
	
	

}
