package com.yedam.myEsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserLibJdbc {
	// Connection 생성
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
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
	
	// 라이브러리 등록번호 찾기
	public int searchEmptyNum() {
		int num = 1;
		Boolean run = true;
		Connection conn = getConnect();
		while(run) {
			String sql = "SELECT * "
					+ "FROM user_library "
					+ "WHERE lib_no = nvl(?, lib_no)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1,  num);
				ResultSet rs = psmt.executeQuery(); // 조회
				if(!(rs.next())) {
					return num;	
				} else {
					num++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} //end of loop
		return -1;
	}
	
	// 게임을 보유중인지 확인
	public Boolean checkMyGame(String uID, String gCode) {
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM   user_library "
				+ "WHERE  user_id   = nvl(?, user_id) "
				+ "  AND  game_code = nvl(?, game_code)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  uID);
			psmt.setString(2,  gCode);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			if (rs.next()) {
				return true; // 보유중
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 미보유중
	}
	
	// 라이브러리 조회
	public List<UserLibrary> showUserLibrary(String uID) {
		List<UserLibrary> list = new ArrayList<UserLibrary>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM user_library "
				+ "WHERE user_id = nvl(?, user_id)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  uID);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				UserLibrary uLib = new UserLibrary();
				uLib.setNum(rs.getInt("lib_no"));
				uLib.setUserId(rs.getString("user_id"));
				uLib.setGameCode(rs.getString("game_code"));
				list.add(uLib); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of showGameList
	
	// 라이브러리 추가
	public boolean insert(UserLibrary ulib) {
		// DB에 접근하는 코드들은 정형화된 코드임
		Connection conn = getConnect();
		String sql = "INSERT INTO user_library "
				+ "(lib_no, user_id, game_code) "
				+ "VALUES(?, ?, ?)";
		int libNo = searchEmptyNum();
		if(libNo == -1) {
			System.out.println("라이브러리 목록 오류발생");
			return false; // 등록실패
		}
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, libNo);
			stmt.setString(2, ulib.getUserId());
			stmt.setString(3, ulib.getgameCode());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	} // end of insert()
	
	// 라이브러리 삭제
	public boolean delete(String gCode, String uID) {
		Connection conn = getConnect();
		String sql = "DELETE FROM user_library "
				+ "WHERE game_code = nvl(?, game_code) "
				+ "AND   user_id   = nvl(?, user_id) ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  gCode);
			psmt.setString(2,  uID);
			
			int r = psmt.executeUpdate(sql);
			if (r > 0) {
				return true; // 삭제성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 삭제 실패
	} // end of delete()
} // end of class
