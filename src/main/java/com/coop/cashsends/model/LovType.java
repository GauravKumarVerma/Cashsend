package com.coop.cashsends.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.model.LovValue;

@Entity
@Table(name = "lov_type")
@EntityListeners(AuditingEntityListener.class)
public class LovType extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "lovtype")
    private List<LovValue> lovValues;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LovValue> getLovValues() {
		return lovValues;
	}

	public void setLovValues(List<LovValue> lovValues) {
		this.lovValues = lovValues;
	}
	
	
	

}
