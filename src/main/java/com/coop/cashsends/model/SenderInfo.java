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
@Table(name = "sender_info")
public class SenderInfo extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "loyalty_Card_number")
    private String loyaltycardnumber;
	@Column(name = "name")
    private String name;
	@Column(name = "address")
    private String address;
	@Column(name = "zipcode")
    private String zipcode;
	@Column(name = "phone_mobile")
    private String phonemobile;
	@Column(name = "phone_home")
    private String phonehome;
	@Column(name = "phone_work")
    private String phonework;
	@Column(name = "is_individual")
    private boolean issindividual;
	@Column(name = "country_code")
    private String countrycode;
	@Column(name = "country_name")
    private String countryname;
	@Column(name = "state_id")
    private String stateid;
	@Column(name = "city_name")
    private String cityname;
	@Column(name = "city_id")
    private String cityid;
	@Column(name = "type_of_id")
    private String typeofid;
	@Column(name = "id_number")
    private String idnumber;
    @Column(name = "id_expiry_date")
    private String idexpirydate;
    @Column(name = "date_of_birth")
    private String dateofbirth;
    @Column(name = "email")
    private String email;
    @Column(name = "sender_id")
    private String senderid;
    @Column(name = "nationality_iso_code")
    private String NationalityIsoCode;
    @Column(name = "state_name")
    private String statename;
    
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private SendMoneyTransaction sendmoneytransaction;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoyaltycardnumber() {
		return loyaltycardnumber;
	}
	public void setLoyaltycardnumber(String loyaltycardnumber) {
		this.loyaltycardnumber = loyaltycardnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhonemobile() {
		return phonemobile;
	}
	public void setPhonemobile(String phonemobile) {
		this.phonemobile = phonemobile;
	}
	public String getPhonehome() {
		return phonehome;
	}
	public void setPhonehome(String phonehome) {
		this.phonehome = phonehome;
	}
	public String getPhonework() {
		return phonework;
	}
	public void setPhonework(String phonework) {
		this.phonework = phonework;
	}
	public boolean isIssindividual() {
		return issindividual;
	}
	public void setIssindividual(boolean issindividual) {
		this.issindividual = issindividual;
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
	public String getTypeofid() {
		return typeofid;
	}
	public void setTypeofid(String typeofid) {
		this.typeofid = typeofid;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getIdexpirydate() {
		return idexpirydate;
	}
	public void setIdexpirydate(String idexpirydate) {
		this.idexpirydate = idexpirydate;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public SendMoneyTransaction getSendmoneytransaction() {
		return sendmoneytransaction;
	}
	public void setSendmoneytransaction(SendMoneyTransaction sendmoneytransaction) {
		this.sendmoneytransaction = sendmoneytransaction;
	}
	public String getNationalityIsoCode() {
		return NationalityIsoCode;
	}
	public void setNationalityIsoCode(String nationalityIsoCode) {
		NationalityIsoCode = nationalityIsoCode;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
    
    
    


}
