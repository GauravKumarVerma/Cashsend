package com.coop.cashsends.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.joda.time.DateTime;

public class SendMoneyTransactionDto {
	
	public Integer id;
	public String statusname;
	public String statusid;
	public String tfpin;
	public LocalDateTime transactiondate;
	public boolean canbecancelled;
	public boolean requirespreaml;
	public boolean requirespostaml;
	public String tellername;
	
	public SenderDto sender;
	public RecieverDto receiver;
	public ItransactionDto transactioninfo;
	public String transactiontype;
	public String cancelreasonid;
	public String payerid;
	public String payingbranchid;
	public Date updatedate;
	public String cancelreasonname;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}
	public String getTfpin() {
		return tfpin;
	}
	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}
	public LocalDateTime getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(LocalDateTime transactiondate) {
		this.transactiondate = transactiondate;
	}
	public boolean isCanbecancelled() {
		return canbecancelled;
	}
	public void setCanbecancelled(boolean canbecancelled) {
		this.canbecancelled = canbecancelled;
	}
	public boolean isRequirespreaml() {
		return requirespreaml;
	}
	public void setRequirespreaml(boolean requirespreaml) {
		this.requirespreaml = requirespreaml;
	}
	public boolean isRequirespostaml() {
		return requirespostaml;
	}
	public void setRequirespostaml(boolean requirespostaml) {
		this.requirespostaml = requirespostaml;
	}
	public SenderDto getSender() {
		return sender;
	}
	public void setSender(SenderDto sender) {
		this.sender = sender;
	}
	public RecieverDto getReceiver() {
		return receiver;
	}
	public void setReceiver(RecieverDto receiver) {
		this.receiver = receiver;
	}
	public ItransactionDto getTransactioninfo() {
		return transactioninfo;
	}
	public void setTransactioninfo(ItransactionDto transactioninfo) {
		this.transactioninfo = transactioninfo;
	}
	public String getTellername() {
		return tellername;
	}
	public void setTellername(String tellername) {
		this.tellername = tellername;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getCancelreasonid() {
		return cancelreasonid;
	}
	public void setCancelreasonid(String cancelreasonid) {
		this.cancelreasonid = cancelreasonid;
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
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getCancelreasonname() {
		return cancelreasonname;
	}
	public void setCancelreasonname(String cancelreasonname) {
		this.cancelreasonname = cancelreasonname;
	}
	
	

}
