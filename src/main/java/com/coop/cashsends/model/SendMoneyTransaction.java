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
import com.coop.cashsends.dto.ItransactionDto;
import com.coop.cashsends.dto.RecieverDto;
import com.coop.cashsends.dto.SendMoneyTransactionDto;
import com.coop.cashsends.dto.SenderDto;


@Entity
@Table(name = "sendmoney_transaction")
@EntityListeners(AuditingEntityListener.class)
public class SendMoneyTransaction extends Auditable<String> {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
	@Column(name = "status_name")
    private String statusname;
	@Column(name = "status_id")
    private String statusid;
	@Column(name = "tfpin")
    private String tfpin;
	@Column(name = "transaction_date")
    private LocalDateTime transactiondate;
	@Column(name = "can_be_cancelled")
    private boolean canbecancelled;
	@Column(name = "requires_pre_aml")
    private boolean requirespreaml;
	@Column(name = "requires_post_aml")
    private boolean requirespostaml;
	
	@OneToOne(mappedBy = "sendmoneytransaction", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
     private SenderInfo senderinfo;
	
	@OneToOne(mappedBy = "sendmoneytransaction", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
     private RecieverInfo recieverinfo;
	
	@OneToOne(mappedBy = "sendmoneytransaction", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
     private TransactionInfo transactioninfo;
	
	@Column(name = "teller_name")
    private String tellername;
	
	@Column(name = "transaction_type")
    private String transactiontype;
	
	@Column(name = "cancel_reason_id")
    private String cancelreasonid;
	
	@Column(name = "cancel_reason_name")
    private String cancelreasonname;
	
	@Column(name = "payer_id")
    private String payerid;
	@Column(name = "paying_branch_id")
    private String payingbranchid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}

	public String getTfpin() {
		return tfpin;
	}

	public void setTfpin(String tfpin) {
		this.tfpin = tfpin;
	}

	public LocalDateTime getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(LocalDateTime transactiondate) {
		this.transactiondate = transactiondate;
	}

	

	public boolean isCanbecancelled() {
		return canbecancelled;
	}

	public void setCanbecancelled(boolean canbecancelled) {
		this.canbecancelled = canbecancelled;
	}

	public boolean isRequirespreaml() {
		return requirespreaml;
	}

	public void setRequirespreaml(boolean requirespreaml) {
		this.requirespreaml = requirespreaml;
	}

	public boolean isRequirespostaml() {
		return requirespostaml;
	}

	public void setRequirespostaml(boolean requirespostaml) {
		this.requirespostaml = requirespostaml;
	}

	public SenderInfo getSenderinfo() {
		return senderinfo;
	}

	public void setSenderinfo(SenderInfo senderinfo) {
		this.senderinfo = senderinfo;
	}

	public RecieverInfo getRecieverinfo() {
		return recieverinfo;
	}

	public void setRecieverinfo(RecieverInfo recieverinfo) {
		this.recieverinfo = recieverinfo;
	}

	public TransactionInfo getTransactioninfo() {
		return transactioninfo;
	}

	public void setTransactioninfo(TransactionInfo transactioninfo) {
		this.transactioninfo = transactioninfo;
	}
	
	
	
	
	public String getCancelreasonid() {
		return cancelreasonid;
	}

	public void setCancelreasonid(String cancelreasonid) {
		this.cancelreasonid = cancelreasonid;
	}

	public String getTellername() {
		return tellername;
	}

	public void setTellername(String tellername) {
		this.tellername = tellername;
	}
	
	

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	
	

	public String getPayerid() {
		return payerid;
	}

	public void setPayerid(String payerid) {
		this.payerid = payerid;
	}

	public String getPayingbranchid() {
		return payingbranchid;
	}

	public void setPayingbranchid(String payingbranchid) {
		this.payingbranchid = payingbranchid;
	}
	
	

	public String getCancelreasonname() {
		return cancelreasonname;
	}

	public void setCancelreasonname(String cancelreasonname) {
		this.cancelreasonname = cancelreasonname;
	}

	public SendMoneyTransactionDto toSendMoneyTransactionDto() {
		SendMoneyTransactionDto  sendMoneyTransactionDto =null;
		sendMoneyTransactionDto = new SendMoneyTransactionDto();
		sendMoneyTransactionDto.setCanbecancelled(this.canbecancelled);
		sendMoneyTransactionDto.setId(this.id);
		sendMoneyTransactionDto.setRequirespostaml(this.requirespostaml);
		sendMoneyTransactionDto.setRequirespreaml(this.requirespreaml);
		sendMoneyTransactionDto.setStatusid(this.statusid);
		sendMoneyTransactionDto.setStatusname(this.statusname);
		sendMoneyTransactionDto.setTfpin(this.tfpin);
		sendMoneyTransactionDto.setTransactiondate(this.transactiondate);
		sendMoneyTransactionDto.setTellername(this.tellername);
		sendMoneyTransactionDto.setTransactiontype(this.transactiontype);
		sendMoneyTransactionDto.setCancelreasonid(this.cancelreasonid);
		sendMoneyTransactionDto.setPayerid(this.payerid);
		sendMoneyTransactionDto.setPayingbranchid(this.payingbranchid);
		sendMoneyTransactionDto.setUpdatedate(this.updated_date);
		sendMoneyTransactionDto.setCancelreasonname(this.cancelreasonname);
		SenderInfo senderinfo =null;
		senderinfo = this.senderinfo;
		SenderDto senderDto =null;
		senderDto = new SenderDto();
		
		senderDto.setAddress(senderinfo.getAddress());
		senderDto.setCityid(senderinfo.getCityid());
		senderDto.setCityname(senderinfo.getCityname());
		senderDto.setCountrycode(senderinfo.getCountrycode());
		senderDto.setCountryname(senderinfo.getCountryname());
		senderDto.setDateofbirth(senderinfo.getDateofbirth());
		senderDto.setEmail(senderinfo.getEmail());
		senderDto.setId(senderinfo.getId());
		senderDto.setIdexpirydate(senderinfo.getIdexpirydate());
		senderDto.setIdnumber(senderinfo.getIdnumber());
		senderDto.setIssindividual(senderinfo.isIssindividual());
		senderDto.setLoyaltycardnumber(senderinfo.getLoyaltycardnumber());
		senderDto.setName(senderinfo.getName());
		senderDto.setPhonehome(senderinfo.getPhonehome());
		senderDto.setPhonemobile(senderinfo.getPhonemobile());
		senderDto.setPhonework(senderinfo.getPhonework());
		senderDto.setSenderid(senderinfo.getSenderid());
		senderDto.setStateid(senderinfo.getStateid());
		senderDto.setTypeofid(senderinfo.getTypeofid());
		senderDto.setZipcode(senderinfo.getZipcode());
		senderDto.setStatename(senderinfo.getStatename());
		sendMoneyTransactionDto.setSender(senderDto);
		
		RecieverInfo RecieverInfo =null;
		RecieverInfo = this.recieverinfo;
		RecieverDto recieverDto =null;
		recieverDto = new RecieverDto();
		recieverDto.setCityid(RecieverInfo.getCityid());
		recieverDto.setCityname(RecieverInfo.getCityname());
		recieverDto.setCompleteaddress(RecieverInfo.getCompleteaddress());
		recieverDto.setCountrycode(RecieverInfo.getCountrycode());
		recieverDto.setCountryname(RecieverInfo.getCountryname());
		recieverDto.setDateofbirth(RecieverInfo.getDateofbirth());
		recieverDto.setEmail(RecieverInfo.getEmail());
		recieverDto.setFirstname(RecieverInfo.getFirstname());
		recieverDto.setFullname(RecieverInfo.getFullname());
		recieverDto.setHomephone(RecieverInfo.getHomephone());
		recieverDto.setId(RecieverInfo.getId());
		recieverDto.setIsindividual(RecieverInfo.isIsindividual());
		recieverDto.setLastname(RecieverInfo.getLastname());
		recieverDto.setMobilephone(RecieverInfo.getMobilephone());
		recieverDto.setRecieverid(RecieverInfo.getRecieverid());
		recieverDto.setSecondname(RecieverInfo.getSecondname());
		recieverDto.setStateid(RecieverInfo.getStateid());
		recieverDto.setStatename(RecieverInfo.getStatename());
		recieverDto.setTfpin(RecieverInfo.getTfpin());
		recieverDto.setWorkphone(RecieverInfo.getWorkphone());
		recieverDto.setNationalityisocode(RecieverInfo.getNationalityisocode());
		recieverDto.setTownid(RecieverInfo.getTownid());
		recieverDto.setZipcode(RecieverInfo.getZipcode());
		recieverDto.setTownname(RecieverInfo.getTownname());
		sendMoneyTransactionDto.setReceiver(recieverDto);
		
		TransactionInfo transctionInfo =null;
		transctionInfo = this.transactioninfo;
		ItransactionDto  itransactionDto =null;
		itransactionDto = new ItransactionDto();
		itransactionDto.setAccounttypeid(transctionInfo.getAccounttypeid());
		itransactionDto.setAccounttypename(transctionInfo.getAccounttypename());
		itransactionDto.setApprovalcode(transctionInfo.getApprovalcode());
		itransactionDto.setBackendfee(transctionInfo.getBackendfee());
		itransactionDto.setBankbranchid(transctionInfo.getBankbranchid());
		itransactionDto.setCashamount(transctionInfo.getCashamount());
		itransactionDto.setCashiername(transctionInfo.getCashiername());
		itransactionDto.setCreditamount(transctionInfo.getCreditamount());
		itransactionDto.setFeerate(transctionInfo.getFeerate());
		itransactionDto.setFormofpaymentname(transctionInfo.getFormofpaymentname());
		itransactionDto.setFormofpaymentid(transctionInfo.getFormofpaymentid());
		itransactionDto.setHandlingamount(transctionInfo.getHandlingamount());
		itransactionDto.setId(transctionInfo.getId());
		itransactionDto.setPayerbranchaddress(transctionInfo.getPayerbranchaddress());
		itransactionDto.setPayerbranchphone1(transctionInfo.getPayerbranchphone1());
		itransactionDto.setPayerbranchphone2(transctionInfo.getPayerbranchphone2());
		itransactionDto.setPayerid(transctionInfo.getPayerid());
		itransactionDto.setPayername(transctionInfo.getPayername());
		itransactionDto.setPayingbranchid(transctionInfo.getPayingbranchid());
		itransactionDto.setPayingbranchname(transctionInfo.getPayingbranchname());
		itransactionDto.setPaymentmodeid(transctionInfo.getPaymentmodeid());
		itransactionDto.setPaymentmodename(transctionInfo.getPaymentmodename());
		itransactionDto.setPayout(transctionInfo.getPayout());
		itransactionDto.setProductname(transctionInfo.getProductname());
		itransactionDto.setRate(transctionInfo.getRate());
		itransactionDto.setRecieveamount(transctionInfo.getRecieveamount());
		itransactionDto.setRecievercurrencycode(transctionInfo.getRecievercurrencycode());
		itransactionDto.setSentamount(transctionInfo.getSentamount());
		itransactionDto.setServicefees(transctionInfo.getServicefees());
		itransactionDto.setSettlementrate(transctionInfo.getSettlementrate());
		itransactionDto.setSourcecurrencycode(transctionInfo.getSourcecurrencycode());
		itransactionDto.setSourcecurrencyname(transctionInfo.getSourcecurrencyname());
		itransactionDto.setSourceoffund(transctionInfo.getSourceoffund());
		itransactionDto.setTax(transctionInfo.getTax());
		itransactionDto.setTfpin(transctionInfo.getTfpin());
		itransactionDto.setTotalsentamount(transctionInfo.getTotalsentamount());
		itransactionDto.setBankname(transctionInfo.getBankname());
		sendMoneyTransactionDto.setTransactioninfo(itransactionDto);
	    return sendMoneyTransactionDto;	
	}
	

}
