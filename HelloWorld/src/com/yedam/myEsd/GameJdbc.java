package com.yedam.myEsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GameJdbc {
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
	
	
	// 목록조회
	public List<Game> showGameList(String tag) {
		List<Game> list = new ArrayList<Game>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM tbl_game "
				+ "WHERE game_tag = nvl(?, game_tag)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  tag);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				Game game = new Game();
				game.setGameCode(rs.getString("game_code"));
				game.setGameName(rs.getString("game_name"));
				game.setGameTag(rs.getString("game_tag"));
				game.setGameInfo(rs.getString("game_info"));
				game.setDeveloper(rs.getString("developer"));
				game.setDistributor(rs.getString("distributor"));
				game.setRegistration(rs.getString("registration"));
				game.setPrice(rs.getInt("price"));
				game.setDiscount(rs.getInt("discount"));
				game.setScore(rs.getInt("score"));
				list.add(game); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of showGameList
	
	// 추가
	public boolean insert(Game game) {
		// DB에 접근하는 코드들은 정형화된 코드임
		Connection conn = getConnect();
		String sql = "INSERT INTO tbl_game "
				+ "(game_code, game_name, game_tag,"
				+ "game_info, developer, distributor,"
				+ "registration, price, discount, score) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, game.getGameCode());
			stmt.setString(2, game.getGameName());
			stmt.setString(3, game.getGameTag());
			stmt.setString(4, game.getGameInfo());
			stmt.setString(5, game.getDeveloper());
			stmt.setString(6, game.getDistributor());
			stmt.setString(7, game.getRegistration());
			stmt.setInt(8, game.getPrice());
			stmt.setInt(9, game.getDiscount());
			stmt.setInt(10, game.getScore());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	} // end of insert()
}
