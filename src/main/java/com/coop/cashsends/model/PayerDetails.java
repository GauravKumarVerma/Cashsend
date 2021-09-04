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
import com.coop.cashsends.dto.PayerDetailsDto;

@Entity
@Table(name = "payer_details")
@EntityListeners(AuditingEntityListener.class)
public class PayerDetails extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	@Column(name = "payer_ref_id")
    private Integer PayerRefId;	
	@Column(name = "payer_id")
    private String PayerId;
	@Column(name = "payer_name")
    private String PayerName;
	@Column(name = "branch_id")
    private String BranchId;
	@Column(name = "branch_name")
    private String BranchName;
	@Column(name = "branch_address")
    private String BranchAddress;
	@Column(name = "is_anywhere")
    private boolean IsAnywhere;
	@Column(name = "is_default_location")
    private boolean IsDefaultLocation;
	@Column(name = "customer_rate")
    private Integer CustomerRate;
	@Column(name = "branch_level_rate")
    private Integer BranchLevelRate;
	@Column(name = "is_old_player")
    private boolean IsOldPayer;
	@Column(name = "status")
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
	public PayerDetailsDto toPayerDetailsDto() {
		PayerDetailsDto payerDetailsDto = null;	
		payerDetailsDto = new PayerDetailsDto();
		payerDetailsDto.setBranchAddress(this.BranchAddress);
		payerDetailsDto.setBranchId(this.BranchId);
		payerDetailsDto.setBranchLevelRate(this.BranchLevelRate);
		payerDetailsDto.setBranchName(this.BranchName);
		payerDetailsDto.setCustomerRate(this.CustomerRate);
		payerDetailsDto.setId(this.id);
		payerDetailsDto.setIsAnywhere(this.IsAnywhere);
		payerDetailsDto.setIsDefaultLocation(this.IsDefaultLocation);
		payerDetailsDto.setIsOldPayer(this.IsOldPayer);
		payerDetailsDto.setPayerId(this.PayerId);
		payerDetailsDto.setPayerName(this.PayerName);
		payerDetailsDto.setPayerRefId(this.PayerRefId);
		payerDetailsDto.setStatus(this.status);
		return payerDetailsDto;
		
	}
	

}
