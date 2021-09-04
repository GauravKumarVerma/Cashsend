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
import com.coop.cashsends.dto.ComplaintsDto;

@Entity
@Table(name = "complaints")
@EntityListeners(AuditingEntityListener.class)
public class Complaints extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		

    @Column(name = "petition_type")
	private String petitiontype;
	
    @Column(name = "complaint_type")
	private String complainttype;	
	
    @Column(name = "status")
	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getPetitiontype() {
		return petitiontype;
	}

	public void setPetitiontype(String petitiontype) {
		this.petitiontype = petitiontype;
	}

	public String getComplainttype() {
		return complainttype;
	}

	public void setComplainttype(String complainttype) {
		this.complainttype = complainttype;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

    public ComplaintsDto toComplaintsDto() {
    	ComplaintsDto complaintsDto = null;
    	complaintsDto = new ComplaintsDto();
    	complaintsDto.setComplainttype(this.complainttype);
    	complaintsDto.setId(this.id);
    	complaintsDto.setPetitiontype(this.petitiontype);
    	complaintsDto.setStatus(this.status);
    	return complaintsDto;
    	
    	
    }
    
}
