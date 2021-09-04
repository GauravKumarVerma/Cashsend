package com.coop.cashsends.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.TellerTransactionsDto;

@Entity
@Table(name = "teller_transactions")
@EntityListeners(AuditingEntityListener.class)
public class TellerTransactions extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "teller_name")
	private String username;
	@Column(name = "description")
	private String description;
	@Column(name = "teller_id")
	private Integer tellerid;
	@Column(name = "ip_address")
	private String ipaddress;
	
	@Column(name = "activity_status")
	private String activitystatus;
	@Column(name = "activity_date")
	private LocalDateTime activitydate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public Integer getTellerid() {
		return tellerid;
	}
	public void setTellerid(Integer tellerid) {
		this.tellerid = tellerid;
	}
	
	
	
	public String getActivitystatus() {
		return activitystatus;
	}
	public void setActivitystatus(String activitystatus) {
		this.activitystatus = activitystatus;
	}
	public LocalDateTime getActivitydate() {
		return activitydate;
	}
	public void setActivitydate(LocalDateTime activitydate) {
		this.activitydate = activitydate;
	}
	public TellerTransactionsDto toTellerTransactionsDto() {
		TellerTransactionsDto tellerTransactionsDto =null;
		tellerTransactionsDto = new TellerTransactionsDto();
		tellerTransactionsDto.setDescription(this.description);
		tellerTransactionsDto.setId(this.id);
		tellerTransactionsDto.setIpaddress(this.ipaddress);
		tellerTransactionsDto.setUsername(this.username);
		tellerTransactionsDto.setActivitydate(this.activitydate);
		tellerTransactionsDto.setActivitystatus(this.activitystatus);
		return tellerTransactionsDto;
	}

}
