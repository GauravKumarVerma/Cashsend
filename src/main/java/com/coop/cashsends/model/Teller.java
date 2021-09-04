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
import com.coop.cashsends.dto.TellerDto;

@Entity
@Table(name = "tellers")
@EntityListeners(AuditingEntityListener.class)
public class Teller extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "user_id")
	private Integer userid;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "location_id")
	private Integer locationid;
	@Column(name = "mobile_number")
	private String mobilenumber;
	@Column(name = "is_active")
	private boolean isactive;
	@Column(name = "country_id")
	private String countryid;
	@Column(name = "partner_id")
	private Integer partnerid;
	
	
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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
	public Integer getLocationid() {
		return locationid;
	}
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}
	
	
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	public Integer getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public TellerDto toTellerDto() {
		TellerDto tellerDto = null;
		tellerDto  = new TellerDto();
		tellerDto.setFirstname(this.firstname);
		tellerDto.setId(this.id);
		tellerDto.setLastname(this.lastname);
		tellerDto.setLocationid(this.locationid);
		tellerDto.setMobilenumber(this.mobilenumber);
		tellerDto.setUserid(this.userid);
		tellerDto.setIsactive(this.isactive);
		tellerDto.setCountryid(this.countryid);
		return tellerDto;
		
	}
	

}
