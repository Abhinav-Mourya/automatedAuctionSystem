package com.auction.model;

import java.sql.Date;

public class DisputeBuyerToSellerWithTeamAndCategoryNameDTO {

	
	private int disputeId;
	private int buyerId;
	private String disputeDetails;
	private Date disputeDate;
	private int sellerId;
	private Date solutionDate;
	private boolean IsSolve;
	private String categoryName;
	private String disputeTeamName;
	
	
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
	public String getDisputeDetails() {
		return disputeDetails;
	}
	public void setDisputeDetails(String disputeDetails) {
		this.disputeDetails = disputeDetails;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDisputeTeamName() {
		return disputeTeamName;
	}
	public void setDisputeTeamName(String disputeTeamName) {
		this.disputeTeamName = disputeTeamName;
	}
	
	
	@Override
	public String toString() {
		return "DisputeBuyerToSellerWithTeamAndCategoryNameDTO [disputeId=" + disputeId + ", buyerId=" + buyerId
				+ ", disputeDetails=" + disputeDetails + ", disputeDate=" + disputeDate + ", sellerId=" + sellerId
				+ ", solutionDate=" + solutionDate + ", IsSolve=" + IsSolve + ", categoryName=" + categoryName
				+ ", disputeTEamName=" + disputeTeamName + "]";
	}
	
	
	
	
}
