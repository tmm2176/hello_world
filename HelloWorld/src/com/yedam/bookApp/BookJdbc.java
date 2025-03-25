package com.yedam.bookApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * ojdbc를 활용한 bookApp
 */
public class BookJdbc {
	
	// Connection 생성
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} //end of getConnect()
	
	// 추가
	public boolean insert(Book book) {
		// DB에 접근하는 코드들은 정형화된 코드임
		Connection conn = getConnect();
//		String sql = "INSERT INTO tbl_book (book_code, book_title, author, company, price)\r\n"
//				+ "VALUES(book_seq.nextval, '"
//				+ book.getBookName()  + "', ' "
//				+ book.getAuthor()    + "', '"
//				+ book.getPublisher() + "','" 
//				+ book.getPrice()     + "')";
		String sql = "INSERT INTO tbl_book (book_code, book_title, author, company, price)\r\n"
				+ "VALUES(book_seq.nextval, ?, ?, ?, ?)";
		
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getBookName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getPublisher());
			stmt.setInt(4, book.getPrice());
			//int r = stmt.executeUpdate(sql);
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	}
	
	// 수정
	public boolean update(Book book) {
		System.out.println(book);
		Connection conn = getConnect();
//		String sql = "UPDATE tbl_book\r\n"
//				+ "SET    book_title = '"+ book.getBookName() +"',\r\n"
//				+ "       price      = " + book.getPrice() + ",\r\n"
//				+ "       author     = '"+ book.getAuthor() +"'\r\n"
//				+ "WHERE  book_code  = '" + book.getBookCode() + "'";
		String sql = "UPDATE tbl_book "
				+ "SET    book_title = nvl(?, book_title), " //
				+ "       price      = ?, " //
				+ "       author     = nvl(?, author), " //
				+ "       company    = nvl(?, company) " //
				+ "WHERE  book_code  = ? ";
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getBookName());
			stmt.setInt(2, book.getPrice());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getPublisher());
			stmt.setString(5, book.getBookCode());
			
			//int r = stmt.executeUpdate(sql);
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 수정성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 수정실패
	}
	
	// 삭제
	public boolean delete(Book book) {
		Connection conn = getConnect();
		String sql = "DELETE FROM tbl_book\r\n"
				+ "Where book_code = '"+ book.getBookCode() + "'";
		
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				return true; // 삭제성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 삭제실패
	}
	
	// 목록
	public List<Book> list(String company){
		List<Book> list = new ArrayList<Book>();
		Connection conn = getConnect();
		String sql = "SELECT * FROM tbl_book " //
				+ "where company = nvl(?, company) " //
				+ "order by book_code";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  company);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author")); //getString("col_name")
				book.setBookCode(rs.getString("book_code"));
				book.setPublisher(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				book.setBookName(rs.getString("book_title"));
				list.add(book); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of list
	
	// 하나만 조회
	public Book selcet(String bcode){
		Connection conn = getConnect();
		String sql = "SELECT * FROM tbl_book " //
				+ "where book_code = ?"; //중복값을 제외하는 코드
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  bcode);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			if(rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString("author")); //getString("col_name")
				book.setBookCode(rs.getString("book_code"));
				book.setPublisher(rs.getString("company"));
				book.setPrice(rs.getInt("price"));
				book.setBookName(rs.getString("book_title"));
				return book; // 컬렉션저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //조회된 결과가 없음
	} // end of list
	
} // end of class