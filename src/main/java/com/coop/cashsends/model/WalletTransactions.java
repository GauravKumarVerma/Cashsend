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

@Entity
@Table(name = "wallet_transactions")
@EntityListeners(AuditingEntityListener.class)
public class WalletTransactions {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer id;
	
	@Column(name = "reference_no")
	private String referenceno;
	
	@Column(name = "account_number")
	private String accountnumber;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "transaction_date")
	private LocalDateTime transactiondate;
	
	@Column(name = "transaction_amount")
	private float transactionamount;
	
	@Column(name = "pending_amount")
	private float pendingamount;
	
	@Column(name = "transaction_type")
	private String transactiontype;
	
	@Column(name = "transaction_status")
	private String transactionstatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReferenceno() {
		return referenceno;
	}

	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(LocalDateTime transactiondate) {
		this.transactiondate = transactiondate;
	}

	public float getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(float transactionamount) {
		this.transactionamount = transactionamount;
	}

	public float getPendingamount() {
		return pendingamount;
	}

	public void setPendingamount(float pendingamount) {
		this.pendingamount = pendingamount;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public String getTransactionstatus() {
		return transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}
	
	
	

}
