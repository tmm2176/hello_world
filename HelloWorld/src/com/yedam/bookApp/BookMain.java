package com.yedam.bookApp;

import java.util.List;
import java.util.Scanner;

/*
 * 도서 등록, 수정, 삭제, 목록 기능
 */
public class BookMain {
	// 싱글톤
 	// 2. 정적필드 할당
 	private static BookMain instance = new BookMain();
 	
 	// 1. 생성자 private 선언
 	private BookMain() {}
 	// 3. getInstance() 제공
 	
 	public static BookMain getInstance() {
 		return instance;
 	}
	
 	Book[] bookStore = new Book[100];
 	User[] userList = new User[50];
 	
	public void initUser() {
		userList[0] = new User("user1" ,"서강중" ,"q1234");
		userList[1] = new User("user2" ,"이호원" ,"q3456");
		userList[2] = new User("user3", "이름임", "q4567");
	}
//	public static void initBookStore() {
//		bookStore[0] = new Book("자바" ,"서강중" ,"예담" ,12000, 1);
//		bookStore[1] = new Book("파이썬" ,"이름임" ,"예담" ,14000, 2);
//		bookStore[2] = new Book("리눅스", "우분투", "추가", 30000, 3);
//		bookStore[3] = new Book("나머지" ,"그냥이름" ,"예담" ,15000, 4);
//		bookStore[4] = new Book("C++" ,"름이이" ,"추가" ,15000, 5);	
//		bookStore[5] = new Book("C#" ,"사람아님" ,"기타" ,15000, 6);	
//	}
	// 저장공간
 	Scanner scn = new Scanner(System.in);
	BookJdbc dao = new BookJdbc(); //
 	
	// 순번 생성
//	public int getSequnceNo() {
//		 int maxValue = 0;
//		 for(int i = 0 ; i < bookStore.length; i++) {
//			 if(bookStore[i] != null && maxValue < bookStore[i].getOrderNo()) {
//				maxValue = bookStore[i].getOrderNo();
//			 }
//		 }
//		 return (maxValue + 1);
//	}
//	public void bookSort() {
//		for(int i = 0; i < bookStore.length - 1; i++) {
//			for(int j = 0; j < bookStore.length -1; j++) {
//				if(bookStore[j + 1] == null) {
//					continue;
//				}
//				if(bookStore[j] == null ||
//						bookStore[j].getOrderNo() > bookStore[j+1].getOrderNo() ){
//				    temp = bookStore[j];
//					bookStore[j] = bookStore[j + 1];
//					bookStore[j + 1] = temp;
//				}
//			}
//		}
//		int orderNo = 1;
//		for(int i = 0; i < bookStore.length; i++) {
//			if(bookStore[i] != null) {
//				bookStore[i].setOrderNo(orderNo);
//				orderNo++;
//			}
//		}
//===========================[ 아래쪽은 내가 했던 거]============================
//		 for(int i = 0; i < bookStore.length - 1; i++) {
//			 for(int j = 0; j < bookStore.length - 1; j++){
//				 if(bookStore[j] != null && bookStore[j+1] != null) {
//					 if(bookStore[j].getOrderNo() > bookStore[j+1].getOrderNo()) {
//						 temp = bookStore[j];
//						 bookStore[j] = bookStore[j + 1];
//						 bookStore[j + 1] = temp;
//					 }
//				 }
//				 else if(bookStore[j] == null && bookStore[j+1] != null) {
//					 bookStore[j] = bookStore[j + 1];
//					 bookStore[j] = null;
//				 }
////				 else if() {
////					 
////				 }	 
//			 }
//		 }
//	}
    // static? 으로 선언하면 호출할 때 다른 처리를 굳이 해주지 않아도 상관없어짐
	// 등록
	// 이미 등록된 이름의 책은 입력 불가
	public void addFunc() {		
		String bCode = "";
		String bName = "";
		String bAuthor= "";
		String bPublisher = "";
//			    String inputPrice = "";
		int price = 0;
		Book bookInfo = new Book();
		
		System.out.print("도서코드명>> ");
		bCode = scn.nextLine();
//		for(int i = 0; i < bookStore.length; i++) {
//			if(bookStore[i] != null 
//					&& bookStore[i].getBookName().equals(bName)) {
//				System.out.println("이미 등록된 책 제목입니다.\n");
//				return; // 입력 종료
//			}
//		}
		System.out.print("도서명>> ");
		bName = scn.nextLine();
		System.out.print("저자>> ");
		bAuthor = scn.nextLine();
		System.out.print("출판사>> ");
		bPublisher = scn.nextLine();
		System.out.print("가격>> ");
		price = Integer.parseInt(scn.nextLine());
//		값을 입력하지 않았을 경우 처리할 내용을 추가
		
		bookInfo.setBookInfo(bCode, bName, bAuthor, bPublisher, price);
		
		if(dao.insert(bookInfo)) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	} // end of addFunc()
	
	// 수정
	public void editFunc() {
		String bCode = "";
		String bAuthor= "";
		String bPublisher = "";
	    String inputPrice = "";
//		Book bookInfo = new Book();
			
		System.out.print("수정할 도서코드 입력>> ");
		bCode = scn.nextLine();
		if(bCode.isBlank() == true) { // 책 이름을 입력하지 않은 경우
			System.out.println("도서코드를 입력하세요! 메뉴로 돌아갑니다");
		}
		else if(bCode.isBlank() == false) {
			System.out.print("(수정) 저자>> ");
			bAuthor = scn.nextLine();
			System.out.print("(수정) 출판사>> ");
			bPublisher = scn.nextLine();
			System.out.print("(수정) 가격>> ");
			inputPrice = scn.nextLine();
			
			Book bok = new Book();
			bok.setAuthor(bAuthor);
			bok.setPublisher(bPublisher);
			bok.setPrice(Integer.parseInt(inputPrice));
			
			if(dao.update(bok)) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		}
	} // end of editFunc()
	
