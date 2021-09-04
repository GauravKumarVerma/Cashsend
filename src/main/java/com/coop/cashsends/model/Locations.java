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
import com.coop.cashsends.dto.LocationDto;

@Entity
@Table(name = "locations")
@EntityListeners(AuditingEntityListener.class)
public class Locations extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "address")
	private String address;
	@Column(name = "latitude")
	private float latitude;
	@Column(name = "longitude")
	private float longitude;
	@Column(name = "country_id")
	private String countryid;
	@Column(name = "city_id")
	private Integer cityid;
	@Column(name = "state_id")
	private String stateid;
	@Column(name = "partner_id")
	private Integer partnerid;
	
	@Column(name = "location_name")
	private String locationame;
	@Column(name = "is_active")
	private boolean isactive;
	
	@Column(name = "branch_id")
	private String BranchId;
	
	@Column(name = "branch_phone1")
	private String payerbranchphone1;
	
	@Column(name = "branch_phone2")
	private String payerbranchphone2;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getCountryid() {
		return countryid;
	}
	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public Integer getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}
	
	
	 public String getLocationame() {
		return locationame;
	}
	public void setLocationame(String locationame) {
		this.locationame = locationame;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	public String getBranchId() {
		return BranchId;
	}
	public void setBranchId(String branchId) {
		BranchId = branchId;
	}
	
	
	public String getPayerbranchphone1() {
		return payerbranchphone1;
	}
	public void setPayerbranchphone1(String payerbranchphone1) {
		this.payerbranchphone1 = payerbranchphone1;
	}
	public String getPayerbranchphone2() {
		return payerbranchphone2;
	}
	public void setPayerbranchphone2(String payerbranchphone2) {
		this.payerbranchphone2 = payerbranchphone2;
	}
	public LocationDto toLocationDto() {
		 LocationDto locationDto =null;
		 locationDto = new LocationDto();
		 locationDto.setAddress(this.address);
		 locationDto.setCityid(this.cityid);
		 locationDto.setCountryid(this.countryid);
		 locationDto.setId(this.id);
		 locationDto.setLatitude(this.latitude);
		 locationDto.setLongitude(this.longitude);
		 locationDto.setPartnerid(this.partnerid);
		 locationDto.setStateid(this.stateid);
		 locationDto.setLocationname(this.locationame);
		 locationDto.setIsactive(this.isactive);
		 locationDto.setBranchId(this.BranchId);
		 locationDto.setPayerbranchphone1(this.payerbranchphone1);
		 locationDto.setPayerbranchphone2(this.payerbranchphone2);
		 return locationDto;
		 
		 
	 }

}
