package com.auction.model;

import java.sql.Date;

public class DisputeBuyerToSeller {

	private int disputeId;
	private int buyerId;
	private int categoryId;
	private String distputDetails;
	private Date disputeDate;
	private int sellerId;
	private Date solutionDate;
	private boolean IsSolve;
	

	public DisputeBuyerToSeller() {
	
	}
	
	
	
	public DisputeBuyerToSeller(int disputeId, int buyerId, int categoryId, String distputDetails, Date disputeDate,
			int sellerId, Date solutionDate, boolean isSolve) {
		super();
		this.disputeId = disputeId;
		this.buyerId = buyerId;
		this.categoryId = categoryId;
		this.distputDetails = distputDetails;
		this.disputeDate = disputeDate;
		this.sellerId = sellerId;
		this.solutionDate = solutionDate;
		IsSolve = isSolve;
	}



	public int getDisputeId() {
		return disputeId;
	}



	public void setDisputeId(int disputeId) {
		this.disputeId = disputeId;
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



	public String getDistputDetails() {
		return distputDetails;
	}



	public void setDistputDetails(String distputDetails) {
		this.distputDetails = distputDetails;
	}



	public Date getDisputeDate() {
		return disputeDate;
	}



	public void setDisputeDate(Date disputeDate) {
		this.disputeDate = disputeDate;
	}



	public int getSellerId() {
		return sellerId;
	}



	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}



	public Date getSolutionDate() {
		return solutionDate;
	}



	public void setSolutionDate(Date solutionDate) {
		this.solutionDate = solutionDate;
	}



	public boolean isIsSolve() {
		return IsSolve;
	}



	public void setIsSolve(boolean isSolve) {
		IsSolve = isSolve;
	}
	
	
	
	
	
	
	
}
