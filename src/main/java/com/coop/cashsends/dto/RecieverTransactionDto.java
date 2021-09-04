package com.coop.cashsends.dto;

import java.time.LocalDateTime;

public class RecieverTransactionDto {

	private Integer id;
	private String tfpin;
	private String receiptno;
	private LocalDateTime transactiondate;
	private String sendername;
	private String recievername;
	private String sendercountry;
	private String recievercountry;
	private float amount;
	private String transactiontype;
	private RecieveMoneyTransInfoDto recieveMoneytransInfo;
	private String sendercity;
	private String senderstate;
	private String recievercity;
	private String recieverstate;
	private String recievercurrency;
	private String status;
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getRecievercurrency() {
		return recievercurrency;
	}
	public void setRecievercurrency(String recievercurrency) {
		this.recievercurrency = recievercurrency;
	}
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
	public LocalDateTime getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(LocalDateTime transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getRecievername() {
		return recievername;
	}
	public void setRecievername(String recievername) {
		this.recievername = recievername;
	}
	public String getSendercountry() {
		return sendercountry;
	}
	public void setSendercountry(String sendercountry) {
		this.sendercountry = sendercountry;
	}
	public String getRecievercountry() {
		return recievercountry;
	}
	public void setRecievercountry(String recievercountry) {
		this.recievercountry = recievercountry;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public RecieveMoneyTransInfoDto getRecieveMoneytransInfo() {
		return recieveMoneytransInfo;
	}
	public void setRecieveMoneytransInfo(RecieveMoneyTransInfoDto recieveMoneytransInfo) {
		this.recieveMoneytransInfo = recieveMoneytransInfo;
	}
	
	
	
}
