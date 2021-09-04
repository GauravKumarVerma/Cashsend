package com.coop.cashsends.dto;

import java.util.Date;

public class CustomerCommentsDto {
	
	public Integer id;	
	public String Comments;
	public String newstatus;
	public Date updatedate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public String getNewstatus() {
		return newstatus;
	}
	public void setNewstatus(String newstatus) {
		this.newstatus = newstatus;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
	

}
