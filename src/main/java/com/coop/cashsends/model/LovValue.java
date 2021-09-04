package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.model.LovType;


@Entity
@Table(name = "lov_value")
@EntityListeners(AuditingEntityListener.class)
public class LovValue extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "value")
	private String value;
	@ManyToOne
	@JoinColumn(name="lov_type_id")
	private LovType lovtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public LovType getLovtype() {
		return lovtype;
	}
	public void setLovtype(LovType lovtype) {
		this.lovtype = lovtype;
	}
	
	
	

}
