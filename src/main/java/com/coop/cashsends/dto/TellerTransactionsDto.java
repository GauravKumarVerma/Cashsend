package com.coop.cashsends.dto;

import java.time.LocalDateTime;

public class TellerTransactionsDto {
	
	  private Integer id;
	  private String username;
	  private String description;
	  private Integer tellerid;
	  private String ipaddress;
	  private String activitystatus;
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
	
	public Integer getTellerid() {
		return tellerid;
	}
	public void setTellerid(Integer tellerid) {
		this.tellerid = tellerid;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
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
	
	  

}
