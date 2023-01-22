package com.auction.model;

import java.sql.Date;

public class Seller {
	
	private int sellerId;
	private String sellerFirstName;
	private String sellerLastName;
	private String sellerEmail;
	private String sellerPassword;
	private String sellerMobile;
	private Date sellerDob;
	
	
	public Seller() {
	
	}

	
	
	public Seller(int sellerId, String sellerFirstName, String sellerLastName, String sellerEmail,
			String sellerPassword, String sellerMobile, Date sellerDob) {
		super();
		this.sellerId = sellerId;
		this.sellerFirstName = sellerFirstName;
		this.sellerLastName = sellerLastName;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
		this.sellerMobile = sellerMobile;
		this.sellerDob = sellerDob;
	}



	public int getSellerId() {
		return sellerId;
	}



	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}



	public String getSellerFirstName() {
		return sellerFirstName;
	}



	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}



	public String getSellerLastName() {
		return sellerLastName;
	}



	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}



	public String getSellerEmail() {
		return sellerEmail;
	}



	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}



	public String getSellerPassword() {
		return sellerPassword;
	}



	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}



	public String getSellerMobile() {
		return sellerMobile;
	}



	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}



	public Date getSellerDob() {
		return sellerDob;
	}



	public void setSellerDob(Date sellerDob) {
		this.sellerDob = sellerDob;
	}



	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerFirstName=" + sellerFirstName + ", sellerLastName="
				+ sellerLastName + ", sellerEmail=" + sellerEmail + ", sellerPassword=" + sellerPassword
				+ ", sellerMobile=" + sellerMobile + ", sellerDob=" + sellerDob + "]";
	}

	
	
	
	
	
	
}
