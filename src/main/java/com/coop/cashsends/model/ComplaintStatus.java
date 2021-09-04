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
import com.coop.cashsends.dto.ComplaintStatusDto;

@Entity
@Table(name = "complaint_status")
@EntityListeners(AuditingEntityListener.class)
public class ComplaintStatus extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "current_status")
    private String currentstatus;	

	@Column(name = "new_status")
    private String newstatus;
	
	@Column(name = "description")
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
	
	public ComplaintStatusDto toComplaintStatusDto() {
		ComplaintStatusDto complaintStatus = null;
		complaintStatus = new ComplaintStatusDto();
		complaintStatus.setId(this.id);
		complaintStatus.setNewstatus(this.newstatus);
		complaintStatus.setCurrentstatus(this.currentstatus);
		complaintStatus.setDescription(this.description);
		return complaintStatus;
		
	}
	
}
