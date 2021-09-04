package com.coop.cashsends.dto;

public class CancelorComplaintDto {

 public String TfPin;
 public String Description;
 public String PetitionType;
 public Integer ReasonId;
 public String authorizationkey;
 public String basecode;
 public String url;
 public String ErrorCode;
 public String TransactionType;
 
 
 
 
public String getTransactionType() {
	return TransactionType;
}
public void setTransactionType(String transactionType) {
	TransactionType = transactionType;
}
public String getErrorCode() {
	return ErrorCode;
}
public void setErrorCode(String errorCode) {
	ErrorCode = errorCode;
}
public String getBasecode() {
	return basecode;
}
public void setBasecode(String basecode) {
	this.basecode = basecode;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getAuthorizationkey() {
	return authorizationkey;
}
public void setAuthorizationkey(String authorizationkey) {
	this.authorizationkey = authorizationkey;
}
public String getTfPin() {
	return TfPin;
}
public void setTfPin(String tfPin) {
	TfPin = tfPin;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getPetitionType() {
	return PetitionType;
}
public void setPetitionType(String petitionType) {
	PetitionType = petitionType;
}
public Integer getReasonId() {
	return ReasonId;
}
public void setReasonId(Integer reasonId) {
	ReasonId = reasonId;
}
 
 
 
}
