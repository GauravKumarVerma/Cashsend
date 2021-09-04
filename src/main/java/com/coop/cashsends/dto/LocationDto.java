package com.coop.cashsends.dto;

public class LocationDto {
	
 private Integer id;
 private String countryid;
 private String stateid;
 private Integer cityid;
 private String address;
 private String locationname;
 private boolean isactive;
 private float latitude;
 private float longitude;
 private Integer partnerid;
 public String BranchId;
 private String payerbranchphone1;
 private String payerbranchphone2;
 
 
 
public String getBranchId() {
	return BranchId;
}
public void setBranchId(String branchId) {
	BranchId = branchId;
}
public String getLocationname() {
	return locationname;
}
public void setLocationname(String locationname) {
	this.locationname = locationname;
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
public String getCountryid() {
	return countryid;
}
public void setCountryid(String countryid) {
	this.countryid = countryid;
}
public String getStateid() {
	return stateid;
}
public void setStateid(String stateid) {
	this.stateid = stateid;
}
public Integer getCityid() {
	return cityid;
}
public void setCityid(Integer cityid) {
	this.cityid = cityid;
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
public Integer getPartnerid() {
	return partnerid;
}
public void setPartnerid(Integer partnerid) {
	this.partnerid = partnerid;
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
 
 
 

}
