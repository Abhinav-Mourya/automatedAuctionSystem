package com.auction.model;

import java.sql.Date;

public class Buyer {

	private int buyerId;
	private String buyerFirstName;
	private String buyerLastName;
	private String buyerEmail;
	private String buyerPassword;
	private String buyerMobile;
	private Date buyerDob;
	
	
	
	
	public Buyer() {
		
	}

	
	
	
	
	public Buyer(int buyerId, String buyerFirstName, String buyerLastName, String buyerEmail, String buyerPassword,
			String buyerMobile, Date buyerDob) {
		super();
		this.buyerId = buyerId;
		this.buyerFirstName = buyerFirstName;
		this.buyerLastName = buyerLastName;
		this.buyerEmail = buyerEmail;
		this.buyerPassword = buyerPassword;
		this.buyerMobile = buyerMobile;
		this.buyerDob = buyerDob;
	}



	public int getBuyerId() {
		return buyerId;
	}



	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}



	public String getBuyerFirstName() {
		return buyerFirstName;
	}



	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}



	public String getBuyerLastName() {
		return buyerLastName;
	}



	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}



	public String getBuyerEmail() {
		return buyerEmail;
	}



	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}



	public String getBuyerPassword() {
		return buyerPassword;
	}



	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}



	public String getBuyerMobile() {
		return buyerMobile;
	}



	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}



	public Date getBuyerDob() {
		return buyerDob;
	}



	public void setBuyerDob(Date buyerDob) {
		this.buyerDob = buyerDob;
	}



	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerFirstName=" + buyerFirstName + ", buyerLastName=" + buyerLastName
				+ ", buyerEmail=" + buyerEmail + ", buyerPassword=" + buyerPassword + ", buyerMobile=" + buyerMobile
				+ ", buyerDob=" + buyerDob + "]";
	}
	
	
	
	
	
	
	
	
}
