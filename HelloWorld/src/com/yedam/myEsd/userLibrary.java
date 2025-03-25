package com.yedam.myEsd;

import java.util.List;

public class userLibrary {
	private String userId;
	private List<Game> library;
	
	public userLibrary() {}

	public String getUserId() {
		return userId;
	}
	public List<Game> getLibrary() {
		return library;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setLibrary(List<Game> library) {
		this.library = library;
	}
	
	public void showUserLibrary() {
		for(Game game : library) {
			System.out.println(game.showList());
		}
	}
	
} // end of class
