package com.coop.cashsends.dto;

import java.util.List;

public class PartnerDto {

	 private Integer id;	
	 private Integer userid;
	 private String businessname;
	 private String rucnumber;
	 private String address;
	 private float latitude;
	 private float longitude;
	 private String countryid;
	 private Integer cityid;
	 private String stateid;
	 private String email;
	 private long mobilenumber;
	 private String whitelist;
	 private String openhour;
	 private String openampm;
	 private String closehours;
	 private String closeampm;
	 private String timezone;
	 private float  creditamount;
	 private List<WalletDto> wallet;
	 private String firstname;
	 private String lastname;
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
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getRucnumber() {
		return rucnumber;
	}
	public void setRucnumber(String rucnumber) {
		this.rucnumber = rucnumber;
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
	public String getWhitelist() {
		return whitelist;
	}
	public void setWhitelist(String whitelist) {
		this.whitelist = whitelist;
	}
	public String getOpenhour() {
		return openhour;
	}
	public void setOpenhour(String openhour) {
		this.openhour = openhour;
	}
	public String getOpenampm() {
		return openampm;
	}
	public void setOpenampm(String openampm) {
		this.openampm = openampm;
	}
	public String getClosehours() {
		return closehours;
	}
	public void setClosehours(String closehours) {
		this.closehours = closehours;
	}
	public String getCloseampm() {
		return closeampm;
	}
	public void setCloseampm(String closeampm) {
		this.closeampm = closeampm;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public float getCreditamount() {
		return creditamount;
	}
	public void setCreditamount(float creditamount) {
		this.creditamount = creditamount;
	}
	
	
	public List<WalletDto> getWallet() {
		return wallet;
	}
	public void setWallet(List<WalletDto> wallet) {
		this.wallet = wallet;
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
	 
	 
	
}
