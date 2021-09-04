package com.coop.cashsends.dto;

public class PaidDto {
	
 public String TfPin;
 public String IdNumber;
 public String IdType;
 public String IdExpirationDate;
 public String IdDateOfIssue;
 public String IdIssuedBy;
 public String IdTypeOther;
 public String ReceiverAddress;
 public String ReceiverPhone;
 public String ReceiverCountryIsoCode;
 public String ReceiverStateId;
 public String ReceiverPhoneMobile;
 public String ReceiverPhoneHome;
 public String ReceiverNationalityIsoCode;
 public String ReceiverGender;
 public String ReceiverRelationToSender;
 public String FormOfPaymentId;
 public boolean ProofOfAddressCollected;
 public boolean KYCVerified;
 public String PaymentModeId;
 public String createdby;
 public float servicefees;
 public float taxes;
 public String transactiontype;
 public String basecode;
 public String authorizationkey;
 public String baseurl;
 
 public String sendercity;
 public String senderstate;
 public String sendercountry;
 public String sendername;
 public String recievercurrency;
 public String recievercity;
 public String recieverstate;
 public String recievercountry;
 public String recieverfullname;
 public float recieveramount;
 
 public String bankname;
 public String accountnumber;
 public String exchangerate;
 public float Commamountlocal;
 public float Commamountforeign;
 public Integer purposeofremittanceid;
 public String recieveraccounttype;
 
 private String role;
 
