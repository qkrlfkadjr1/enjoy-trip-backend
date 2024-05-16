package com.enjoytrip.user.dto;

public class UserDto {
	private String userId;
	private String userName;
	private String userPassword;
	private String emailId;
	private String emailDomain;
	private int sidoCode;
	private int gugunCode;
	
	public UserDto() {
	}

	public UserDto(String userId, String userName, String userPassword, String emailId, String emailDomain,
			int sidoCode, int gugunCode) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomian) {
		this.emailDomain = emailDomian;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", emailId=" + emailId + ", emailDomain=" + emailDomain + ", sidoCode=" + sidoCode + ", gugunCode="
				+ gugunCode + "]";
	}
}
