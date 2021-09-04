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

@Entity
@Table(name = "comissions")
@EntityListeners(AuditingEntityListener.class)
public class Comissions extends Auditable<String> {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "partner_id")
	private Integer partnerid;	
	@Column(name = "partner_name")
	private String partnername;	
	@Column(name = "transaction_type_id")
	private Integer transactiontypeid;
	@Column(name = "service_type_id")
	private Integer servicetypeid;
	@Column(name = "payment_mode_id")
	private Integer paymentmodeid;
	@Column(name = "payment_mode")
	private String paymentmode;
	@Column(name = "sender_country_id")
	private Integer sendercountryid;
	@Column(name = "sender_country_name")
	private String sendercountryname;
	@Column(name = "reciever_country_id")
	private Integer recievercountryid;
	@Column(name = "reciever_country_name")
	private String recievercountryname;
	@Column(name = "currency_id")
	private Integer currencyid;
	@Column(name = "currency_code")
	private String currencycode;
	@Column(name = "start_range")
	private float startrange;
	@Column(name = "end_range")
	private float endrange;
	@Column(name = "flat_rate")
	private float flatrate;
	@Column(name = "percentage")
	private float precentage;
	@Column(name = "priority")
	private Integer priority;
	@Column(name = "description")
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}
	public String getPartnername() {
		return partnername;
	}
	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
	public Integer getTransactiontypeid() {
		return transactiontypeid;
	}
	public void setTransactiontypeid(Integer transactiontypeid) {
		this.transactiontypeid = transactiontypeid;
	}
	public Integer getServicetypeid() {
		return servicetypeid;
	}
	public void setServicetypeid(Integer servicetypeid) {
		this.servicetypeid = servicetypeid;
	}
	public Integer getPaymentmodeid() {
		return paymentmodeid;
	}
	public void setPaymentmodeid(Integer paymentmodeid) {
		this.paymentmodeid = paymentmodeid;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public Integer getSendercountryid() {
		return sendercountryid;
	}
	public void setSendercountryid(Integer sendercountryid) {
		this.sendercountryid = sendercountryid;
	}
	public String getSendercountryname() {
		return sendercountryname;
	}
	public void setSendercountryname(String sendercountryname) {
		this.sendercountryname = sendercountryname;
	}
	public Integer getRecievercountryid() {
		return recievercountryid;
	}
	public void setRecievercountryid(Integer recievercountryid) {
		this.recievercountryid = recievercountryid;
	}
	public String getRecievercountryname() {
		return recievercountryname;
	}
	public void setRecievercountryname(String recievercountryname) {
		this.recievercountryname = recievercountryname;
	}
	public Integer getCurrencyid() {
		return currencyid;
	}
	public void setCurrencyid(Integer currencyid) {
		this.currencyid = currencyid;
	}
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public float getStartrange() {
		return startrange;
	}
	public void setStartrange(float startrange) {
		this.startrange = startrange;
	}
	public float getEndrange() {
		return endrange;
	}
	public void setEndrange(float endrange) {
		this.endrange = endrange;
	}
	public float getFlatrate() {
		return flatrate;
	}
	public void setFlatrate(float flatrate) {
		this.flatrate = flatrate;
	}
	public float getPrecentage() {
		return precentage;
	}
	public void setPrecentage(float precentage) {
		this.precentage = precentage;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
