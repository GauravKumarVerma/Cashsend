package com.coop.cashsends.dto;

public class CreditLimitDto {

 public Integer walletid;	
 public float walletamount;
 public String description;
 public String transactiontype;
public Integer getWalletid() {
	return walletid;
}
public void setWalletid(Integer walletid) {
	this.walletid = walletid;
}
public float getWalletamount() {
	return walletamount;
}
public void setWalletamount(float walletamount) {
	this.walletamount = walletamount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTransactiontype() {
	return transactiontype;
}
public void setTransactiontype(String transactiontype) {
	this.transactiontype = transactiontype;
}
 
 
	
}
