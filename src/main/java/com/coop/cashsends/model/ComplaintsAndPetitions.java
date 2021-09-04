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
import com.coop.cashsends.dto.ComplaintsAndPetitionsDto;

@Entity
@Table(name = "complaints_petitions")
@EntityListeners(AuditingEntityListener.class)
public class ComplaintsAndPetitions extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "complaint_name")
    private String ComplaintName;
	
	@Column(name = "status")
    private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplaintName() {
		return ComplaintName;
	}

	public void setComplaintName(String complaintName) {
		ComplaintName = complaintName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public ComplaintsAndPetitionsDto toComplaintsAndPetitionsDto() {
		ComplaintsAndPetitionsDto complaintsAndPetitionsDto = null;	
		complaintsAndPetitionsDto = new ComplaintsAndPetitionsDto();
		complaintsAndPetitionsDto.setComplaintName(this.ComplaintName);
		complaintsAndPetitionsDto.setId(this.id);
		complaintsAndPetitionsDto.setStatus(this.status);
		return complaintsAndPetitionsDto;
	}


}
