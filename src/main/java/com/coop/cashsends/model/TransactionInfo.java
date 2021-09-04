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
@Table(name = "transaction_info")
public class TransactionInfo extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "tfpin")
    private String tfpin;
	
	@Column(name = "payment_mode_id")
    private String paymentmodeid;
	@Column(name = "payment_mode_name")
    private String paymentmodename;
	@Column(name = "reciever_currency_code")
    private String recievercurrencycode;
	@Column(name = "bank_branch_id")
    private String bankbranchid;
	@Column(name = "account_type_id")
    private String accounttypeid;
	@Column(name = "account_type_name")
    private String accounttypename;
	@Column(name = "payer_name")
    private String payername;
	@Column(name = "payer_id")
    private String payerid;
	@Column(name = "paying_branch_id")
    private String payingbranchid;
	@Column(name = "paying_branch_name")
    private String payingbranchname;
	
	@Column(name = "source_currency_code")
    private String sourcecurrencycode;
	@Column(name = "source_currency_name")
    private String sourcecurrencyname;
	@Column(name = "rate")
    private float rate;
	@Column(name = "total_sent_amount")
    private float totalsentamount;
	@Column(name = "service_fees")
    private float servicefees;
	@Column(name = "handling_amount")
    private float handlingamount;
	@Column(name = "fee_rate")
    private float feerate;
	@Column(name = "form_of_payment_id")
    private String formofpaymentid;
	@Column(name = "form_of_payment_name")
    private String formofpaymentname;
	@Column(name = "cash_amount")
    private float cashamount;
	@Column(name = "pay_out")
    private float payout;
	@Column(name = "credit_amount")
    private float creditamount;
	@Column(name = "approval_code")
    private String approvalcode;
	@Column(name = "sent_amount")
    private float sentamount;
	@Column(name = "receiver_amount")
    private float recieveamount;
	@Column(name = "settlement_rate")
    private float settlementrate;
	@Column(name = "tax")
    private float tax;
	@Column(name = "cashier_name")
    private String cashiername;
	@Column(name = "product_name")
    private String productname;
	@Column(name = "payer_branch_address")
    private String payerbranchaddress;
	@Column(name = "payer_branch_phone1")
    private String payerbranchphone1;
	@Column(name = "payer_branch_phone2")
    private String payerbranchphone2;
	@Column(name = "backend_fee")
    private float backendfee;
	@Column(name = "source_of_fund")
    private String sourceoffund;
	
	@Column(name = "bank_id")
    private String bankid;
	@Column(name = "purpose_of_remittanceid")
    private String purposeofremittance;
	
	@Column(name = "bank_name")
    private String bankname;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
	public String getPaymentmodeid() {
		return paymentmodeid;
	}
	public void setPaymentmodeid(String paymentmodeid) {
		this.paymentmodeid = paymentmodeid;
	}
	public String getPaymentmodename() {
		return paymentmodename;
	}
	public void setPaymentmodename(String paymentmodename) {
		this.paymentmodename = paymentmodename;
	}
	
	public String getAccounttypeid() {
		return accounttypeid;
	}
	public void setAccounttypeid(String accounttypeid) {
		this.accounttypeid = accounttypeid;
	}
	public String getAccounttypename() {
		return accounttypename;
	}
	public void setAccounttypename(String accounttypename) {
		this.accounttypename = accounttypename;
	}
	public String getPayername() {
		return payername;
	}
	public void setPayername(String payername) {
		this.payername = payername;
	}
	public String getPayerid() {
		return payerid;
	}
	public void setPayerid(String payerid) {
		this.payerid = payerid;
	}
	public String getPayingbranchid() {
		return payingbranchid;
	}
	public void setPayingbranchid(String payingbranchid) {
		this.payingbranchid = payingbranchid;
	}
	public String getPayingbranchname() {
		return payingbranchname;
	}
	public void setPayingbranchname(String payingbranchname) {
		this.payingbranchname = payingbranchname;
	}
	public String getSourcecurrencycode() {
		return sourcecurrencycode;
	}
	public void setSourcecurrencycode(String sourcecurrencycode) {
		this.sourcecurrencycode = sourcecurrencycode;
	}
	public String getSourcecurrencyname() {
		return sourcecurrencyname;
	}
	public void setSourcecurrencyname(String sourcecurrencyname) {
		this.sourcecurrencyname = sourcecurrencyname;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getTotalsentamount() {
		return totalsentamount;
	}
	public void setTotalsentamount(float totalsentamount) {
		this.totalsentamount = totalsentamount;
	}
	public float getServicefees() {
		return servicefees;
	}
	public void setServicefees(float servicefees) {
		this.servicefees = servicefees;
	}
	public float getHandlingamount() {
		return handlingamount;
	}
	public void setHandlingamount(float handlingamount) {
		this.handlingamount = handlingamount;
	}
	public float getFeerate() {
		return feerate;
	}
	public void setFeerate(float feerate) {
		this.feerate = feerate;
	}
	public String getFormofpaymentid() {
		return formofpaymentid;
	}
	public void setFormofpaymentid(String formofpaymentid) {
		this.formofpaymentid = formofpaymentid;
	}
	public String getFormofpaymentname() {
		return formofpaymentname;
	}
	public void setFormofpaymentname(String formofpaymentname) {
		this.formofpaymentname = formofpaymentname;
	}
	public float getCashamount() {
		return cashamount;
	}
	public void setCashamount(float cashamount) {
		this.cashamount = cashamount;
	}
	public float getPayout() {
		return payout;
	}
	public void setPayout(float payout) {
		this.payout = payout;
	}
	public float getCreditamount() {
		return creditamount;
	}
	public void setCreditamount(float creditamount) {
		this.creditamount = creditamount;
	}
	public float getSentamount() {
		return sentamount;
	}
	public void setSentamount(float sentamount) {
		this.sentamount = sentamount;
	}
	public float getRecieveamount() {
		return recieveamount;
	}
	public void setRecieveamount(float recieveamount) {
		this.recieveamount = recieveamount;
	}
	
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getCashiername() {
		return cashiername;
	}
	public void setCashiername(String cashiername) {
		this.cashiername = cashiername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
	public String getPayerbranchaddress() {
		return payerbranchaddress;
	}
	public void setPayerbranchaddress(String payerbranchaddress) {
		this.payerbranchaddress = payerbranchaddress;
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
	public SendMoneyTransaction getSendmoneytransaction() {
		return sendmoneytransaction;
	}
	public void setSendmoneytransaction(SendMoneyTransaction sendmoneytransaction) {
		this.sendmoneytransaction = sendmoneytransaction;
	}
	public String getRecievercurrencycode() {
		return recievercurrencycode;
	}
	public void setRecievercurrencycode(String recievercurrencycode) {
		this.recievercurrencycode = recievercurrencycode;
	}
	public String getBankbranchid() {
		return bankbranchid;
	}
	public void setBankbranchid(String bankbranchid) {
		this.bankbranchid = bankbranchid;
	}
	public String getApprovalcode() {
		return approvalcode;
	}
	public void setApprovalcode(String approvalcode) {
		this.approvalcode = approvalcode;
	}
	public float getSettlementrate() {
		return settlementrate;
	}
	public void setSettlementrate(float settlementrate) {
		this.settlementrate = settlementrate;
	}
	public float getBackendfee() {
		return backendfee;
	}
	public void setBackendfee(float backendfee) {
		this.backendfee = backendfee;
	}
	public String getSourceoffund() {
		return sourceoffund;
	}
	public void setSourceoffund(String sourceoffund) {
		this.sourceoffund = sourceoffund;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getPurposeofremittance() {
		return purposeofremittance;
	}
	public void setPurposeofremittance(String purposeofremittance) {
		this.purposeofremittance = purposeofremittance;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	

}
