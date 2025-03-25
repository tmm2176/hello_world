package com.yedam.myEsd;

public class Game {
	private String gameCode; 
	private String gameName;
	private String gameTag;
	private String gameInfo; // 간단한 소개
	private String developer; // 개발사
	private String distributor; // 유통사
	private String registration; // 등록일
	private int price;
	private int discount; // 할인
	private int score; // 게임 평점
	
	public Game() {}
	public Game(String gameCode, String gameName, String gameTag, 
			String gameInfo, String developer, String distributor,
			String registration, int price, int score) {
		this.gameCode = gameCode;
		this.gameName = gameName;
		this.gameTag = gameTag;
		this.gameInfo = gameInfo;
		this.developer = developer;
		this.distributor = distributor;
		this.registration = registration;
		this.price = price;
		this.discount = 0;
		this.score = score;
	}  // end of Game

	public String getGameCode() {
		return gameCode;
	}
	public String getGameName() {
		return gameName;
	}
	public String getGameTag() {
		return gameTag;
	}
	public String getGameInfo() {
		return gameInfo;
	}
	public String getDeveloper() {
		return developer;
	}
	public String getDistributor() {
		return distributor;
	}
	public String getRegistration() {
		return registration;
	}
	public int getPrice() {
		return price;
	}
	public int getDiscount() {
		return discount;
	}
	public int getScore() {
		return score;
	}
	
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public void setGameTag(String gameTag) {
		this.gameTag = gameTag;
	}
	public void setGameInfo(String gameInfo) {
		this.gameInfo = gameInfo;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public void setPrice(int price) {
		if(price > 0) {
			this.price = price;			
		} else {
			System.out.println("입력된 가격 다시 확인 필요");
		}
	}
	public void setDiscount(int discount) {
		if(discount >= 0 && discount <= 100) {
			this.discount = discount;		
		} else {
			System.out.println("입력된 할인률 다시 확인 필요");
		}
	}
	public void setScore(int score) {
		if(score >= 0 && score <= 10) {
			this.score = score;		
		} else {
			System.out.println("입력된 평점 다시 확인 필요");
		}
	}
	// 간단한 소개
	public String showList() {
		String show = String.format("%-30s | %-15s | %-7d | %-3d", gameName, gameTag, price, score);
		return show;
    } //end of showList()
	// (게임 코드 제외) 모든 정보 반환
	public String showAllInfo() {
//		String show = String.format("%-10s %-10s | %-10s %-10s \n %-10s %-10d | %-10s %-10d \n"
//				+ "%-10s %-10s | %-10s %-10s \n %-10s %-10d \n %-10s %-10s",
//				"게임명 : ", gameName, "태그 : ", gameTag,
//				"현재 적용 할인률 : ", discount, "평점 : ", score,
//				"개발사 : ", developer, "유통사 : ", distributor,
//				"가격 : ", price,
//				"간단한 소개 : " + gameInfo
//				);
		String st = String.format("%-20s %-30s | %-7s %-20s\n%-20s %-30s | %-7s %-20d\n"
				+ "%-20s %-30d | %-7s %-20d\n%-20s %-30s | %-7s %-20s\n"
				+ "%-20s %-30s\n", 
				
				"Name : ", gameName, "Tag : ", gameTag, "Release : ", registration, "Price : ", price,
				"discount(%) : ", discount, "score : ", score, "developer : ", developer, "distriubutor : ", distributor,
				"About This Game : ", gameInfo);
		return st; 
    } //end of showAllInfo()
} // end of class
