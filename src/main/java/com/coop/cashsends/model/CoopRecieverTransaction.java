package com.coop.cashsends.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.CoopRecieveMoneyTransInfoDto;
import com.coop.cashsends.dto.CoopRecieverTransactionDto;

@Entity
@Table(name = "coop_reciever_transaction")
@EntityListeners(AuditingEntityListener.class)
public class CoopRecieverTransaction extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "tfpin")
    private String tfpin;	
	
	@Column(name = "receipt_no")
    private String receiptno;
	
	
	@Column(name = "reciever_country")
    private String recievercountry;
	
	@Column(name = "reciever_state")
    private String recieverstate;
	
	@Column(name = "reciever_city")
    private String recievercity;
	
	@Column(name = "transaction_type")
    private String transactiontype;
	
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
	
	@Column(name = "reciever_gender")
    private String recievergender;
	
	@Column(name = "reciever_relationship")
    private String recieverrelationship;
	
	
	@Column(name = "id_type")
    private String idtype;
	
	@Column(name = "id_type_name")
    private String idtypename;
	
	@Column(name = "identification_number")
    private String identificationnumber;
	
	@Column(name = "remittance_purpose")
    private String remittancepurpose;
	
	@Column(name = "form_of_payment")
    private String formofpayment;
	
	@Column(name = "remittance_purpose_id")
    private String remittancepurposeid;
	
	@Column(name = "form_of_payment_id")
    private String formofpaymentid;
	
	@Column(name = "issue_date")
    private String issuedate;
	
	@Column(name = "id_expiration_date")
    private String idexpirationdate;
	
	
	
	@Column(name = "status")
    private String status;
	
	@OneToOne(mappedBy = "cooprecievertransaction", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
     private CoopRecieveMoneyTransInfo coopRecieveMoneyTransInfo;

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

	public String getReceiptno() {
		return receiptno;
	}

	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}

    
	
	public String getRecieverstate() {
		return recieverstate;
	}

	public void setRecieverstate(String recieverstate) {
		this.recieverstate = recieverstate;
	}

	public String getRecievercity() {
		return recievercity;
	}

	public void setRecievercity(String recievercity) {
		this.recievercity = recievercity;
	}

	public String getRecievercountry() {
		return recievercountry;
	}

	public void setRecievercountry(String recievercountry) {
		this.recievercountry = recievercountry;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
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

	public String getRecievergender() {
		return recievergender;
	}

	public void setRecievergender(String recievergender) {
		this.recievergender = recievergender;
	}

	public String getRecieverrelationship() {
		return recieverrelationship;
	}

	public void setRecieverrelationship(String recieverrelationship) {
		this.recieverrelationship = recieverrelationship;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdentificationnumber() {
		return identificationnumber;
	}

	public void setIdentificationnumber(String identificationnumber) {
		this.identificationnumber = identificationnumber;
	}

	public String getRemittancepurpose() {
		return remittancepurpose;
	}

	public void setRemittancepurpose(String remittancepurpose) {
		this.remittancepurpose = remittancepurpose;
	}

	public String getFormofpayment() {
		return formofpayment;
	}

	public void setFormofpayment(String formofpayment) {
		this.formofpayment = formofpayment;
	}

	public String getRemittancepurposeid() {
		return remittancepurposeid;
	}

	public void setRemittancepurposeid(String remittancepurposeid) {
		this.remittancepurposeid = remittancepurposeid;
	}

	public String getFormofpaymentid() {
		return formofpaymentid;
	}

	public void setFormofpaymentid(String formofpaymentid) {
		this.formofpaymentid = formofpaymentid;
	}

	

	public String getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}

	public String getIdexpirationdate() {
		return idexpirationdate;
	}

	public void setIdexpirationdate(String idexpirationdate) {
		this.idexpirationdate = idexpirationdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CoopRecieveMoneyTransInfo getCoopRecieveMoneyTransInfo() {
		return coopRecieveMoneyTransInfo;
	}

	public void setCoopRecieveMoneyTransInfo(CoopRecieveMoneyTransInfo coopRecieveMoneyTransInfo) {
		this.coopRecieveMoneyTransInfo = coopRecieveMoneyTransInfo;
	}
	
	
	
	public String getIdtypename() {
		return idtypename;
	}

	public void setIdtypename(String idtypename) {
		this.idtypename = idtypename;
	}

	public CoopRecieverTransactionDto tocoopRecieverTransactionDto() {
		CoopRecieverTransactionDto CoopRecieverTransactionDto = null;
		CoopRecieverTransactionDto = new CoopRecieverTransactionDto();
		CoopRecieverTransactionDto.setId(this.id);
		CoopRecieverTransactionDto.setFormofpayment(this.formofpayment);
		CoopRecieverTransactionDto.setFormofpaymentid(this.formofpaymentid);
		CoopRecieverTransactionDto.setIdentificationnumber(this.identificationnumber);
		CoopRecieverTransactionDto.setIdexpirationdate(this.idexpirationdate);
		CoopRecieverTransactionDto.setIdtype(this.idtype);
		CoopRecieverTransactionDto.setIssuedate(this.issuedate);
		CoopRecieverTransactionDto.setReceiptno(this.receiptno);
		CoopRecieverTransactionDto.setRecieveraddress(this.recieveraddress);
		CoopRecieverTransactionDto.setRecievercity(this.recievercity);
		CoopRecieverTransactionDto.setRecievercountry(this.recievercountry);
		CoopRecieverTransactionDto.setRecievergender(this.recievergender);
		CoopRecieverTransactionDto.setRecieverhome(this.recieverhome);
		CoopRecieverTransactionDto.setRecievermobile(this.recievermobile);
		CoopRecieverTransactionDto.setRecievername(this.recievername);
		CoopRecieverTransactionDto.setRecieverrelationship(this.recieverrelationship);
		CoopRecieverTransactionDto.setRecieverstate(this.recieverstate);
		CoopRecieverTransactionDto.setRecieverwork(this.recieverwork);
		CoopRecieverTransactionDto.setRemittancepurpose(this.remittancepurpose);
		CoopRecieverTransactionDto.setRemittancepurposeid(this.remittancepurposeid);
		CoopRecieverTransactionDto.setIdtypename(this.idtypename);
		
		CoopRecieveMoneyTransInfo coopRecieveMoneyTransInfo =this.coopRecieveMoneyTransInfo;
		
		CoopRecieveMoneyTransInfoDto coopRecieveMoneyTransInfoDto = null;
		coopRecieveMoneyTransInfoDto = new CoopRecieveMoneyTransInfoDto();
		coopRecieveMoneyTransInfoDto.setAccountnumber(coopRecieveMoneyTransInfo.getAccountnumber());
		coopRecieveMoneyTransInfoDto.setAccounttype(coopRecieveMoneyTransInfo.getAccounttype());
		coopRecieveMoneyTransInfoDto.setAmount(coopRecieveMoneyTransInfo.getAmount());
		coopRecieveMoneyTransInfoDto.setBankname(coopRecieveMoneyTransInfo.getBankname());
		coopRecieveMoneyTransInfoDto.setExchangerate(coopRecieveMoneyTransInfo.getExchangerate());
		coopRecieveMoneyTransInfoDto.setId(coopRecieveMoneyTransInfo.getId());
		coopRecieveMoneyTransInfoDto.setRecievercurrencycode(coopRecieveMoneyTransInfo.getRecievercurrencycode());
		coopRecieveMoneyTransInfoDto.setSendercurrencycode(coopRecieveMoneyTransInfo.getSendercurrencycode());
		coopRecieveMoneyTransInfoDto.setSentamount(coopRecieveMoneyTransInfo.getSentamount());
		coopRecieveMoneyTransInfoDto.setServicefees(coopRecieveMoneyTransInfo.getServicefees());
		coopRecieveMoneyTransInfoDto.setTax(coopRecieveMoneyTransInfo.getTax());
		coopRecieveMoneyTransInfoDto.setTotalamount(coopRecieveMoneyTransInfo.getTotalamount());
		CoopRecieverTransactionDto.setCoopRecieveMoneyTransInfo(coopRecieveMoneyTransInfoDto);
		return CoopRecieverTransactionDto;
	}
	 
	

}
