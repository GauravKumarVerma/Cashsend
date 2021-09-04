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


@Entity
@Table(name = "transaction_history")
@EntityListeners(AuditingEntityListener.class)
public class TransactionHistory extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "status_name")
    private String statusname;
	@Column(name = "status_id")
    private String statusid;
	@Column(name = "tfpin")
    private String tfpin;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}
	public String getTfpin() {
		return tfpin;
	}
	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	
	

}
