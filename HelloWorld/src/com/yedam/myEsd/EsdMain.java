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
	
	public static List<Game> gameSearchList(String gameCode) {
		return gDao.showGameList(gameCode);
	} // end of searchList(String keyword)
	
	public static List<User> userSearchList(String userId) {
		return uDao.showUserList(userId);
	} // end of searchList(String keyword)
	
	// 관리자 게임관리 - 등록
	// 이미 등록된 이름의 게임은 입력 불가
	public static void gAddF() {		
		System.out.println("추가할 게임 정보 입력");
		System.out.print("게임 코드>> ");
		String gCode = scn.nextLine();
		System.out.print("게임 이름>> ");
		String gName = scn.nextLine();
		System.out.print("게임 태그>> ");
		String gTag = scn.nextLine();
		System.out.print("간단한 소개>> ");
		String gInfo = scn.nextLine();
		System.out.print("개발사>> ");
		String gDev = scn.nextLine();
		System.out.print("유통사>> ");
		String gDist = scn.nextLine();
		System.out.print("등록일>> ");
		String gRegist = scn.nextLine();
		System.out.print("가격>> ");
		int gPrice = Integer.parseInt(scn.nextLine());
		// 할인률은 기본값 0으로 설정
		System.out.print("평점>> ");
		int gScore = Integer.parseInt(scn.nextLine());
		
		Game gameInfo = new Game(gCode, gName, gTag, gInfo, gDev,
				gDist, gRegist, gPrice, gScore);
		
		if(gDao.insert(gameInfo)) {
			System.out.println("등록성공\n");
		}else {
			System.out.println("등록실패\n");
		}
	} // end of gAddF()
	
	// 관리자 게임관리 - 수정
	public static void gEditF() {			
		System.out.print("수정할 게임의 코드 입력>> ");
		String gCode = scn.nextLine();
		if(gCode.isBlank() == true) { // 책 이름을 입력하지 않은 경우
			System.out.println("게임코드를 입력하세요! 메뉴로 돌아갑니다");
		}
		else if(gCode.isBlank() == false) {
			System.out.print("게임명>> ");
			String inputName = scn.nextLine();
			System.out.print("태그>> ");
			String inputTag = scn.nextLine();
			System.out.print("간단한 소개>> ");
			String inputInfo = scn.nextLine();
			System.out.print("개발사>> ");
			String inputDev = scn.nextLine();
			System.out.print("유통사>> ");
			String inputDist = scn.nextLine();
			System.out.print("등록일>> ");
			String inputRegist = scn.nextLine();
			System.out.print("가격>> ");
			String inputPrice = scn.nextLine();
			System.out.print("할인률>> ");
			String inputDiscount = scn.nextLine();
			System.out.print("평가>> ");
			String inputScore = scn.nextLine();
			
			Game game = new Game();
			game.setGameCode(gCode);
			game.setGameName(inputName);
			game.setGameTag(inputTag);
			game.setGameInfo(inputInfo);
			game.setDeveloper(inputDev);
			game.setDistributor(inputDist);
			game.setRegistration(inputRegist);
			game.setPrice(Integer.parseInt(inputPrice));
			game.setDiscount(Integer.parseInt(inputDiscount));
			game.setScore(Integer.parseInt(inputScore));
			
			if(gDao.update(game)) {
				System.out.println("수정성공\n");
			}else {
				System.out.println("수정실패\n");
			}
		}
	} // end of gEditF()
	
	// 관리자 게임관리 - 삭제
	public static void gDelF() {		
		System.out.print("삭제할 게임의 코드 입력>> ");
		String gCode = scn.nextLine();
		Game game = new Game();
		game.setGameCode(gCode);
		
		if (gDao.delete(game)) {
			System.out.println("삭제성공\n");
		}else {
			System.out.println("삭제실패\n");
		}
	} // end of gDelF()
	
	// 관리자 게임관리 - 하나 상세정보
	public static void gDetaileInfo() {
		System.out.print("검색 게임코드>> ");
		String gCode = scn.nextLine();
		
		if (gameSearchList(gCode) != null) {
			System.out.println("조회성공\n");
//			System.out.println(gameSearchList(gCode).showAllInfo());
			for(Game game : gameSearchList(gCode)) {
				System.out.println(game.showAllInfo());
			}
		}else {
			System.out.println("조회실패\n");
		}		
	} // end of gDetaileInfo()
	
	// 관리자 게임관리 모드
	public static void gameManagement() {
		boolean run = true;
		while(run) {
			List<Game> list = gameSearchList("");
			System.out.println("==============================================================================");
			String colName = String.format("%-30s | %-15s | %-7s | %-3s", "Name", "Tag", "Price", "Score");
			System.out.println(colName);
			System.out.println("==============================================================================");
			for(Game game : list) {
				System.out.println(game.showList());
			}
			System.out.println("==============================================================================");
			System.out.println("게임등록 : 1 | 내용수정 : 2 | 게임제거 : 3 | 상세조회 : 4 | 메뉴돌아가기 : 0");
			System.out.print("메뉴입력>> ");
			
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
				gAddF();
				break; // case 1 종료	
			case 2: // 2. 내용수정
				gEditF();
				break; // case 2 종료		
			case 3: // 3. 게임 제거
				gDelF();
				break; // case 3 종료
			case 4: // 4. 상세조회
				gDetaileInfo();
				break; // case 4 종료
			case 0: // 0. 메뉴돌아가기
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch	
		} // end of loop
	} // end of gameManagement()

	// 관리자 회원관리 - 등록
	// 이미 등록된 이름의 책은 입력 불가
	public static void uAddF() {		
		System.out.println("추가할 유저 정보 입력");
		System.out.print("유저 ID>> ");
		String userId = scn.nextLine();
		System.out.print("유저 PW>> ");
		String userPw = scn.nextLine();
		System.out.print("유저 이름>> ");
		String userName = scn.nextLine();
		// 유저 상태의 기본값 normal
		System.out.print("등록일>> ");
		String registration = scn.nextLine();
		
		
		User userInfo = new User(userId, userPw, userName, "normal", registration);
		
		if(uDao.insert(userInfo)) {
			System.out.println("등록성공\n");
		}else {
			System.out.println("등록실패\n");
		}
	} // end of gAddF()
	
	// 관리자 회원관리 - 수정
	public static void uEditF() {			
		System.out.print("수정할 유저의 ID 입력>> ");
		String uID = scn.nextLine();
		if(uID.isBlank() == true) { // 책 이름을 입력하지 않은 경우
			System.out.println("ID를 입력하세요! 메뉴로 돌아갑니다");
		}
		else if(uID.isBlank() == false) {
			System.out.print("PW>> ");
			String inputPw = scn.nextLine();
			System.out.print("이름>> ");
			String inputName = scn.nextLine();
			System.out.print("상태 (a : normal / b : VIP / c : dormant / d : banned)>> ");
			String inputStatus = scn.nextLine();
			String status = "";
			if(inputStatus.equals("a")) {
				status = "normal";
			} else if(inputStatus.equals("b")) {
				status = "VIP";
			} else if(inputStatus.equals("c")) {
				status = "dormant";
			} else if(inputStatus.equals("d")) {
				status = "banned";
			}
			System.out.print("등록일>> ");
			String inputRegistration = scn.nextLine();

			User user = new User();
			user.setUserId(uID);
			user.setPassword(inputPw);
			user.setUserName(inputName);
			user.setUserStatus(status);
			user.setRegistrationDate(inputRegistration);
			
			if(uDao.update(user)) {
				System.out.println("수정성공\n");
			}else {
				System.out.println("수정실패\n");
			}
		}
	} // end of uEditF()
	
	// 관리자 회원관리 - 삭제
	public static void uDelF() {		
		System.out.print("정보를 삭제할 유저의 ID 입력>> ");
		String uID = scn.nextLine();
		User user = new User();
		user.setUserId(uID);
		
		if (uDao.delete(user)) {
			System.out.println("삭제성공\n");
		}else {
			System.out.println("삭제실패\n");
		}
	} // end of uDelF()
