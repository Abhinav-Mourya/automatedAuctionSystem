package com.auction.model;

public class Buyer_Item {
	
	private int buyerId;
	private String buyerFirstName;
	private String buyerLastName;
	private int autionID;
	private int sellerId;
	private int categoryId;
	private String productAddedDate;
	private int sellingPrice;
	private String productName;
	private int productQuantity;
	private String auctionAddress;
	private String auctionDate;
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
	public String getProductAddedDate() {
		return productAddedDate;
	}
	public void setProductAddedDate(String productAddedDate) {
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
	public String getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(String auctionDate) {
		this.auctionDate = auctionDate;
	}
	@Override
	public String toString() {
		return "Buyer_Item [buyerId=" + buyerId + ", buyerFirstName=" + buyerFirstName + ", buyerLastName="
				+ buyerLastName + ", autionID=" + autionID + ", sellerId=" + sellerId + ", categoryId=" + categoryId
				+ ", productAddedDate=" + productAddedDate + ", sellingPrice=" + sellingPrice + ", productName="
				+ productName + ", productQuantity=" + productQuantity + ", auctionAddress=" + auctionAddress
				+ ", auctionDate=" + auctionDate + "]";
	}

	

}
