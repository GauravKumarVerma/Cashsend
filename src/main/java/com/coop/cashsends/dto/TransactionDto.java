package com.coop.cashsends.dto;

public class TransactionDto {
	
 public ReceiverInfoDto Receiver;
 public TransactionInfoDto TransactionInfo;
 public ComplianceDto Compliance;
 public SenderInfoDto Sender;
 public String SenderId;
 public String ReceiverId;
 public String UserIds;
 public String basecode;
 public String authorizationkey;
 public String url;
 public String createdby;
 public float taxamount;
 public float servicefees;
 public String ipaddress;
 
 
 
 
 
 
 
public String getIpaddress() {
	return ipaddress;
}
public void setIpaddress(String ipaddress) {
	this.ipaddress = ipaddress;
}
public float getTaxamount() {
	return taxamount;
}
public void setTaxamount(float taxamount) {
	this.taxamount = taxamount;
}
public float getServicefees() {
	return servicefees;
}
public void setServicefees(float servicefees) {
	this.servicefees = servicefees;
}
public String getCreatedby() {
	return createdby;
}
public void setCreatedby(String createdby) {
	this.createdby = createdby;
}
public String getAuthorizationkey() {
	return authorizationkey;
}
public void setAuthorizationkey(String authorizationkey) {
	this.authorizationkey = authorizationkey;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getBasecode() {
	return basecode;
}
public void setBasecode(String basecode) {
	this.basecode = basecode;
}
public String getSenderId() {
	return SenderId;
}
public void setSenderId(String senderId) {
	SenderId = senderId;
}
public String getReceiverId() {
	return ReceiverId;
}
public void setReceiverId(String receiverId) {
	ReceiverId = receiverId;
}
public String getUserIds() {
	return UserIds;
}
public void setUserIds(String userIds) {
	UserIds = userIds;
}
public ReceiverInfoDto getReceiver() {
	return Receiver;
}
public void setReceiver(ReceiverInfoDto receiver) {
	Receiver = receiver;
}
public TransactionInfoDto getTransactionInfo() {
	return TransactionInfo;
}
public void setTransactionInfo(TransactionInfoDto transactionInfo) {
	TransactionInfo = transactionInfo;
}
public ComplianceDto getCompliance() {
	return Compliance;
}
public void setCompliance(ComplianceDto compliance) {
	Compliance = compliance;
}
public SenderInfoDto getSender() {
	return Sender;
}
public void setSender(SenderInfoDto sender) {
	Sender = sender;
}

 

}
