package com.auction.model;

import java.sql.Date;

public class DisputeSellerToAppWithTeamNameDto {
	
	private int disputeId;
	private int sellerId;
	private int categoryId;
	private String disputeDetails;
	private Date disputeDate;
	private Date solutionDate;
	private boolean IsSolve;
	private String disputeTeamName;
	
	
	
	public DisputeSellerToAppWithTeamNameDto() {
	
	}
	
	
	
	public DisputeSellerToAppWithTeamNameDto(int disputeId, int sellerId, int categoryId, String disputeDetails,
			Date disputeDate, Date solutionDate, boolean isSolve, String disputeTeamName) {
		super();
		this.disputeId = disputeId;
		this.sellerId = sellerId;
		this.categoryId = categoryId;
		this.disputeDetails = disputeDetails;
		this.disputeDate = disputeDate;
		this.solutionDate = solutionDate;
		IsSolve = isSolve;
		this.disputeTeamName = disputeTeamName;
	}




	public int getDisputeId() {
		return disputeId;
	}



	public void setDisputeId(int disputeId) {
		this.disputeId = disputeId;
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



	public String getDisputeTeamName() {
		return disputeTeamName;
	}



	public void setDisputeTeamName(String disputeTeamName) {
		this.disputeTeamName = disputeTeamName;
	}



	@Override
	public String toString() {
		return "DisputeSellerToAppWithTeamNameDto [disputeId=" + disputeId + ", sellerId=" + sellerId + ", categoryId="
				+ categoryId + ", disputeDetails=" + disputeDetails + ", disputeDate=" + disputeDate + ", solutionDate="
				+ solutionDate + ", IsSolve=" + IsSolve + ", disputeTeamName=" + disputeTeamName + "]";
	}

	
	
	
	
}
