package com.coop.cashsends.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.WalletHistoryDto;

@Entity
@Table(name = "wallet_history")
@EntityListeners(AuditingEntityListener.class)
public class WalletHistory extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "account_number")
    private String accountnumber;

	@Column(name = "wallet_id")
    private Integer walletid;	
	
	@Column(name = "transaction_amount")
    private float transactionamount;
	
	@Column(name = "current_balance")
    private float currentbalance;
	
	@Column(name = "transaction_status")
    private String transactionstatus;
	
	@Column(name = "transaction_date")
    private LocalDateTime transactiondate;
	
	@Column(name = "transaction_description")
    private String transactiondescription;
	
	@Column(name = "account_code")
    private String accountcode;
	
	@Column(name = "partner_id")
    private Integer partnerid;

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
	
	

	public Integer getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Integer partnerid) {
		this.partnerid = partnerid;
	}

	public WalletHistoryDto toWalletHistoryDto() {
	WalletHistoryDto walletHistoryDto =null;
	walletHistoryDto = new WalletHistoryDto();
	walletHistoryDto.setAccountnumber(this.accountnumber);
	walletHistoryDto.setCurrentbalance(this.currentbalance);
	walletHistoryDto.setId(this.id);
	walletHistoryDto.setTransactionamount(this.transactionamount);
	walletHistoryDto.setTransactiondate(this.transactiondate);
	walletHistoryDto.setTransactiondescription(this.transactiondescription);
	walletHistoryDto.setTransactionstatus(this.transactionstatus);
	walletHistoryDto.setWalletid(this.walletid);
	walletHistoryDto.setAccountcode(this.accountcode);
	walletHistoryDto.setPartnerid(this.partnerid);
	walletHistoryDto.setUpdateddate(this.updated_date);
	return walletHistoryDto;
		
	}
	
	
	
	
}
