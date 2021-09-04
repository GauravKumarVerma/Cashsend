package com.coop.cashsends.model;

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
@Table(name = "reciever_money_trans_info")
public class RecieveMoneyTransInfo extends Auditable<String> {

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
	
	@Column(name = "Commamount_local")
    private float Commamountlocal;
	
	@Column(name = "Commamount_foreign")
    private float Commamountforeign;
	
	@Column(name = "purposeof_remittanceid")
    private Integer purposeofremittanceid;
	
	@Column(name = "bank_name")
    private String bankname;
	@Column(name = "account_number")
    private String accountnumber;
	
	@Column(name = "account_type")
    private String accounttype;
	
	@Column(name = "sender_name")
    private String sendername;
	
	@Column(name = "sender_address")
    private String senderaddress;
	
	@Column(name = "sender_mobile")
    private String sendermobile;
	
	@Column(name = "sender_home")
    private String senderhome;
	
	@Column(name = "sender_work")
    private String senderwork;
	
	@Column(name = "reciever_name")
    private String recievername;
	
	@Column(name = "reciever_address")
    private String recieveraddress;
	
	@Column(name = "reciever_mobile")
    private String recievermobile;
	
	@Column(name = "reciever_home")
    private String recieverhome;
	
	@Column(name = "reciever_work")
    private String recieverwork;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private RecieverTransaction recievertransaction;

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

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getSenderaddress() {
		return senderaddress;
	}

	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public String getSendermobile() {
		return sendermobile;
	}

	public void setSendermobile(String sendermobile) {
		this.sendermobile = sendermobile;
	}

	public String getSenderhome() {
		return senderhome;
	}

	public void setSenderhome(String senderhome) {
		this.senderhome = senderhome;
	}

	public String getSenderwork() {
		return senderwork;
	}

	public void setSenderwork(String senderwork) {
		this.senderwork = senderwork;
	}

	public String getRecievername() {
		return recievername;
	}

	public void setRecievername(String recievername) {
		this.recievername = recievername;
	}

	public String getRecieveraddress() {
		return recieveraddress;
	}

	public void setRecieveraddress(String recieveraddress) {
		this.recieveraddress = recieveraddress;
	}

	public String getRecievermobile() {
		return recievermobile;
	}

	public void setRecievermobile(String recievermobile) {
		this.recievermobile = recievermobile;
	}

	public String getRecieverhome() {
		return recieverhome;
	}

	public void setRecieverhome(String recieverhome) {
		this.recieverhome = recieverhome;
	}

	public String getRecieverwork() {
		return recieverwork;
	}

	public void setRecieverwork(String recieverwork) {
		this.recieverwork = recieverwork;
	}

	public RecieverTransaction getRecievertransaction() {
		return recievertransaction;
	}

	public void setRecievertransaction(RecieverTransaction recievertransaction) {
		this.recievertransaction = recievertransaction;
	}

	public float getCommamountlocal() {
		return Commamountlocal;
	}

	public void setCommamountlocal(float commamountlocal) {
		Commamountlocal = commamountlocal;
	}

	public float getCommamountforeign() {
		return Commamountforeign;
	}

	public void setCommamountforeign(float commamountforeign) {
		Commamountforeign = commamountforeign;
	}

	public Integer getPurposeofremittanceid() {
		return purposeofremittanceid;
	}

	public void setPurposeofremittanceid(Integer purposeofremittanceid) {
		this.purposeofremittanceid = purposeofremittanceid;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	
	
	
	
}
