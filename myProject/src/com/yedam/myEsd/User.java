package com.yedam.myEsd;

import java.time.LocalDate;

public class User {
	private String userId;
	private String password;
	private String userName;
	private String userStatus; // normal / VIP / dormant(휴면) / banned 
	private String registrationDate;
	private int money;
	
	public User() {}
	public User(String userId, String password, String userName) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userStatus = "normal";
		this.registrationDate = (LocalDate.now()).toString();
	}
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
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money < 0) {
			System.out.println("입력 금액을 다시 확인하세요");
		} else if (money >= 0) {
			this.money = money;			
		}
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
		if(userStatus.equals("normal") || userStatus.equals("VIP") //
				|| userStatus.equals("dormant") || userStatus.equals("banned")) {
			this.userStatus = userStatus;
		}
		else if(!(userStatus.equals("normal") || userStatus.equals("VIP") //
		|| userStatus.equals("dormant") || userStatus.equals("banned"))) {
			System.out.println("회원의 상태는 normal, VIP, dormant, banned 4개 중 하나로 입력해주세요");
		}
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String showList() {
		String show = String.format("%-10s | %-10s | %-10s | %-20s | %-15s | %-10d"
				, userId, password, userName, userStatus, registrationDate, money);
		return show;
    } //end of showList()
	
	public String showAllInfo() {
		String show = String.format("%-20s %-20s | %-20s %-20s\n"
				+ "%-20s %-20s | %-20s %-20s\n"
				+ "%-20s %-20d\n", 
				
				"ID : ", userId, "Name : ", userName,
				"Status : ", userStatus, "registrationDate : ", registrationDate,
				"money : ", money);
		return show;
	}
} // end of Class