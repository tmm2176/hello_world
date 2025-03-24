package com.yedam.myEsd;

public class User {
	private String userId;
	private String password;
	private String userName;
	private String userStatus; // normal / VIP / dormant(휴면) / banned 
	private String registrationDate;
	
	public User(String userId, String password, String userName, String status, String registrationDate) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userStatus = status;
		this.registrationDate = registrationDate;
	}

	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
} // end of Class