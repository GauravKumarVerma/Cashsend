package com.coop.cashsends.dto;


import java.util.List;




public class UserDto {
	
	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private long mobilenumber;
	private String email;
	private boolean isactive;
	private List<String> role;
	
	private String address;
	private Integer zipcode;
	private Integer cityid;
	private String countryid;
	private String stateid;
	
	private String businessname;
	private String rucnumber;
    private String whitelist;
    private String openhour;
    private String openampm;
    private String closehours;
    private String closeampm;
    private String timezone;
    private float walletamount;
    private String usertype;
    private Integer locationid;
    private Integer partnerid;
    private Integer tellerid;
    private boolean isfirstuser;
    
    
    
    public Integer getTellerid() {
		return tellerid;
	}

	public void setTellerid(Integer tellerid) {
		this.tellerid = tellerid;
	}

	public Integer getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}

	private List<PartnerWorkingdaysDto> partnerWorkingdays;
    
    private WalletDto wallet;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	
	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
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

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRucnumber() {
		return rucnumber;
	}

	public void setRucnumber(String rucnumber) {
		this.rucnumber = rucnumber;
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

	public List<PartnerWorkingdaysDto> getPartnerWorkingdays() {
		return partnerWorkingdays;
	}

	public void setPartnerWorkingdays(List<PartnerWorkingdaysDto> partnerWorkingdays) {
		this.partnerWorkingdays = partnerWorkingdays;
	}

	public WalletDto getWallet() {
		return wallet;
	}

	public void setWallet(WalletDto wallet) {
		this.wallet = wallet;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public float getWalletamount() {
		return walletamount;
	}

	public void setWalletamount(float walletamount) {
		this.walletamount = walletamount;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public boolean isIsfirstuser() {
		return isfirstuser;
	}

	public void setIsfirstuser(boolean isfirstuser) {
		this.isfirstuser = isfirstuser;
	}
	
	
	

}
