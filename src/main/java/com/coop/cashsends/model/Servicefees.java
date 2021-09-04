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
import com.coop.cashsends.dto.ServicefeesDto;

@Entity
@Table(name = "service_fees")
@EntityListeners(AuditingEntityListener.class)
public class Servicefees extends Auditable<String>  {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;	
	
	@Column(name = "partner_type")
	private String partnertype;	
	@Column(name = "service_type")
	private String servicetype;	
	@Column(name = "transaction_type")
	private String transactiontype;
	@Column(name = "payment_mode")
	private String paymentmode;
	@Column(name = "sender_country")
	private String sendercountry;
	@Column(name = "reciever_country")
	private String recievercountry;
	@Column(name = "start_range")
	private float startrange;
	@Column(name = "end_range")
	private float endrange;
	@Column(name = "flat_rate")
	private float flatrate;
	@Column(name = "percentage_value")
	private float percentagevalue;
	@Column(name = "priority")
	private String priority;
	@Column(name = "description")
	private String description;
	@Column(name = "currency_code")
	private String currencycode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPartnertype() {
		return partnertype;
	}
	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
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
	public float getStartrange() {
		return startrange;
	}
	public void setStartrange(float startrange) {
		this.startrange = startrange;
	}
	public float getEndrange() {
		return endrange;
	}
	public void setEndrange(float endrange) {
		this.endrange = endrange;
	}
	public float getFlatrate() {
		return flatrate;
	}
	public void setFlatrate(float flatrate) {
		this.flatrate = flatrate;
	}
	public float getPercentagevalue() {
		return percentagevalue;
	}
	public void setPercentagevalue(float percentagevalue) {
		this.percentagevalue = percentagevalue;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getCurrencycode() {
		return currencycode;
	}
	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}
	public ServicefeesDto tosServicefeesDto() {
		ServicefeesDto servicefeesDto =null;
		servicefeesDto = new ServicefeesDto();
		servicefeesDto.setDescription(this.description);
		servicefeesDto.setEndrange(this.endrange);
		servicefeesDto.setFlatrate(this.flatrate);
		servicefeesDto.setId(this.id);
		servicefeesDto.setPartnertype(this.partnertype);
		servicefeesDto.setPaymentmode(this.paymentmode);
		servicefeesDto.setPercentagevalue(this.percentagevalue);
		servicefeesDto.setPriority(this.priority);
		servicefeesDto.setRecievercountry(this.recievercountry);
		servicefeesDto.setSendercountry(this.sendercountry);
		servicefeesDto.setServicetype(this.servicetype);
		servicefeesDto.setStartrange(this.startrange);
		servicefeesDto.setTransactiontype(this.transactiontype);
		servicefeesDto.setCurrencycode(this.currencycode);
		
		return servicefeesDto;
		
		
	}
	

}
