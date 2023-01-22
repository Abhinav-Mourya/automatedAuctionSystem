package com.auction.model;

import java.sql.Date;

public class Administrator {
	
	
	private int adminId;
	private String adminFirstName;
	private String adminLastName;
	private String adminEmail;
	private String adminPassword;
	private String adminMobile;
	private Date adminDob;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminFirstName() {
		return adminFirstName;
	}
	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}
	public String getAdminLastName() {
		return adminLastName;
	}
	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public Date getAdminDob() {
		return adminDob;
	}
	public void setAdminDob(Date adminDob) {
		this.adminDob = adminDob;
	}
	
	
	
	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName="
				+ adminLastName + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + ", adminMobile="
				+ adminMobile + ", adminDob=" + adminDob + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
