package com.auction.model;

public class AuctionTable {
	
	private int auctionId;
	private int buyerId;
	private int auctionPrice;
	
	
	
	public AuctionTable(int auctionId, int buyerId, int auctionPrice) {
		super();
		this.auctionId = auctionId;
		this.buyerId = buyerId;
		this.auctionPrice = auctionPrice;
	}



	public int getAuctionId() {
		return auctionId;
	}



	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}



	public int getBuyerId() {
		return buyerId;
	}



	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}



	public int getAuctionPrice() {
		return auctionPrice;
	}



	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}



	@Override
	public String toString() {
		return "AuctionTable [auctionId=" + auctionId + ", buyerId=" + buyerId + ", auctionPrice=" + auctionPrice + "]";
	}

	
	
}