	// 삭제
	public void delFunc() {
		String bCode = "";
		
		System.out.print("삭제할 도서코드 입력>> ");
		bCode = scn.nextLine();
		Book bok = new Book();
		bok.setBookCode(bCode);
		
		if (dao.delete(bok)) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
	} // end of delFunc()
	
	// listFunc()과 searchPub에서 사용할 리스트
	public List<Book> searchList(String keyword) {
		return dao.list(keyword);
	} // end of searchList(String keyword)
	
	// 목록 출력
	public void listFunc() {
//		int seqNo = 1;
		List<Book> list = searchList("");
		System.out.println("도서코드|도서명|저자|가격");
		System.out.println("=================================================================");
		for(Book book : list) {
			System.out.println(book.showList());
		}
		System.out.println();
	} // end of listFunc()
    
	// 출판사 출력
	public void searchPub() {
//		Book[] pubBookList = new Book[100];
//		int searchBookCount = 0;
		String bPublisher = "";
        
		System.out.print("출판사 명을 입력하세요 (Enter키는 모든 책 출력) >> ");
		bPublisher = scn.nextLine();
		List<Book> list = searchList(bPublisher);
		
		System.out.println("순번|도서명|저자|가격");
		System.out.println("=================================================================");
		for(Book book : list) {
			System.out.println(book.getOrderNo()+ " " + book.showList());
		}
//		for(int i = 0; i < searchBookCount; i++) {
//			if(bookStore[i] != null) {
//				pubBookList[i].showBookInfo();				
//			}
//		}
		 
	} // end of searchPub()
	
	// 상세 정보
	public void detaileInfo() {
		String bCode = "";
		System.out.print("검색 도서코드명>> ");
		bCode = scn.nextLine();
		dao.selcet(bCode).showBookInfo();
	} // end of detaileInfo()
	
	//로그인 함수
	public boolean logInFunc(String id, String pw) {
		for(int i = 0; i < userList.length; i++) {
			if (userList[i] != null && //
					userList[i].getUserId().equals(id)) {
				if(userList[i] != null && //
						userList[i].getPassword().equals(pw)) {
					return true;
				} // end of if
			} // end of if			
		} // end of for
		return false;
	} // end of loginFunc(String id, String pw)
	
	public boolean logOutFunc() {
		boolean run = true;
		System.out.println("로그아웃 하시겠습니까?");
		while(run) {
			System.out.print("y/n >> ");
			String inputLogout = scn.nextLine();
			if(inputLogout.equals("y") || inputLogout.equals("Y")) {
				System.out.println("로그아웃");
				return true;
			}else if(inputLogout.equals("n") || inputLogout.equals("N")) {
				System.out.println("로그인 상태 유지");
				return false;
			}
			else {
				System.out.println("y 또는 n을 입력해주세요\n");
			} //end of if
		} //end of while
		return false;
	} // end of logoutFunc()
	
	
    // main이 static인 경우, 호출할 메소드 전부 static 이어야 사용 가능
    public void main(String[] args) {
		// 샘플 데이터
    	initUser();   	
    	boolean logIn = true;
    	boolean run = true;
    	int menu = 0;

    	while(logIn) {
    		System.out.print("ID 입력 (stop 입력시 프로그램 종료) >> ");
    		String inputId = scn.nextLine();
    		if(inputId.equals("stop")) {
    			System.out.println("프로그램을 종료합니다");
    			run = false;
    			break;
    		}
    		System.out.print("PW 입력 >> ");
    		String inputPw = scn.nextLine();    		
    		
    		if(logInFunc(inputId, inputPw)) {
    			System.out.println("로그인 성공");
    			logIn = false;
    		}else if(logInFunc(inputId, inputPw) == false) {
    			System.out.println("로그인 실패, 아이디와 비밀번호를 다시 확인하세요\n");
    		}   		
    	}
    	
		while(run) {
			System.out.println("\n1. 도서등록 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 상세 조회 |"
					+ " 6. 출판사 조회 | 7.로그아웃 | 0. 종료");
			System.out.print("선택 >> ");
			
			//예외처리
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				}
				catch (NumberFormatException e) {
					System.out.println("menu에 맞는 숫자를 입력해주세요");
					System.out.print("선택 >> ");
				}				
			}

//		    String inputMenu = Integer.parseInt(scn.nextLine());
//		    if(inputMenu) {}
//		    else if() {}
		    
		    switch(menu) {
			case 1: // 1. 도서등록
				addFunc();
				break; // case 1 종료	
			case 2: // 2. 수정
				editFunc();
				break; // case 2 종료		
			case 3: // 3. 삭제
				delFunc();
				break; // case 3 종료
			case 4: // 4. 목록
				listFunc();
				break; // case 4 종료.
			case 5: // 5. 상세 정보
				detaileInfo();
				break; // case 5 종료.
			case 6: // 6. 출판사 조회
				searchPub();
				break; // case 6 종료
			case 7: // 7. 로그아웃
				if (logOutFunc() == true) {
					run = false;
					break;
				}
				break; // case 7 종료
			case 0: // 0. 종료
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요");
			}
		}
	    System.out.println("end of prog");
	} // end of main()
}
