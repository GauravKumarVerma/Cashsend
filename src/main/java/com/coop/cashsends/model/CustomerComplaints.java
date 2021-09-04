package com.coop.cashsends.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.CustomerCommentsDto;
import com.coop.cashsends.dto.CustomerComplaintsDto;

@Entity
@Table(name = "customer_complaints")
@EntityListeners(AuditingEntityListener.class)
public class CustomerComplaints extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "petition_type")
    private String petitiontype;
	
	@Column(name = "tfpin")
    private String tfpin;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "transaction_type")
    private String transactiontype;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "customercomplaints", cascade =  CascadeType.ALL)
	 private List<CustomerComments> customercomments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPetitiontype() {
		return petitiontype;
	}

	public void setPetitiontype(String petitiontype) {
		this.petitiontype = petitiontype;
	}

	public String getTfpin() {
		return tfpin;
	}

	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	
	

  public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	
	
public List<CustomerComments> getCustomercomments() {
		return customercomments;
	}

	public void setCustomercomments(List<CustomerComments> customercomments) {
		this.customercomments = customercomments;
	}

public CustomerComplaintsDto toCustomerComplaintsDto() {
	  CustomerComplaintsDto customerComplaintsDto = null;
	  customerComplaintsDto = new CustomerComplaintsDto();
	  customerComplaintsDto.setDescription(this.description);
	  customerComplaintsDto.setTfpin(this.tfpin);
	  customerComplaintsDto.setPetitiontype(this.petitiontype);
	  customerComplaintsDto.setId(this.id);
	  customerComplaintsDto.setStatus(this.status);
	  customerComplaintsDto.setCreatedby(this.created_by);
	  customerComplaintsDto.setTransactiontype(this.transactiontype);
	  customerComplaintsDto.setCreateddate(this.updated_date);
	  List<CustomerComments> customerComments = this.customercomments;
	  List<CustomerCommentsDto> customerCommentsDtos = null;
	  customerCommentsDtos = new ArrayList<CustomerCommentsDto>();
	  for(CustomerComments stats:customerComments) {
		  CustomerCommentsDto custCommentsDtos = null;  
		  custCommentsDtos = new CustomerCommentsDto();
		  custCommentsDtos.setComments(stats.getComments());
		  custCommentsDtos.setId(stats.getId());
		  custCommentsDtos.setUpdatedate(stats.getUpdated_date());
		  custCommentsDtos.setNewstatus(stats.getSatus());
		  customerCommentsDtos.add(custCommentsDtos);
		  
	  }
	  customerComplaintsDto.setCustomercomments(customerCommentsDtos);
	  
	  return customerComplaintsDto;
	  
   }

}
