package com.coop.cashsends.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class WalletHistoryDto {
	
	public Integer id;	
	public String accountnumber;
	public Integer walletid;
	public float transactionamount;
	public float currentbalance;
	public String transactionstatus;
	public LocalDateTime transactiondate;
	public String transactiondescription;
	public String accountcode;
	public Date updateddate;
	public Integer partnerid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public Integer getWalletid() {
		return walletid;
	}
	public void setWalletid(Integer walletid) {
		this.walletid = walletid;
	}
	public float getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(float transactionamount) {
		this.transactionamount = transactionamount;
	}
	public float getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(float currentbalance) {
		this.currentbalance = currentbalance;
	}
	public String getTransactionstatus() {
		return transactionstatus;
	}
	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}
	public LocalDateTime getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(LocalDateTime transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getTransactiondescription() {
		return transactiondescription;
	}
	public void setTransactiondescription(String transactiondescription) {
		this.transactiondescription = transactiondescription;
	}
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	public Integer getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}
	
	

}
