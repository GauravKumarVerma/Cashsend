package com.coop.cashsends.dto;

public class WalletDto {
	
	private Integer id;	
	private String accountnumber;
	private float walletamount;
	private boolean isactive;
	private String accountcode;
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
	public float getWalletamount() {
		return walletamount;
	}
	public void setWalletamount(float walletamount) {
		this.walletamount = walletamount;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	
	

}