 public String sendercurrency;
 public float totalamount;
 
 
 
 
 

public float getCommamountlocal() {
	return Commamountlocal;
}
public float getCommamountforeign() {
	return Commamountforeign;
}
public void setCommamountforeign(float commamountforeign) {
	Commamountforeign = commamountforeign;
}
public void setCommamountlocal(float commamountlocal) {
	Commamountlocal = commamountlocal;
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
public String getExchangerate() {
	return exchangerate;
}
public void setExchangerate(String exchangerate) {
	this.exchangerate = exchangerate;
}

public Integer getPurposeofremittanceid() {
	return purposeofremittanceid;
}
public void setPurposeofremittanceid(Integer purposeofremittanceid) {
	this.purposeofremittanceid = purposeofremittanceid;
}
public String getRecieveraccounttype() {
	return recieveraccounttype;
}
public void setRecieveraccounttype(String recieveraccounttype) {
	this.recieveraccounttype = recieveraccounttype;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public float getRecieveramount() {
	return recieveramount;
}
public void setRecieveramount(float recieveramount) {
	this.recieveramount = recieveramount;
}
public String getTfPin() {
	return TfPin;
}
public void setTfPin(String tfPin) {
	TfPin = tfPin;
}
public String getIdNumber() {
	return IdNumber;
}
public void setIdNumber(String idNumber) {
	IdNumber = idNumber;
}
public String getIdType() {
	return IdType;
}
public void setIdType(String idType) {
	IdType = idType;
}
public String getIdExpirationDate() {
	return IdExpirationDate;
}
public void setIdExpirationDate(String idExpirationDate) {
	IdExpirationDate = idExpirationDate;
}
public String getIdDateOfIssue() {
	return IdDateOfIssue;
}
public void setIdDateOfIssue(String idDateOfIssue) {
	IdDateOfIssue = idDateOfIssue;
}
public String getIdIssuedBy() {
	return IdIssuedBy;
}
public void setIdIssuedBy(String idIssuedBy) {
	IdIssuedBy = idIssuedBy;
}
public String getIdTypeOther() {
	return IdTypeOther;
}
public void setIdTypeOther(String idTypeOther) {
	IdTypeOther = idTypeOther;
}
public String getReceiverAddress() {
	return ReceiverAddress;
}
public void setReceiverAddress(String receiverAddress) {
	ReceiverAddress = receiverAddress;
}
public String getReceiverPhone() {
	return ReceiverPhone;
}
public void setReceiverPhone(String receiverPhone) {
	ReceiverPhone = receiverPhone;
}
public String getReceiverCountryIsoCode() {
	return ReceiverCountryIsoCode;
}
public void setReceiverCountryIsoCode(String receiverCountryIsoCode) {
	ReceiverCountryIsoCode = receiverCountryIsoCode;
}
public String getReceiverStateId() {
	return ReceiverStateId;
}
public void setReceiverStateId(String receiverStateId) {
	ReceiverStateId = receiverStateId;
}
public String getReceiverPhoneMobile() {
	return ReceiverPhoneMobile;
}
public void setReceiverPhoneMobile(String receiverPhoneMobile) {
	ReceiverPhoneMobile = receiverPhoneMobile;
}
public String getReceiverPhoneHome() {
	return ReceiverPhoneHome;
}
public void setReceiverPhoneHome(String receiverPhoneHome) {
	ReceiverPhoneHome = receiverPhoneHome;
}
public String getReceiverNationalityIsoCode() {
	return ReceiverNationalityIsoCode;
}
public void setReceiverNationalityIsoCode(String receiverNationalityIsoCode) {
	ReceiverNationalityIsoCode = receiverNationalityIsoCode;
}
public String getReceiverGender() {
	return ReceiverGender;
}
public void setReceiverGender(String receiverGender) {
	ReceiverGender = receiverGender;
}
public String getReceiverRelationToSender() {
	return ReceiverRelationToSender;
}
public void setReceiverRelationToSender(String receiverRelationToSender) {
	ReceiverRelationToSender = receiverRelationToSender;
}
public String getFormOfPaymentId() {
	return FormOfPaymentId;
}
public void setFormOfPaymentId(String formOfPaymentId) {
	FormOfPaymentId = formOfPaymentId;
}
public boolean isProofOfAddressCollected() {
	return ProofOfAddressCollected;
}
public void setProofOfAddressCollected(boolean proofOfAddressCollected) {
	ProofOfAddressCollected = proofOfAddressCollected;
}
public boolean isKYCVerified() {
	return KYCVerified;
}
public void setKYCVerified(boolean kYCVerified) {
	KYCVerified = kYCVerified;
}
public String getPaymentModeId() {
	return PaymentModeId;
}
public void setPaymentModeId(String paymentModeId) {
	PaymentModeId = paymentModeId;
}
public String getCreatedby() {
	return createdby;
}
public void setCreatedby(String createdby) {
	this.createdby = createdby;
}
public float getServicefees() {
	return servicefees;
}
public void setServicefees(float servicefees) {
	this.servicefees = servicefees;
}
public float getTaxes() {
	return taxes;
}
public void setTaxes(float taxes) {
	this.taxes = taxes;
}
public String getTransactiontype() {
	return transactiontype;
}
public void setTransactiontype(String transactiontype) {
	this.transactiontype = transactiontype;
}
public String getBasecode() {
	return basecode;
}
public void setBasecode(String basecode) {
	this.basecode = basecode;
}
public String getAuthorizationkey() {
	return authorizationkey;
}
public void setAuthorizationkey(String authorizationkey) {
	this.authorizationkey = authorizationkey;
}
public String getBaseurl() {
	return baseurl;
}
public void setBaseurl(String baseurl) {
	this.baseurl = baseurl;
}
public String getSendercity() {
	return sendercity;
}
public void setSendercity(String sendercity) {
	this.sendercity = sendercity;
}
public String getSenderstate() {
	return senderstate;
}
public void setSenderstate(String senderstate) {
	this.senderstate = senderstate;
}
public String getSendercountry() {
	return sendercountry;
}
public void setSendercountry(String sendercountry) {
	this.sendercountry = sendercountry;
}
public String getSendername() {
	return sendername;
}
public void setSendername(String sendername) {
	this.sendername = sendername;
}
public String getRecievercurrency() {
	return recievercurrency;
}
public void setRecievercurrency(String recievercurrency) {
	this.recievercurrency = recievercurrency;
}
public String getRecievercity() {
	return recievercity;
}
public void setRecievercity(String recievercity) {
	this.recievercity = recievercity;
}
public String getRecieverstate() {
	return recieverstate;
}
public void setRecieverstate(String recieverstate) {
	this.recieverstate = recieverstate;
}
public String getRecievercountry() {
	return recievercountry;
}
public void setRecievercountry(String recievercountry) {
	this.recievercountry = recievercountry;
}
public String getRecieverfullname() {
	return recieverfullname;
}
public void setRecieverfullname(String recieverfullname) {
	this.recieverfullname = recieverfullname;
}
public String getSendercurrency() {
	return sendercurrency;
}
public void setSendercurrency(String sendercurrency) {
	this.sendercurrency = sendercurrency;
}
public float getTotalamount() {
	return totalamount;
}
public void setTotalamount(float totalamount) {
	this.totalamount = totalamount;
}
 
 
 
 
 

}
