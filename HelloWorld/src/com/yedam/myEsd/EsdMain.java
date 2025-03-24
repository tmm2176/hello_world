package com.yedam.myEsd;

import java.util.List;
import java.util.Scanner;

/*
 * 
 */
public class EsdMain {
	
	static Scanner scn = new Scanner(System.in); // scn 처리
	static GameJdbc gDao = new GameJdbc();
	static UserJdbc uDao = new UserJdbc();
		
	//로그인 함수
	public static User logInFunc(String id, String pw) {
		return uDao.logInDB(id, pw); // GameJdbc클래스의 logInFunc
	} // end of loginFunc(String id, String pw)
	
	public static List<Game> searchList(String keyword) {
		return gDao.showGameList(keyword);
	} // end of searchList(String keyword)
	
	// 등록
	// 이미 등록된 이름의 책은 입력 불가
	public static void addF() {		
		
		// 수정포인트 (25.03.24)
		String bCode = "";
		String bName = "";
		String bAuthor= "";
		String bPublisher = "";
//			    String inputPrice = "";
		int price = 0;
		
		System.out.println("추가할 책 정보 입력");
		System.out.print("게임 코드>> ");
		bCode = scn.nextLine();
		System.out.print("게임 이름>> ");
		bName = scn.nextLine();
		System.out.print("게임 태그>> ");
		bAuthor = scn.nextLine();
		System.out.print("간단한 소개>> ");
		bPublisher = scn.nextLine();
		System.out.print("개발사>> ");
		bPublisher = scn.nextLine();
		System.out.print("유통사>> ");
		bPublisher = scn.nextLine();
		System.out.print("등록일>> ");
		bPublisher = scn.nextLine();
		
		System.out.print("가격>> ");
		price = Integer.parseInt(scn.nextLine());
		System.out.print("평점>> ");
		price = Integer.parseInt(scn.nextLine());
//		값을 입력하지 않았을 경우 처리할 내용을 추가
		
		Game GameInfo = new Game();
		
		if(gDao.insert(GameInfo)) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	} // end of addFunc()
	
	// 게임관리 함수
	public static void gameManagement() {
		boolean run = true;
		while(run) {
			List<Game> list = searchList("");
			System.out.println("  이름   |   태그   |   가격  |   평점 ");
			System.out.println("=================================================================");
			for(Game game : list) {
				System.out.println(game.showList());
			}
			System.out.println("=================================================================");
			System.out.println("게임등록 : 1 | 게임제거 : 2 | 상세조회 : 3 | 메뉴돌아가기 : 0");
			
			System.out.println();
			
			int menu = 0;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("menu에 맞는 숫자를 입력해주세요\n");
					System.out.print("선택 >> ");
				}				
			} //end of loop
			
			switch(menu) {
			case 1: // 1. 게임등록
				addF();
				break; // case 1 종료	
			case 2: // 2. 게임 제거
//				listF();
				break; // case 2 종료		
			case 3: // 3. 상세조회
				break; // case 3 종료
			case 0: // 0. 메뉴돌아가기
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch
			
			
		} // end of loop
	} // end of gameManagement()

	//관리자모드 실행 함수
	public static void adminF() {
		boolean run = true;
		int menu = 0;
    	//System.out.println("분기 체크");

		while(run) {
			System.out.println("1. 게임관리 2. 사용자관리 3. 문의관리(미구현) 0. 종료");
			System.out.print("선택 >> ");
			
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("menu에 맞는 숫자를 입력해주세요\n");
					System.out.print("선택 >> ");
				}				
			} //end of loop
			
			switch(menu) {
			case 1: // 1. 게임관리
				gameManagement();
				break; // case 1 종료	
			case 2: // 2. 사용자관리
//				listF();
				break; // case 2 종료		
			case 3: // 3. 문의관리(미구현)
				System.out.println("문의관리 미구현");
				break; // case 3 종료
			case 0: // 0. 종료
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch
		} // end of loop 
	} // end of adminF()
    
	// 사용자모드 실행 함수
	public static void userF() {
		boolean run = true;
		int menu = 0;
    	//System.out.println("분기 체크");

		while(run) {
			System.out.println("1. 게임상점 2. 라이브러리 3. 마이페이지 4. 구매내역 5.찜목록 0. 종료");
			System.out.print("선택 >> ");
			
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("menu에 맞는 숫자를 입력해주세요\n");
					System.out.print("선택 >> ");
				}				
			} //end of loop
			
			switch(menu) {
			case 1: // 1. 게임상점
//				addF();
				break; // case 1 종료	
			case 2: // 2. 라이브러리
//				listF();
				break; // case 2 종료		
			case 3: // 3. 마이페이지
//				editF(); 
				break; // case 3 종료
			case 4: // 4. 구매내역
//				deleteF();
				break; // case 4 종료.
			case 5: // 5. 찜목록
//				searchF();
				break; // case 5 종료.
			case 0: // 0. 종료
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch
		} // end of loop 
	} // end of userF()
	
	public static void main(String[] args) {
		//앱을 실행하는 클래스

		String playType = "normal"; //admin, normal, endOfProg 
				
		boolean logIn = true;
		while(logIn) {
    		System.out.print("ID 입력 (stop 입력시 프로그램 종료) >> ");
    		String inputId = scn.nextLine();
    		if(inputId.equals("stop")) {
    			playType = "endOfProg";
    			break;
    		} 
    		System.out.print("PW 입력 >> ");
    		String inputPw = scn.nextLine();    		
    		
    		if (inputId.equals("admin") && inputPw.equals("admin")) {
    			System.out.println("관리자 모드 접속\n");		
    			playType = "admin";
    			break;
    		} else if (inputId.equals("admin") && !(inputPw.equals("admin"))) {
    			System.out.println("관리자 모드 접속 실패, 다시 로그인해주세요\n");		
    			continue;
    		}
//    		System.out.println(inputId + ", " + inputPw);
    		// 250320 로그인 기능 JDBC 연동
    		// User Class or Map 컬렉션
    		User user = logInFunc(inputId, inputPw);
    		if(user != null) {
    			System.out.println("로그인 성공\nHi, " + user.getUserName() + "\n");
    			logIn = false;
    		} // end of if
    		else if(user == null) {
    			System.out.println("로그인 실패, 아이디와 비밀번호를 다시 확인하세요\n");    			
    		}
    	} //end of loop
		
		if(playType.equals("admin")) { // 관리자모드
			adminF();
		} else if (playType.equals("normal")) { // 일반사용자
			userF();
		} else if (playType.equals("endOfProg")) { // 프로그램종료
			System.out.println("프로그램을 종료합니다");
		}
		System.out.println("end of prog");
	} // end of main()
}
	
