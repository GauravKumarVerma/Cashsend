package com.coop.cashsends.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.coop.cashsends.audit.Auditable;
import com.coop.cashsends.dto.RecieveMoneyTransInfoDto;
import com.coop.cashsends.dto.RecieverTransactionDto;

@Entity
@Table(name = "reciever_transaction")
@EntityListeners(AuditingEntityListener.class)
public class RecieverTransaction extends Auditable<String> {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "tfpin")
    private String tfpin;
	
	@Column(name = "receipt_no")
    private String receiptno;
	
	@Column(name = "transaction_date")
    private LocalDateTime transactiondate;
	
	@Column(name = "sender_name")
    private String sendername;
	
	@Column(name = "reciever_name")
    private String recievername;
	
	@Column(name = "sender_country")
    private String sendercountry;
	
	@Column(name = "reciever_country")
    private String recievercountry;
	
	@Column(name = "amount")
    private float amount;
	
	@Column(name = "transaction_type")
    private String transactiontype;
	
	
	@Column(name = "sender_city")
    private String sendercity;
	
	@Column(name = "sender_state")
    private String senderstate;
	
	@Column(name = "reciever_city")
    private String recievercity;
	
	@Column(name = "reciever_state")
    private String recieverstate;
	
	@Column(name = "reciever_currency")
    private String recievercurrency;
	
	@Column(name = "status")
    private String status;
	
	
	@Column(name = "payer_id")
    private String payerid;
	
	@OneToOne(mappedBy = "recievertransaction", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
     private RecieveMoneyTransInfo recieveMoneytransInfo;

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

	public RecieveMoneyTransInfo getRecieveMoneytransInfo() {
		return recieveMoneytransInfo;
	}

	public void setRecieveMoneytransInfo(RecieveMoneyTransInfo recieveMoneytransInfo) {
		this.recieveMoneytransInfo = recieveMoneytransInfo;
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
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getPayerid() {
		return payerid;
	}

	public void setPayerid(String payerid) {
		this.payerid = payerid;
	}

	public RecieverTransactionDto toRecieverTransactionDto() {
	RecieverTransactionDto recieverTransactionDto =null;
	recieverTransactionDto = new RecieverTransactionDto();
	recieverTransactionDto.setAmount(this.amount);
	recieverTransactionDto.setId(this.id);
	recieverTransactionDto.setReceiptno(this.receiptno);
	recieverTransactionDto.setRecievercountry(this.recievercountry);
	recieverTransactionDto.setRecievername(this.recievername);
	recieverTransactionDto.setSendercountry(this.sendercountry);
	recieverTransactionDto.setSendername(this.sendername);
	recieverTransactionDto.setTfpin(this.tfpin);
	recieverTransactionDto.setTransactiondate(this.transactiondate);
	recieverTransactionDto.setTransactiontype(this.transactiontype);
	recieverTransactionDto.setRecievercity(this.recievercity);
	recieverTransactionDto.setRecievercountry(this.recievercountry);
	recieverTransactionDto.setRecieverstate(this.recieverstate);
	recieverTransactionDto.setSendercity(this.sendercity);
	recieverTransactionDto.setSendercountry(this.sendercountry);
	recieverTransactionDto.setSendername(this.sendername);
	recieverTransactionDto.setSenderstate(this.senderstate);
	recieverTransactionDto.setRecievercurrency(this.recievercurrency);
	recieverTransactionDto.setStatus(this.status);
	RecieveMoneyTransInfo recieveMoneyTransInfo =null;
	recieveMoneyTransInfo  =this.recieveMoneytransInfo;
	RecieveMoneyTransInfoDto recieveMoneyTransInfoDto =null;
	recieveMoneyTransInfoDto = new RecieveMoneyTransInfoDto();
	recieveMoneyTransInfoDto.setAccountnumber(recieveMoneyTransInfo.getAccountnumber());
	recieveMoneyTransInfoDto.setAmount(recieveMoneyTransInfo.getAmount());
	recieveMoneyTransInfoDto.setBankname(recieveMoneyTransInfo.getBankname());
	recieveMoneyTransInfoDto.setExchangerate(recieveMoneyTransInfo.getExchangerate());
	recieveMoneyTransInfoDto.setId(recieveMoneyTransInfo.getId());
	recieveMoneyTransInfoDto.setRecieveraddress(recieveMoneyTransInfo.getRecieveraddress());
	recieveMoneyTransInfoDto.setRecieverhome(recieveMoneyTransInfo.getRecieverhome());
	recieveMoneyTransInfoDto.setRecievermobile(recieveMoneyTransInfo.getRecievermobile());
	recieveMoneyTransInfoDto.setRecievername(recieveMoneyTransInfo.getRecievername());
	recieveMoneyTransInfoDto.setRecieverwork(recieveMoneyTransInfo.getRecieverwork());
	recieveMoneyTransInfoDto.setSenderaddress(recieveMoneyTransInfo.getSenderaddress());
	recieveMoneyTransInfoDto.setSenderhome(recieveMoneyTransInfo.getSenderhome());
	recieveMoneyTransInfoDto.setSendermobile(recieveMoneyTransInfo.getSendermobile());
	recieveMoneyTransInfoDto.setSendername(recieveMoneyTransInfo.getSendername());
	recieveMoneyTransInfoDto.setSenderwork(recieveMoneyTransInfo.getSenderwork());
	recieveMoneyTransInfoDto.setSentamount(recieveMoneyTransInfo.getSentamount());
	recieveMoneyTransInfoDto.setServicefees(recieveMoneyTransInfo.getServicefees());
	recieveMoneyTransInfoDto.setTax(recieveMoneyTransInfo.getTax());
	recieveMoneyTransInfoDto.setTotalamount(recieveMoneyTransInfo.getTotalamount());
	
	recieveMoneyTransInfoDto.setAccounttype(recieveMoneyTransInfo.getAccounttype());
	recieveMoneyTransInfoDto.setPurposeofremittanceid(recieveMoneyTransInfo.getPurposeofremittanceid());
	recieveMoneyTransInfoDto.setCommamountforeign(recieveMoneyTransInfo.getCommamountforeign());
	recieveMoneyTransInfoDto.setCommamountlocal(recieveMoneyTransInfo.getCommamountlocal());
	recieverTransactionDto.setRecieveMoneytransInfo(recieveMoneyTransInfoDto);
	return recieverTransactionDto;
		
	}
	

}
