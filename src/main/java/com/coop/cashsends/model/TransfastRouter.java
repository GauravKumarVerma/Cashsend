package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coop.cashsends.audit.Auditable;


@Entity
@Table(name = "transfast_routers")
public class TransfastRouter extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "source_type")
	private String sourcetype;
	
	@Column(name = "source_url")
	private String sourceurl;
	
	@Column(name = "request_type")
	private String requestype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getSourceurl() {
		return sourceurl;
	}

	public void setSourceurl(String sourceurl) {
		this.sourceurl = sourceurl;
	}

	public String getRequestype() {
		return requestype;
	}

	public void setRequestype(String requestype) {
		this.requestype = requestype;
	}
	
	

}
