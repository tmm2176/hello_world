package com.yedam.myEsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserJdbc {
	// Connection 생성
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@192.168.0.30:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			// System.out.println("접속성공체크");
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
	
	// 목록조회 (단일, 유저ID 입력)
	public User searchUserInputID(String id) {
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM tbl_user "
				+ "WHERE user_id = nvl(?, user_id) "
				+ "ORDER BY        user_id ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  id);
			
			User user = new User();
			ResultSet rs = psmt.executeQuery(); // 조회
			
			if (!rs.next()) {
				return null;
			}
			else {
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("user_name"));
				user.setUserStatus(rs.getString("status"));
				user.setRegistrationDate(rs.getDate("registration").toString());
				user.setMoney(rs.getInt("money"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} // end of showGameList
	
	// 목록조회 (입력 id 전체)
	public List<User> showUserList(String id) {
		List<User> list = new ArrayList<User>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM tbl_user "
				+ "WHERE user_id = nvl(?, user_id) "
				+ "ORDER BY        user_id ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  id);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("user_name"));
				user.setUserStatus(rs.getString("status"));
				user.setRegistrationDate(rs.getDate("registration").toString());
				user.setMoney(rs.getInt("money"));
				list.add(user); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of showGameList
	
	
	// 추가
	public boolean insert(User user) {
		// DB에 접근하는 코드들은 정형화된 코드임
		Connection conn = getConnect();
		String sql = "INSERT INTO tbl_user "
				+ "(user_id, password, user_name,"
				+ "status, registration) "
				+ "VALUES(?, ?, ?, ?, ?)";
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getUserStatus());
			stmt.setString(5, user.getRegistrationDate());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	} // end of insert()
	
	// 수정
	public boolean update(User user) {
//		System.out.println(user.getUserId());
//		System.out.println(user.getUserName());
//		System.out.println(user.getPassword());
//		System.out.println(user.getUserStatus());
//		System.out.println(user.getRegistrationDate());
//		System.out.println(user.getMoney());
		
		Connection conn = getConnect();
		String sql = "UPDATE tbl_user "
				+ "SET    password     = nvl(?, password), "
				+ "       user_name    = nvl(?, user_name), "
				+ "       status       = nvl(?, status), "
				+ "       registration = nvl(?, registration), "
				+ "       money        = ? "
				+ "WHERE  user_id      = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getUserStatus());
			stmt.setString(4, user.getRegistrationDate());
			stmt.setInt(5, user.getMoney());
			stmt.setString(6, user.getUserId());
			
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 수정성공
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return false; // 수정실패
	} // end of update()
	
	// 삭제
	public boolean delete(User user) {
		Connection conn = getConnect();
		String sql = "DELETE FROM tbl_user "
				+ "Where user_id = '"
				+ user.getUserId() + "'";
		
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
	} // end of delete
} // end of class
