package com.coop.cashsends.dto;

public class ComplaintStatusDto {
	
	private Integer id;
	private String currentstatus;	
	private String newstatus;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public String getNewstatus() {
		return newstatus;
	}
	public void setNewstatus(String newstatus) {
		this.newstatus = newstatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
