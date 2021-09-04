package com.coop.cashsends.audit;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedBy
    @Column(updatable = false)
    protected U created_by;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(updatable = false)
    protected Date created_date;

    @LastModifiedBy
    protected U updated_by;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date updated_date;

	public U getCreated_by() {
		return created_by;
	}

	public void setCreated_by(U created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public U getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(U updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

    
  
}
