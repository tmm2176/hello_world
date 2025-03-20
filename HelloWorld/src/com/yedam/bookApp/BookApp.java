package com.yedam.bookApp;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 실행클래스(main 메소드)
 */

public class BookApp {
	public static void main(String[] args) {
		
		// 250320 입력 데이터 확인
//		MemberJdbc dao = new MemberJdbc();
//		List<Map<String, String>> list = dao.memberList();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(list);
//		System.out.println(json.toString());
		// 250320 입력데이터확인
		
//		Book book = new Book();
//		book.setBookName("샘플1");
//		book.setAuthor("샘플저자");
//		book.setPublisher("샘플출판사");
//		book.setPrice(10000);
//		
//		Book book2 = new Book();
//		book2.setBookName("수정한책1234");
//		book2.setAuthor("수정용권1234");
//		book2.setPublisher("수정출판1234");
//		book2.setPrice(123401111);
//		book2.setBookCode("33");
//		
//		Book book3 = new Book();
//		book3.setBookName("샘플1");
//		book3.setAuthor("샘플저자");
//		book3.setPublisher("샘플출판사");
//		book3.setPrice(10000);
//		book3.setBookCode("34");
		
//		BookJdbc dao = new BookJdbc();
//		 등록확인
//		if(dao.insert(book)) {
//			System.out.println("등록성공");
//		} else {
//			System.out.println("등록실패");
//		}
//		 수정확인
//		if(dao.update(book2)) {
//			System.out.println("수정성공");
//		} else {
//			System.out.println("수정실패");	
//		}
//
//		// 삭제확인
//		if(dao.delete(book3)) {
//			System.out.println("삭제성공");
//		} else {
//			System.out.println("삭제실패");
//		}
//		List<Book> list = dao.list("");
//		for (Book bk : list) {
//			System.out.println(bk.showList());
//		}
		
		
		
		/*
		 * 방법 1		
		 */
		
//		BookMain mainApp1 = new BookMain();
//		BookMain mainApp2 = new BookMain();
		/*
		 * 방법 2 (싱글톤)
		 */
		//BookJdbc 250319
		BookMain mainApp1 = BookMain.getInstance();
		mainApp1.main(args);
		//BookJdbc 250319
		
//		BookMain mainApp2 = BookMain.getInstance();
		
//		mainApp1.addFunc(); // 1번 객체에 등록
//		mainApp1.listFunc(); // 1번 객체 목록
		
//		mainApp2.listFunc(); // 2번 객체 목록
		// 방법 1 사용시, 두 객체가 각각 따로 생성된 것이라 내부 데이터 또한 전부 다름
		// 방법 2 사용시, 두 객체는 같은 것이므로 네부 데이터는 같은 값임
		
// 250319 SQL 시작
//		SELECT *
//		FROM tab;
//
//		SELECT empno,
//		       ename,
//		       job,
//		       mgr,
//		       hiredate,
//		       sal
//		FROM EMP
//		order by empno desc;
//
//		INSERT INTO emp (empno, ename, job, mgr, hiredate, sal)
//		VALUES (9998, '홍길동', 'CLERK', 7788, '2020-01-01', 1000);
//
//		UPDATE emp
//		set    sal = 2000,
//		       deptno = 10
//		WHERE  empno = 9998;
//
//		DELETE FROM emp
//		WHERE empno = 9999;
//
//		-- table 생성 --
//		-- 도서코드, 도서명, 저자, 출판사, 가격
//		CREATE TABLE tbl_book(
//		             book_code  varchar2(5) primary key, --도서코드
//		             book_title varchar2(50) not null, --도서명
//		             author     varchar2(30) not null, --저자
//		             company    varchar2(30) not null, --출판사
//		             price      number       default 1000--가격
//		);
//		CREATE SEQUENCE book_seq;
//		SELECT book_seq.nextval from dual;
//
//		INSERT INTO tbl_book (book_code, book_title, author, company, price)
//		VALUES(book_seq.nextval, '이것이자바다', '신용권', '한빛출판사', 20000);
//		INSERT INTO tbl_book (book_code, book_title, author, company, price)
//		VALUES(book_seq.nextval, '추가한빛', '추가용권', '한빛출판사', 20000);
//		INSERT INTO tbl_book (book_code, book_title, author, company, price)
//		VALUES(book_seq.nextval, '샘플1', '샘플저자', '샘플출판사', 10000);
//		INSERT INTO tbl_book (book_code, book_title, author, company, price)
//		VALUES(book_seq.nextval, '추가1', '추가저자', '추가출판사', 15000);
//		--VALUES('B001', '이것이자바다', '신용권', '한빛출판사', 20000);
//
//		DELETE FROM tbl_book
//		Where book_code = '9';
//
//		UPDATE tbl_book
//		SET    book_title = nvl('매개값', book_title),
//		       price      = 25000,
//		       author     = nvl('매개값',author),
//		       company    = nvl('매개값',company)
//		WHERE  book_code  = '매개값';
//
//		UPDATE tbl_book
//		SET    book_title = '자바스크립츠 기초',
//		       price      = 25000,
//		       author     = '용신권',
//		       company    = '수정'
//		WHERE  book_code  = '27';
//
//		SELECT   *
//		FROM     tbl_book
//		ORDER BY book_code;
//
//		SELECT *
//		FROM tbl_book
//		where company = nvl('', company)
//		order by book_code;
//
//		commit;
//		rollback;
//		delete from tbl_book;

// 250319 SQL 끝 
	}
}
