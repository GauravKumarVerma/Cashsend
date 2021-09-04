package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coop.cashsends.audit.Auditable;


@Entity
@Table(name = "user_country_keys")
public class UserCountrykeys extends Auditable<String>{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "user_id")
    private Integer userid;	
	@Column(name = "country_id")
    private String countryid;	
	@Column(name = "country_token_key")
    private String countrytokenkey;	
	@Column(name = "branch_id")
    private String branchid;
	@Column(name = "transaction_type")
    private String transactiontype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public String getCountrytokenkey() {
		return countrytokenkey;
	}
	public void setCountrytokenkey(String countrytokenkey) {
		this.countrytokenkey = countrytokenkey;
	}
	public String getBranchid() {
		return branchid;
	}
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	
	

}
