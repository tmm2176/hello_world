package com.yedam.bookApp;

import java.util.Scanner;

import com.yedam.varable.Member;

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
	
	
	// 저장공간
	 static Scanner scn = new Scanner(System.in);
	 static Book[] bookStore = new Book[100];
	 static User[] user = new User[3];
	 
	// 순번 생성
	public static int getSequnceNo() {
		 int maxValue = 0;
		 for(int i = 0 ; i < bookStore.length; i++) {
			 if(bookStore[i] != null && maxValue < bookStore[i].getOrderNo()) {
				maxValue = bookStore[i].getOrderNo();
			 }
		 }
		 return (maxValue + 1);
	}
	public static void bookSort() {
		Book temp = new Book();
		for(int i = 0; i < bookStore.length - 1; i++) {
			for(int j = 0; j < bookStore.length -1; j++) {
				if(bookStore[j + 1] == null) {
					continue;
				}
				if(bookStore[j] == null ||
						bookStore[j].getOrderNo() > bookStore[j+1].getOrderNo() ){
				    temp = bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				}
			}
		}
		int orderNo = 1;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null) {
				bookStore[i].setOrderNo(orderNo);
				orderNo++;
			}
		}
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
	}
    // 으로 선언하면 호출할 때 다른 처리를 굳이 해주지 않아도 상관없어짐
	// 등록
	// 이미 등록된 이름의 책은 입력 불가
	public static void addFunc() {		
		String bName = "";
		String bAuthor= "";
		String bPublisher = "";
//			    String inputPrice = "";
		int price = 0;
		Book bookInfo = new Book();
		
		System.out.print("도서명>> ");
		bName = scn.nextLine();
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null 
					&& bookStore[i].getBookName().equals(bName)) {
				System.out.println("이미 등록된 책 제목입니다.\n");
				return; // 입력 종료
			}
		}
		System.out.print("저자>> ");
		bAuthor = scn.nextLine();
		System.out.print("출판사>> ");
		bPublisher = scn.nextLine();
		System.out.print("가격>> ");
		price = Integer.parseInt(scn.nextLine());
