package com.coop.cashsends.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.PartnerDto;
import com.coop.cashsends.dto.WalletDto;


@Entity
@Table(name = "partner")
@EntityListeners(AuditingEntityListener.class)
public class Partner extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "user_id")
	private Integer userid;
	@Column(name = "business_name")
	private String businessname;
	@Column(name = "ruc_number")
	private String rucnumber;
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
	@Column(name = "email")
	private String email;
	@Column(name = "mobile_number")
	private long mobilenumber;
	@Column(name = "whitelist")
	private String whitelist;
	@Column(name = "open_hours")
	private String openhour;
	@Column(name = "open_ampm")
	private String openampm;
	@Column(name = "close_hours")
	private String closehours;
	@Column(name = "close_ampm")
	private String closeampm;
	@Column(name = "time_zone")
	private String timezone;
	
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "credit_amount")
	private float  creditamount;
	
	/*@OneToMany(fetch = FetchType.EAGER,mappedBy = "partner", cascade =  CascadeType.ALL)
    private List<PartnerWorkingdays> partnerWorkingdays;*/
	
	@OneToMany(mappedBy = "partner", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
     private List<Wallet> wallet;
	
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
	/*public List<PartnerWorkingdays> getPartnerWorkingdays() {
		return partnerWorkingdays;
	}
	public void setPartnerWorkingdays(List<PartnerWorkingdays> partnerWorkingdays) {
		this.partnerWorkingdays = partnerWorkingdays;
	}
	*/
	
	
	
	public List<Wallet> getWallet() {
		return wallet;
	}
	public void setWallet(List<Wallet> wallet) {
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
	public PartnerDto toPartnerDto() {
		PartnerDto partnerDto =null;
		partnerDto = new PartnerDto();
		partnerDto.setAddress(this.address);
		partnerDto.setBusinessname(this.businessname);
		partnerDto.setCityid(this.cityid);
		partnerDto.setCloseampm(this.closeampm);
		partnerDto.setClosehours(this.closehours);
		partnerDto.setCountryid(this.countryid);
		partnerDto.setEmail(this.email);
		partnerDto.setId(this.id);
		partnerDto.setLatitude(this.latitude);
		partnerDto.setLongitude(this.longitude);
		partnerDto.setMobilenumber(this.mobilenumber);
		partnerDto.setOpenhour(this.openhour);
		partnerDto.setOpenampm(this.openampm);
		partnerDto.setRucnumber(this.rucnumber);
		partnerDto.setStateid(this.stateid);
		partnerDto.setUserid(this.userid);
		partnerDto.setWhitelist(this.whitelist);
		partnerDto.setFirstname(this.firstname);
		partnerDto.setLastname(this.lastname);
		partnerDto.setCreditamount(this.creditamount);
		
		List<Wallet> wallets = this.wallet;
		
		List<WalletDto> walletDtos = null;
		walletDtos = new ArrayList<WalletDto>();
		for (Wallet stats : wallets) {
			WalletDto walletDto = null;
			walletDto = new WalletDto();
			walletDto.setAccountnumber(stats.getAccountnumber());
			walletDto.setIsactive(stats.isIsactive());
			walletDto.setWalletamount(stats.getWalletamount());
			walletDto.setId(stats.getId());
			walletDto.setAccountcode(stats.getAccountcode());
			walletDtos.add(walletDto);
		}
		partnerDto.setWallet(walletDtos);
		
		
		return partnerDto;
	}
	
	
}
