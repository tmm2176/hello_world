package com.yedam.bookApp;

public class Book {
/*
 * 필요 정보 : 도서제목, 저자, 출판사, 가격
 */
	// 필드
	private String bookName;
	private String author;
	private String publisher;
	private int price;
	private int orderNo; // 도서가 등록될 때 마다 번호를 부여
	// 클래스 : 생성자(실체생성)
	// 컴파일러 기본생성자 생성 / 기본생성자 -> 매개값이 없는 생성자
	// 생성자는 반환 type이 없음
	// 같은 이름의 생성자를 여러개 만드는 것 -> overloading
	// 기본생성자가 없어도 컴파일러가 따로 처리해주지만
	// 기본생성자 외의 다른 생성자를 만든 경우 기본생성자를 꼭 추가해줘야함
	public Book() {}
	// 생성자 -> 기본생성자와 달리 값을 바로 입력가능하게 만든 생성자
	public Book(String bookName, String author, String publisher, int price) {
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	public Book(String bookName, String author, String publisher, int price, int orderNo) {
//		this.bookName = bookName;
//		this.author = author;
//		this.publisher = publisher;
//		this.price = price;
		this(bookName, author, publisher, price); //this 생성된 인스턴스
		this.orderNo = orderNo;
	}
	// 메소드
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPrice() {
		return price;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPrice(int price) {
		if(price < 0) {
			System.out.println("적정값을 입력하세요");
			return; // 메소드 종료
		}
		this.price = price;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String showList() {
			String show = "도서명 : " + bookName + " | 저자 : " + author + " | 가격 : " + price;			
			return show;
	}
	public String showListWithNo() {
			String show = orderNo + " " + bookName + " " + author + " " + price;			
			return show;
	}
	public void showBookInfo() {
		System.out.println("No. " + orderNo + " | 도서명 : " + bookName + " | 저자 : " + author +
				" | 출판사 : " + publisher + " | 가격 : " + price);
	}
	public void setBookInfo(String bookName, String author, String publisher, int price, int orderNo){
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.orderNo = orderNo;
		// 이름이 같은 경우 매개변수가 우선임
		// 클래스 내부 변수를 호출할 때는 this
	}
}
