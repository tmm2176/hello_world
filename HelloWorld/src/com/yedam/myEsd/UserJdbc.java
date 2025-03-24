package com.yedam.myEsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbc {
	// Connection 생성
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			System.out.println("접속성공체크");
			return conn;
		} catch (SQLException e) {
			//System.out.println("접속실패체크");
			e.printStackTrace();
		}
		return null;
	} //end of getConnect()
	
	//로그인 함수 (Jdbc)
	public User logInDB(String id, String pw) {
		// id, pw로 조회
		Connection conn = getConnect(); // db session
		String sql = "SELECT * "
				+ "FROM   tbl_user "
				+ "WHERE  user_id  = ? "
				+ "AND    password = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			// find 
			if (rs.next()) {
				//System.out.println("체크포인트2");
				User user= new User (
						rs.getString("user_id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getString("status"),
						rs.getString("registration")); //조회 성공 시
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("체크포인트3");
		return null; // 조회 실패 시
	} // end of logInDB()
}
