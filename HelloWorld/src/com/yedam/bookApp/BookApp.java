package com.yedam.bookApp;

/*
 * 실행클래스(main 메소드)
 */

public class BookApp {
	public static void main(String[] args) {
		/*
		 * 방법 1		
		 */
//		BookMain mainApp1 = new BookMain();
//		BookMain mainApp2 = new BookMain();
//		mainApp.main(args);
		/*
		 * 방법 2 (싱글톤)
		 */
		BookMain mainApp1 = BookMain.getInstance();
		BookMain mainApp2 = BookMain.getInstance();
		
		mainApp1.addFunc(); // 1번 객체에 등록
		mainApp1.listFunc(); // 1번 객체 목록
		
		mainApp2.listFunc(); // 2번 객체 목록
		// 방법 1 사용시, 두 객체가 각각 따로 생성된 것이라 내부 데이터 또한 전부 다름
		// 방법 2 사용시, 두 객체는 같은 것이므로 네부 데이터는 같은 값임
	}
}
