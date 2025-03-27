package com.yedam.myEsd;

import java.util.ArrayList;
import java.util.List;

public class UserLibrary {
	private int libNo;
	private String userId;
	private String gameCode;
	
	public UserLibrary() {}
	
	public int getNum() {
		return libNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getgameCode() {
		return gameCode;
	}
	public void setNum(int num) {
		this.libNo = num;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	
	// 유저 ID를 입력받아 해당 유저가 가진 게임의 코드를 list에 저장 후 반환
	public List<String> checkUserLibrary(String inputUserID) {
		List<String> list =  new ArrayList<String>();
		if(userId.equals(inputUserID)) {
			list.add(gameCode);
		} //end of if
		return list;
	} // end of showUserLibrary
	
	public String showUserLib() {
		String show = String.format("%-10d %-10d\n%-10d %-10d",
				"user ID : ", userId, "game code", gameCode) ;
		return show;
	}
} // end of class
