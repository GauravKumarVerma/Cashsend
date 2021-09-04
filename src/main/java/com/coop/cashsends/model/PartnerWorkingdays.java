package com.coop.cashsends.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;

@Entity
@Table(name = "partner_working_days")
@EntityListeners(AuditingEntityListener.class)
public class PartnerWorkingdays extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer id;
	@Column(name = "work_days")
	private String workdays;
	
	  @ManyToOne(fetch = FetchType.EAGER,cascade =  CascadeType.ALL)
	    @JoinColumn(name="partner_id")
	    private Partner partner;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkdays() {
		return workdays;
	}

	public void setWorkdays(String workdays) {
		this.workdays = workdays;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	  
	  
	

}
