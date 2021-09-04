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
import com.coop.cashsends.dto.CountryManagerDto;


@Entity
@Table(name = "country_manager")
@EntityListeners(AuditingEntityListener.class)
public class CountryManager extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "user_id")
	private Integer userid;
	@Column(name = "address")
	private String address;
	@Column(name = "country_id")
	private String countryid;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile_number")
	private long mobilenumber;
	
	@Column(name = "is_active")
	private boolean isactive;
	
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
	public CountryManagerDto tocCountryManagerDto() {
		CountryManagerDto countryManagerDto =null;
		countryManagerDto = new CountryManagerDto();
		countryManagerDto.setId(this.id);
		countryManagerDto.setCountryid(this.countryid);
		countryManagerDto.setEmail(this.email);
		countryManagerDto.setFirstname(this.firstname);
		countryManagerDto.setAddress(this.address);
		countryManagerDto.setIsactive(this.isactive);
		countryManagerDto.setLastname(this.lastname);
		countryManagerDto.setMobilenumber(this.mobilenumber);
		countryManagerDto.setUserid(this.userid);
		return countryManagerDto;
		
	}

}
