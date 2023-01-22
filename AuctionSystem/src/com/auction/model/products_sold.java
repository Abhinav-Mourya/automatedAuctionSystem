package com.auction.model;

import java.sql.Date;

public class products_sold {
	
	private int auctionId;
	private int sellerId;
	private int buyerId;
	private int categoryId;
	private String productName;
	private int productQuantity;
	private Date productAddedDate;
	private int sellingPrice;
	private int auctionPrice;
	private String auctionAddress;
	private Date auctionDate;
	
	
	public products_sold() {
	
	}
	
	
	public products_sold(int auctionId, int sellerId, int buyerId, int categoryId, String productName,
			int productQuantity, Date productAddedDate, int sellingPrice, int auctionPrice, String auctionAddress,
			Date auctionDate) {
		super();
		this.auctionId = auctionId;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productAddedDate = productAddedDate;
		this.sellingPrice = sellingPrice;
		this.auctionPrice = auctionPrice;
		this.auctionAddress = auctionAddress;
		this.auctionDate = auctionDate;
	}


	public int getAuctionId() {
		return auctionId;
	}


	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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


	public int getAuctionPrice() {
		return auctionPrice;
	}


	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
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


	@Override
	public String toString() {
		return "products_sold [auctionId=" + auctionId + ", sellerId=" + sellerId + ", buyerId=" + buyerId
				+ ", categoryId=" + categoryId + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ ", productAddedDate=" + productAddedDate + ", sellingPrice=" + sellingPrice + ", auctionPrice="
				+ auctionPrice + ", auctionAddress=" + auctionAddress + ", auctionDate=" + auctionDate + "]";
	}
	
	
	
	

}