//		값을 입력하지 않았을 경우 처리할 내용을 추가
		
		bookInfo.setBookInfo(bName, bAuthor, bPublisher, price, getSequnceNo());
		
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] == null) {
				bookStore[i] = bookInfo;
				System.out.println("입력완료");
				break; // 빈 값에 새로운 값을 입력한 경우 종료
			}
		}
	} // end of addFunc()
	
	// 수정
	public static void editFunc() {
		String bName = "";
		String bAuthor= "";
		String bPublisher = "";
	    String inputPrice = "";
		int price = 0;
//		Book bookInfo = new Book();
		boolean isExist = true;
			
		System.out.print("수정할 책의 이름입력>> ");
		bName = scn.nextLine();
		if(bName.isBlank() == true) { // 책 이름을 입력하지 않은 경우
			System.out.println("책 이름을 입력하세요! 메뉴로 돌아갑니다");
		}
		else if(bName.isBlank() == false) {
			for(int i = 0; i < bookStore.length; i++) {
				if(bookStore[i] != null && bookStore[i].getBookName().equals(bName)) {
					System.out.print("(수정) 저자>> ");
					bAuthor = scn.nextLine();
					if(bAuthor.isBlank() == true) {
						System.out.println("수정 x");
					}
					else if(bAuthor.isBlank()!= true) {
						bookStore[i].setAuthor(bAuthor);
					}	
					System.out.print("(수정) 출판사>> ");
					bPublisher = scn.nextLine();
					if(bPublisher.isBlank() == true) {
						System.out.println("수정 x");
					}
					else if(bPublisher.isBlank() != true) {
						bookStore[i].setPublisher(bPublisher);
					}
					System.out.print("(수정) 가격>> ");
					inputPrice = scn.nextLine();
					price = Integer.parseInt(inputPrice);
					if(inputPrice.isBlank() == true) {
						System.out.println("수정 x");
					}
					else if(inputPrice.isBlank() != true) {
						bookStore[i].setPrice(price);
					}
					
//				bookStore[i].setPrice(price);
//				System.out.println("반환값 테스트 : " + bookStore[i].getBookName().equals(bName));
//				bookStore[i].setBookInfo(bName, bAuthor, bPublisher, price);
					isExist = false;
					System.out.println("수정완료");
					break;
				}
				else if(bookStore[i] != null && bookStore[i].getBookName().equals(bName) != true) {
					isExist = true;
				}
				if (isExist == false) {
					System.out.println("해당 이름이 목록에 존재하지 않습니다\n");
				}
			}
		}
	} // end of editFunc()
	
	// 삭제
	public static void delFunc() {
		String bName = "";
		boolean isExist = true;
		
		System.out.print("삭제할 이름입력>> ");
		bName = scn.nextLine();
		for (int i = 0; i < bookStore.length; i++) {
//			System.out.println("테스트 " + i +"번째 반복 중" );
			if(bookStore[i] != null && bookStore[i].getBookName().equals(bName)) {
				bookStore[i] = null;
//				bookStore[i].setBookName("delBookData");;
				System.out.println("삭제완료");
				isExist = true;
				break;
			}
			else if(bookStore[i] != null && bookStore[i].getBookName().equals(bName) != true) {
				isExist = false;
			}
		}
		bookSort();
		if (isExist == false) {
			System.out.println("해당 이름이 목록에 존재하지 않습니다");
		}
	} // end of delFunc()
	
	// listFunc()과 searchPub에서 사용할 리스트
	public static Book[] searchList(String keyword) {
		Book[] list = new Book[100];
		int idx = 0;
		for(int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null) {
				if (keyword == null //
						|| bookStore[i].getPublisher().equals(keyword)) {
					list[idx++] = bookStore[i];
				} // end of if				
			} // end of if
		} // end of for
		return list;
	} // end of searchList(String keyword)
	
	// 목록 출력
	public static void listFunc() {
		bookSort();
//		int seqNo = 1;
		Book[] list = searchList(null);
		System.out.println("순번|도서명|저자|가격");
		System.out.println("=================================================================");
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].getOrderNo()+ " " + list[i].showList());
				}
		}
		System.out.println();
	} // end of listFunc()
    
	// 출판사 출력
	public static void searchPub() {
//		Book[] pubBookList = new Book[100];
//		int searchBookCount = 0;
		String bPublisher = "";
        boolean isExist = false;
        Book[] list = searchList(null);
        
		System.out.print("출판사 명을 입력하세요 (Enter키는 모든 책 출력) >> ");
		bPublisher = scn.nextLine();
		
		for(int i = 0; i < list.length; i++) {
			if (list[i] != null //
					&& bPublisher.isBlank()) {
				list[i].showBookInfo();
				isExist = true;
			}
			else if(list[i] != null //
					&& list[i].getPublisher().equals(bPublisher)) {
				list[i].showBookInfo();
//				pubBookList[searchBookCount] = bookStore[i];
//				searchBookCount++;
				isExist = true;
			}
		}
//		for(int i = 0; i < searchBookCount; i++) {
//			if(bookStore[i] != null) {
//				pubBookList[i].showBookInfo();				
//			}
//		}
		if(isExist == false) {
			System.out.println("입력하신 출판사를 찾지 못했습니다.");
		}
	} // end of searchPub()
	
	// 상세 정보
	public static void detaileInfo() {
		boolean isExist = false;
		String bName = "";
		System.out.print("검색 도서명>> ");
		bName = scn.nextLine();
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null //
					&& bookStore[i].getBookName().equals(bName)) {
				bookStore[i].showBookInfo();
				isExist = true;
				return; // 입력 종료
			}
		}
		if(isExist == false) {
			System.out.println("입력하신 책을 찾지 못했습니다.\n");
		}
	} // end of detaileInfo()
	public static boolean loginFunc(String id, String pw) {
		for(int i = 0; i < user.length; i++) {
			if (user[i] != null && //
					user[i].getUserId().equals(id)) {
				if(user[i] != null && //
						user[i].getPassword().equals(pw)) {
					return true;
				} // end of if
			} // end of if			
		} // end of for
		return false;
	} // end of loginFunc(String id, String pw)
	
	public static boolean logOutFunc() {
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
    public static void main(String[] args) {
//		test code
//		Book book = new Book("이것이 자바다" ,"신용권" ,"한빛미디어" ,20000 );
//		System.out.println(book.getPrice()); // get 메소드 테스트
//		book.showBookInfo();
		
		// 샘플 데이터
    	initBookStore();
    	initUser();   	
    	boolean logIn = true;
    	boolean run = true;

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
    		
    		if(loginFunc(inputId, inputPw)) {
    			System.out.println("로그인 성공");
    			logIn = false;
    		}else if(loginFunc(inputId, inputPw) == false) {
    			System.out.println("로그인 실패, 아이디와 비밀번호를 다시 확인하세요\n");
    		}   		
    	}
    	
		while(run) {
			int menu = 0;
			
			System.out.println("\n1. 도서등록 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 상세 조회 |"
					+ " 6. 출판사 조회 | 7.로그아웃 | 0. 종료");
			System.out.print("선택 >> ");
			menu = Integer.parseInt(scn.nextLine());
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
			case 0:
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요");
			}
		}
	    System.out.println("end of prog.");
	} // end of main()
	public static void initUser() {
		user[0] = new User("user1" ,"서강중" ,"q1234");
		user[1] = new User("user2" ,"이호원" ,"q3456");
		user[2] = new User("user3", "이름임", "q4567");
	}
	public static void initBookStore() {
		bookStore[0] = new Book("자바" ,"서강중" ,"예담" ,12000, 1);
		bookStore[1] = new Book("파이썬" ,"이름임" ,"예담" ,14000, 2);
		bookStore[2] = new Book("리눅스", "우분투", "추가", 30000, 3);
		bookStore[3] = new Book("나머지" ,"그냥이름" ,"예담" ,15000, 4);
		bookStore[4] = new Book("C++" ,"름이이" ,"추가" ,15000, 5);	
		bookStore[5] = new Book("C#" ,"사람아님" ,"기타" ,15000, 6);	
	}

}
