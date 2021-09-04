package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;

@Entity
@Table(name = "coop_money_trans_info")
@EntityListeners(AuditingEntityListener.class)
public class CoopRecieveMoneyTransInfo extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "amount")
    private float amount;
	
	@Column(name = "service_fees")
    private float servicefees;
	
	@Column(name = "tax")
    private float tax;
	
	@Column(name = "total_amount")
    private float totalamount;
	
	@Column(name = "sent_amount")
    private float sentamount;
	
	@Column(name = "exchange_rate")
    private float exchangerate;
	
	@Column(name = "bank_name")
    private String bankname;
	
	@Column(name = "account_number")
    private String accountnumber;
	
	@Column(name = "account_type")
    private String accounttype;
	
	@Column(name = "sender_currency_code")
    private String sendercurrencycode;
	
	@Column(name = "reciever_currency_code")
    private String recievercurrencycode;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private CoopRecieverTransaction cooprecievertransaction;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public float getServicefees() {
		return servicefees;
	}


	public void setServicefees(float servicefees) {
		this.servicefees = servicefees;
	}


	public float getTax() {
		return tax;
	}


	public void setTax(float tax) {
		this.tax = tax;
	}


	public float getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}


	public float getSentamount() {
		return sentamount;
	}


	public void setSentamount(float sentamount) {
		this.sentamount = sentamount;
	}


	public float getExchangerate() {
		return exchangerate;
	}


	public void setExchangerate(float exchangerate) {
		this.exchangerate = exchangerate;
	}


	public String getBankname() {
		return bankname;
	}


	public void setBankname(String bankname) {
		this.bankname = bankname;
	}


	public String getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	public CoopRecieverTransaction getCooprecievertransaction() {
		return cooprecievertransaction;
	}


	public void setCooprecievertransaction(CoopRecieverTransaction cooprecievertransaction) {
		this.cooprecievertransaction = cooprecievertransaction;
	}


	public String getSendercurrencycode() {
		return sendercurrencycode;
	}


	public void setSendercurrencycode(String sendercurrencycode) {
		this.sendercurrencycode = sendercurrencycode;
	}


	public String getRecievercurrencycode() {
		return recievercurrencycode;
	}


	public void setRecievercurrencycode(String recievercurrencycode) {
		this.recievercurrencycode = recievercurrencycode;
	}	
	
	

}
