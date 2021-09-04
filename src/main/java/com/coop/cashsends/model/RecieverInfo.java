package com.coop.cashsends.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coop.cashsends.audit.Auditable;


@Entity
@Table(name = "reciever_info")
public class RecieverInfo extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

	@Column(name = "tfpin")
    private String tfpin;
	@Column(name = "reciever_id")
    private String recieverid;
	@Column(name = "full_name")
    private String fullname;
	
	@Column(name = "first_name")
    private String firstname;
	@Column(name = "second_name")
    private String secondname;
	@Column(name = "last_name")
    private String lastname;
	@Column(name = "complete_address")
    private String completeaddress;
	@Column(name = "mobile_phone")
    private String mobilephone;
	@Column(name = "work_phone")
    private String workphone;
	@Column(name = "home_phone")
    private String homephone;
	
	@Column(name = "email")
    private String email;
	@Column(name = "is_individual")
    private boolean isindividual;
	@Column(name = "country_code")
    private String countrycode;
	@Column(name = "country_name")
    private String countryname;
	@Column(name = "state_name")
    private String statename;
	@Column(name = "state_id")
    private String stateid;
	@Column(name = "city_name")
    private String cityname;
	@Column(name = "city_id")
    private String cityid;
	@Column(name = "date_of_birth")
	private String dateofbirth;
	@Column(name = "town_id")
	private String townid;
	@Column(name = "town_name")
	private String townname;
	@Column(name = "zip_code")
	private String zipcode;
	
	@Column(name = "nationality_iso_code")
	private String nationalityisocode;
	
	@OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private SendMoneyTransaction sendmoneytransaction;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTfpin() {
		return tfpin;
	}
	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	public String getRecieverid() {
		return recieverid;
	}
	public void setRecieverid(String recieverid) {
		this.recieverid = recieverid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCompleteaddress() {
		return completeaddress;
	}
	public void setCompleteaddress(String completeaddress) {
		this.completeaddress = completeaddress;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getWorkphone() {
		return workphone;
	}
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	public String getHomephone() {
		return homephone;
	}
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIsindividual() {
		return isindividual;
	}
	public void setIsindividual(boolean isindividual) {
		this.isindividual = isindividual;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public SendMoneyTransaction getSendmoneytransaction() {
		return sendmoneytransaction;
	}
	public void setSendmoneytransaction(SendMoneyTransaction sendmoneytransaction) {
		this.sendmoneytransaction = sendmoneytransaction;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getTownid() {
		return townid;
	}
	public void setTownid(String townid) {
		this.townid = townid;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getNationalityisocode() {
		return nationalityisocode;
	}
	public void setNationalityisocode(String nationalityisocode) {
		this.nationalityisocode = nationalityisocode;
	}
	public String getTownname() {
		return townname;
	}
	public void setTownname(String townname) {
		this.townname = townname;
	}
	
	


}
