package com.coop.cashsends.dto;

import java.time.LocalDateTime;

public class PendingListsDto {
	
	public String TfPin;
	public String TransactionDate;
	public String SenderFullName;
	public String ReceiverFullName;
	public String SenderCountryName;
	public String ReceiverCountryName;
	public String ReceiveCurrencyIsoCode;
	public String ReceiverCountryIsoCode;
	public float ReceiveAmount;
	public String StatusName;
	public String PaymentModeName;
	
	
	public String getReceiverCountryIsoCode() {
		return ReceiverCountryIsoCode;
	}
	public void setReceiverCountryIsoCode(String receiverCountryIsoCode) {
		ReceiverCountryIsoCode = receiverCountryIsoCode;
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
	public String getPaymentModeName() {
		return PaymentModeName;
	}
	public void setPaymentModeName(String paymentModeName) {
		PaymentModeName = paymentModeName;
	}
	
	

}
