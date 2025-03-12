package com.yedam.bookApp;

import java.util.Scanner;

import com.yedam.varable.Member;

/*
 * 도서 등록, 수정, 삭제, 목록 기능
 */
public class BookMain {
	// 저장공간
	static Scanner scn = new Scanner(System.in);
	static Book[] bookStore = new Book[100];

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
    // static으로 선언하면 호출할 때 다른 처리를 굳이 해주지 않아도 상관없어짐
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
	
	// 목록 출력
	public static void listFunc() {
		bookSort();
		int seqNo = 1;
//		System.out.println("순번      |도서명          |저자           |가격    ");
		System.out.println("=================================================================");
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null) {
				System.out.println((seqNo++) + " " + bookStore[i].showList());
				}
		}
		System.out.println();
	} // end of listFunc()
    
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
	
	// 출판사 출력
	public static void searchPub() {
		Book[] pubBookList = new Book[100];
		String bPublisher = "";
        int searchBookCount = 0;
        boolean isExist = false;
        
		System.out.print("출판사 명을 입력하세요>> ");
		bPublisher = scn.nextLine();
		
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null //
					&& bookStore[i].getPublisher().equals(bPublisher)) {
				pubBookList[searchBookCount] = bookStore[i];
				searchBookCount++;
				isExist = true;
			}
		}
		for(int i = 0; i < searchBookCount; i++) {
			if(bookStore[i] != null) {
				pubBookList[i].showBookInfo();				
			}
		}
		if(isExist == false) {
			System.out.println("입력하신 출판사를 찾지 못했습니다.");
		}
	}
    public static void main(String[] args) {
//		test code
//		Book book = new Book("이것이 자바다" ,"신용권" ,"한빛미디어" ,20000 );
//		System.out.println(book.getPrice()); // get 메소드 테스트
//		book.showBookInfo();
		
		// 샘플 데이터
		init();
		boolean run = true;	
		while(run) {
		    System.out.println("\n1. 도서등록 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 상세 조회 | 6. 출판사 조회 | 0. 종료");
		    System.out.print("선택 >> ");
		    int menu = Integer.parseInt(scn.nextLine());
//		    String inputMenu = Integer.parseInt(scn.nextLine());
//		    int menu = 0;
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
			case 0:
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다. 메뉴를 다시 선택하세요");
			}
		}
	    System.out.println("end of prog.");
	} // end of main()
	public static void init() {
		bookStore[0] = new Book("자바" ,"서강중" ,"예담" ,12000, 1);
		bookStore[1] = new Book("파이썬" ,"이름임" ,"예담" ,14000, 2);
		bookStore[2] = new Book("나머지" ,"그냥이름" ,"예담" ,15000, 3);	
	}

}
