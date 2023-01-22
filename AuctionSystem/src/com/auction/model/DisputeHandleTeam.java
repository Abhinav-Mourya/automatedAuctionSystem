package com.auction.model;

public class DisputeHandleTeam {
	
	private int disputeTeamId;
	private String disputeTeamName;
	private int categoryId;
	
	public DisputeHandleTeam() {
	
	}	
	
	
	public DisputeHandleTeam(int disputeTeamId, String disputeTeamName, int categoryId) {
		super();
		this.disputeTeamId = disputeTeamId;
		this.disputeTeamName = disputeTeamName;
		this.categoryId = categoryId;
	}


	public int getDisputeTeamId() {
		return disputeTeamId;
	}


	public void setDisputeTeamId(int disputeTeamId) {
		this.disputeTeamId = disputeTeamId;
	}


	public String getDisputeTeamName() {
		return disputeTeamName;
	}


	public void setDisputeTeamName(String disputeTeamName) {
		this.disputeTeamName = disputeTeamName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public String toString() {
		return "DisputeHandleTeam [disputeTeamId=" + disputeTeamId + ", disputeTeamName=" + disputeTeamName
				+ ", categoryId=" + categoryId + "]";
	}
	
	
	
	
	

}
