package com.coop.cashsends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;


@Entity
@Table(name = "cashpickup_summary")
@EntityListeners(AuditingEntityListener.class)
public class CashpickupSummary extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;		
    @Column(name = "tfpin")
    private String tfpin;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashpickup_id")
    private CashpickupTransactions cashpickuptransactions;
    
    @Column(name = "origin")
    private String origin;
    @Column(name = "destination")
    private String destination;
    
    @Column(name = "amount_recieved")
    private float amountrecieved;
    @Column(name = "service_fees")
    private float servicefees;
    @Column(name = "tax")
    private float tax;
    @Column(name = "total")
    private float total;
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
	public CashpickupTransactions getCashpickuptransactions() {
		return cashpickuptransactions;
	}
	public void setCashpickuptransactions(CashpickupTransactions cashpickuptransactions) {
		this.cashpickuptransactions = cashpickuptransactions;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public float getAmountrecieved() {
		return amountrecieved;
	}
	public void setAmountrecieved(float amountrecieved) {
		this.amountrecieved = amountrecieved;
	}
	public float getServicefees() {
		return servicefees;
	}
	public void setServicefees(float servicefees) {
		this.servicefees = servicefees;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
    
    

}