//	
	// 관리자 회원관리 - 한 명 상세정보
	public static void uDetaileInfo() {
		System.out.print("검색 유저ID>> ");
		String uID = scn.nextLine();
		
		if (userSearchList(uID) != null) {
			System.out.println("조회성공");
//			System.out.println(gameSearchList(gCode).showAllInfo());
			for(User user : userSearchList(uID)) {
				System.out.println(user.showList() + "\n");
			}
		}else {
			System.out.println("조회실패\n");
		}		
	} // end of gDetaileInfo()
	
	// 관리자 회원관리 모드
	public static void userManagement() {
		boolean run = true;
		while(run) {
			List<User> list = userSearchList("");
			System.out.println("==============================================================================");
			String colName = String.format("%-10s | %-10s | %-10s | %-20s | %-30s",
					"ID", "PW", "Name", "Status", "Registration Date");
			System.out.println(colName);
			System.out.println("==============================================================================");
			for(User user : list) {
				System.out.println(user.showList());
			}
			System.out.println("==============================================================================");
			System.out.println("사용자등록 : 1 | 정보 수정 : 2 | 사용자 제외 : 3 | 사용자 조회 : 4 | 메뉴돌아가기 : 0");
			System.out.print("메뉴입력>> ");
			
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
			case 1: // 1. 사용자 정보등록
				uAddF();
				break; // case 1 종료	
			case 2: // 2. 사용자 정보수정
				uEditF();
				break; // case 2 종료		
			case 3: // 3. 사용자 제외
				uDelF();
				break; // case 3 종료
			case 4: // 4. 사용자 조회
				uDetaileInfo();
				break; // case 4 종료
			case 0: // 0. 메뉴돌아가기
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch	
		} // end of loop
	} // end of userManagement()
	
	// 관리자모드 실행 함수
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
				userManagement();
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
    

	// 사용자모드 - 게임상점 - 구매페이지
	public static void uBuyGame() {
		
	}
	
	// 사용자모드 - 게임상점 - 검색페이지
    public static void uStoreSearch() {
		
	}
	
	// 사용자모드 - 게임상점 함수
	public static void userGameStore() {
		boolean run = true;
		while(run) {
			List<Game> list = gameSearchList("");
			System.out.println("==============================================================================");
			String colName = String.format("%-30s | %-15s | %-7s | %-3s", "Name", "Tag", "Price", "Score");
			System.out.println(colName);
			System.out.println("==============================================================================");
			for(Game game : list) {
				System.out.println(game.showList());
			}
			System.out.println("==============================================================================");
			System.out.println("게임구매 : 1 | 검색 : 2 | 메뉴돌아가기 : 0");
			System.out.print("메뉴입력>> ");
			
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
			case 1: // 1. 게임구매
				uBuyGame();
				break; // case 1 종료	
			case 2: // 2. 검색
				uStoreSearch();
				break; // case 2 종료		
			case 0: // 0. 메뉴돌아가기
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
			} // end of switch	
		} // end of loop
	} // end of userGameStore()
	
	// 사용자모드 - 라이브러리 함수
	public static void users() {
		System.out.println("구현중");
	} // end of userLibrary()
	
	// 사용자모드 - 마이페이지 함수
	public static void userMyPage() {
		System.out.println("구현중");
	} // end of userMyPage()

	// 사용자모드 - 구매내역 
	public static void userPurchaseList() {
		System.out.println("구현중");
	} // end of userPurchaseList()

	// 사용자모드 - 찜목록
	public static void userWishList() {
		System.out.println("미구현");
	} // end of userWishList()

	// 사용자모드 실행 함수
	public static void userF(User user) {
		boolean run = true;
		int menu = 0;
    	//System.out.println("분기 체크");

        if(user.getUserStatus().equals("dormant")) {
			System.out.println("장기미접속 사용자입니다.");
			System.out.println("휴면상태 해제 후 사용해주세요(미구현)");
		} else if(user.getUserStatus().equals("banned")) {
			System.out.println("제한된 사용자입니다.");
		} else if(user.getUserStatus().equals("normal") || 
				user.getUserStatus().equals("VIP")) { // 제한된 사용자가 아닌 경우
			while(run) {
				System.out.println("1. 게임상점 2. 라이브러리 3. 마이페이지 4. 구매내역 5.찜목록(미구현) 0. 종료");
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
				userGameStore();
					break; // case 1 종료	
				case 2: // 2. 라이브러리
				userLibrary();
					break; // case 2 종료		
				case 3: // 3. 마이페이지
				userMyPage(); 
					break; // case 3 종료
				case 4: // 4. 구매내역
				userPurchaseList();
					break; // case 4 종료.
				case 5: // 5. 찜목록 (미구현)
				userWishList();
					break; // case 5 종료.
				case 0: // 0. 종료
					run = false;
					break;
				default:
					System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요\n");
				} // end of switch
			} // end of loop 	
		} //end of if
	} // end of userF()
	
	public static void main(String[] args) {
		//앱을 실행하는 클래스

		String playType = "normal"; //admin, normal, endOfProg 
				
		boolean logIn = true;
		User user = new User();
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
    		user = logInFunc(inputId, inputPw);
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
			userF(user);
		} else if (playType.equals("endOfProg")) { // 프로그램종료
			System.out.println("프로그램을 종료합니다");
		}
		System.out.println("end of prog");
	} // end of main()
}
	
