package com.auction.model;

import java.sql.Date;

public class Products {
	
	private int autionID;
	private int sellerId;
	private int categoryId;
	private Date productAddedDate;
	private int sellingPrice;
	private String productName;
	private int productQuantity;
	private String auctionAddress;
	private Date auctionDate;
	private int days;
	public int getAutionID() {
		return autionID;
	}
	public void setAutionID(int autionID) {
		this.autionID = autionID;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getProductAddedDate() {
		return productAddedDate;
	}
	public void setProductAddedDate(Date productAddedDate) {
		this.productAddedDate = productAddedDate;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getAuctionAddress() {
		return auctionAddress;
	}
	public void setAuctionAddress(String auctionAddress) {
		this.auctionAddress = auctionAddress;
	}
	public Date getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Products [autionID=" + autionID + ", sellerId=" + sellerId + ", categoryId=" + categoryId
				+ ", productAddedDate=" + productAddedDate + ", sellingPrice=" + sellingPrice + ", productName="
				+ productName + ", productQuantity=" + productQuantity + ", auctionAddress=" + auctionAddress
				+ ", auctionDate=" + auctionDate + ", days=" + days + "]";
	}
	
	

	
	
}


