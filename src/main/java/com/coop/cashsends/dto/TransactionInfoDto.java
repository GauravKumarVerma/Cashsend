package com.coop.cashsends.dto;

public class TransactionInfoDto {
	
	public String PaymentModeId;
	public String ReceiveCurrencyIsoCode;
	public String BankId;
	public String Account;
	public String AccountTypeId;
	public String BankBranchId;
	public String SwiftCode;
	public String PayingBranchId;
	public String PayerId;
	public String PurposeOfRemittanceId;
	public String Rate;
	public String TotalSentAmount;
	public String SentAmount;
	public String ServiceFee;
	public String USDServiceFee;
	public String ReceiveAmount;
	public String CashAmount;
	public String Payout;
	public String ApprovalCode;
	public String FormOfPaymentId;
	public String SourceCurrencyIsoCode;
	public Integer RemittanceId;
	public float tax;
	
	
	
	
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public Integer getRemittanceId() {
		return RemittanceId;
	}
	public void setRemittanceId(Integer remittanceId) {
		RemittanceId = remittanceId;
	}
	public String getPaymentModeId() {
		return PaymentModeId;
	}
	public void setPaymentModeId(String paymentModeId) {
		PaymentModeId = paymentModeId;
	}
	public String getReceiveCurrencyIsoCode() {
		return ReceiveCurrencyIsoCode;
	}
	public void setReceiveCurrencyIsoCode(String receiveCurrencyIsoCode) {
		ReceiveCurrencyIsoCode = receiveCurrencyIsoCode;
	}
	public String getBankId() {
		return BankId;
	}
	public void setBankId(String bankId) {
		BankId = bankId;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getAccountTypeId() {
		return AccountTypeId;
	}
	public void setAccountTypeId(String accountTypeId) {
		AccountTypeId = accountTypeId;
	}
	public String getBankBranchId() {
		return BankBranchId;
	}
	public void setBankBranchId(String bankBranchId) {
		BankBranchId = bankBranchId;
	}
	public String getSwiftCode() {
		return SwiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		SwiftCode = swiftCode;
	}
	public String getPayingBranchId() {
		return PayingBranchId;
	}
	public void setPayingBranchId(String payingBranchId) {
		PayingBranchId = payingBranchId;
	}
	public String getPayerId() {
		return PayerId;
	}
	public void setPayerId(String payerId) {
		PayerId = payerId;
	}
	public String getPurposeOfRemittanceId() {
		return PurposeOfRemittanceId;
	}
	public void setPurposeOfRemittanceId(String purposeOfRemittanceId) {
		PurposeOfRemittanceId = purposeOfRemittanceId;
	}
	public String getRate() {
		return Rate;
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	public String getTotalSentAmount() {
		return TotalSentAmount;
	}
	public void setTotalSentAmount(String totalSentAmount) {
		TotalSentAmount = totalSentAmount;
	}
	public String getSentAmount() {
		return SentAmount;
	}
	public void setSentAmount(String sentAmount) {
		SentAmount = sentAmount;
	}
	public String getServiceFee() {
		return ServiceFee;
	}
	public void setServiceFee(String serviceFee) {
		ServiceFee = serviceFee;
	}
	public String getUSDServiceFee() {
		return USDServiceFee;
	}
	public void setUSDServiceFee(String uSDServiceFee) {
		USDServiceFee = uSDServiceFee;
	}
	public String getReceiveAmount() {
		return ReceiveAmount;
	}
	public void setReceiveAmount(String receiveAmount) {
		ReceiveAmount = receiveAmount;
	}
	public String getCashAmount() {
		return CashAmount;
	}
	public void setCashAmount(String cashAmount) {
		CashAmount = cashAmount;
	}
	public String getPayout() {
		return Payout;
	}
	public void setPayout(String payout) {
		Payout = payout;
	}
	public String getApprovalCode() {
		return ApprovalCode;
	}
	public void setApprovalCode(String approvalCode) {
		ApprovalCode = approvalCode;
	}
	public String getFormOfPaymentId() {
		return FormOfPaymentId;
	}
	public void setFormOfPaymentId(String formOfPaymentId) {
		FormOfPaymentId = formOfPaymentId;
	}
	public String getSourceCurrencyIsoCode() {
		return SourceCurrencyIsoCode;
	}
	public void setSourceCurrencyIsoCode(String sourceCurrencyIsoCode) {
		SourceCurrencyIsoCode = sourceCurrencyIsoCode;
	}

	
   
}
