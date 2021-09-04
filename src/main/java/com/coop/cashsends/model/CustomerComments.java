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
@Table(name = "customer_comments")
@EntityListeners(AuditingEntityListener.class)
public class CustomerComments extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "comments")
    private String Comments;
	
	@Column(name = "status")
    private String satus;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade =  CascadeType.ALL)
	@JoinColumn(name="complaint_id")
	private CustomerComplaints customercomplaints;

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

	public CustomerComplaints getCustomercomplaints() {
		return customercomplaints;
	}

	public void setCustomercomplaints(CustomerComplaints customercomplaints) {
		this.customercomplaints = customercomplaints;
	}

	public String getSatus() {
		return satus;
	}

	public void setSatus(String satus) {
		this.satus = satus;
	}


	
	
}
