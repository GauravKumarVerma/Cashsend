package com.coop.cashsends.dto;

public class PayerDetailsDto {

	private Integer id;	
	private Integer PayerRefId;	
	private String PayerId;
	private String PayerName;
	private String BranchId;
	private String BranchName;
	private String BranchAddress;
	private boolean IsAnywhere; 
	private boolean IsDefaultLocation;
	private Integer CustomerRate;
	private Integer BranchLevelRate;
	private boolean IsOldPayer;
	private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPayerRefId() {
		return PayerRefId;
	}
	public void setPayerRefId(Integer payerRefId) {
		PayerRefId = payerRefId;
	}
	public String getPayerId() {
		return PayerId;
	}
	public void setPayerId(String payerId) {
		PayerId = payerId;
	}
	public String getPayerName() {
		return PayerName;
	}
	public void setPayerName(String payerName) {
		PayerName = payerName;
	}
	public String getBranchId() {
		return BranchId;
	}
	public void setBranchId(String branchId) {
		BranchId = branchId;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getBranchAddress() {
		return BranchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		BranchAddress = branchAddress;
	}
	public boolean isIsAnywhere() {
		return IsAnywhere;
	}
	public void setIsAnywhere(boolean isAnywhere) {
		IsAnywhere = isAnywhere;
	}
	public boolean isIsDefaultLocation() {
		return IsDefaultLocation;
	}
	public void setIsDefaultLocation(boolean isDefaultLocation) {
		IsDefaultLocation = isDefaultLocation;
	}
	public Integer getCustomerRate() {
		return CustomerRate;
	}
	public void setCustomerRate(Integer customerRate) {
		CustomerRate = customerRate;
	}
	public Integer getBranchLevelRate() {
		return BranchLevelRate;
	}
	public void setBranchLevelRate(Integer branchLevelRate) {
		BranchLevelRate = branchLevelRate;
	}
	public boolean isIsOldPayer() {
		return IsOldPayer;
	}
	public void setIsOldPayer(boolean isOldPayer) {
		IsOldPayer = isOldPayer;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
