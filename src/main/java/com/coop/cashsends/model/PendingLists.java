package com.coop.cashsends.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.PendingListsDto;


@Entity
@Table(name = "pending_lists")
@EntityListeners(AuditingEntityListener.class)
public class PendingLists extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "TfPin")
	private String TfPin;
	
	@Column(name = "TransactionDate")
	private String TransactionDate;
	
	@Column(name = "SenderFullName")
	private String SenderFullName;
	
	@Column(name = "ReceiverFullName")
	private String ReceiverFullName;
	
	@Column(name = "SenderCountryName")
	private String SenderCountryName;
	
	@Column(name = "ReceiverCountryName")
	private String ReceiverCountryName;
	
	@Column(name = "ReceiveCurrencyIsoCode")
	private String ReceiveCurrencyIsoCode;
	
	@Column(name = "ReceiveAmount")
	private float ReceiveAmount;
	
	@Column(name = "StatusName")
	private String StatusName;
	
	@Column(name = "PaymentModeName")
	private String PaymentModeName;
	
	@Column(name = "ReceiverCountryIsoCode")
	private String ReceiverCountryIsoCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTfPin() {
		return TfPin;
	}

	public void setTfPin(String tfPin) {
		TfPin = tfPin;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}

	public String getSenderFullName() {
		return SenderFullName;
	}

	public void setSenderFullName(String senderFullName) {
		SenderFullName = senderFullName;
	}

	public String getReceiverFullName() {
		return ReceiverFullName;
	}

	public void setReceiverFullName(String receiverFullName) {
		ReceiverFullName = receiverFullName;
	}

	public String getSenderCountryName() {
		return SenderCountryName;
	}

	public void setSenderCountryName(String senderCountryName) {
		SenderCountryName = senderCountryName;
	}

	public String getReceiverCountryName() {
		return ReceiverCountryName;
	}

	public void setReceiverCountryName(String receiverCountryName) {
		ReceiverCountryName = receiverCountryName;
	}

	public String getReceiveCurrencyIsoCode() {
		return ReceiveCurrencyIsoCode;
	}

	public void setReceiveCurrencyIsoCode(String receiveCurrencyIsoCode) {
		ReceiveCurrencyIsoCode = receiveCurrencyIsoCode;
	}

	public float getReceiveAmount() {
		return ReceiveAmount;
	}

	public void setReceiveAmount(float receiveAmount) {
		ReceiveAmount = receiveAmount;
	}

	public String getStatusName() {
		return StatusName;
	}

	public void setStatusName(String statusName) {
		StatusName = statusName;
	}
	
	
	

	public String getReceiverCountryIsoCode() {
		return ReceiverCountryIsoCode;
	}

	public void setReceiverCountryIsoCode(String receiverCountryIsoCode) {
		ReceiverCountryIsoCode = receiverCountryIsoCode;
	}

	public String getPaymentModeName() {
		return PaymentModeName;
	}

	public void setPaymentModeName(String paymentModeName) {
		PaymentModeName = paymentModeName;
	}

	public PendingListsDto toPendingListsDto() {
		PendingListsDto pendingListsDto =null;	
		pendingListsDto = new PendingListsDto();
		pendingListsDto.setReceiveAmount(this.ReceiveAmount);
		pendingListsDto.setReceiveCurrencyIsoCode(this.ReceiveCurrencyIsoCode);
		pendingListsDto.setReceiverCountryName(this.ReceiverCountryName);
		pendingListsDto.setReceiverFullName(this.ReceiverFullName);
		pendingListsDto.setSenderCountryName(this.SenderCountryName);
		pendingListsDto.setSenderFullName(this.SenderFullName);
		pendingListsDto.setStatusName(this.StatusName);
		pendingListsDto.setTfPin(this.TfPin);
		pendingListsDto.setTransactionDate(this.TransactionDate);
		pendingListsDto.setPaymentModeName(this.PaymentModeName);
		pendingListsDto.setReceiverCountryIsoCode(this.ReceiveCurrencyIsoCode);
		return pendingListsDto;
		
	}

}
