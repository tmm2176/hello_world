package com.yedam.myEsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			// System.out.println("접속성공체크");
			return conn;
		} catch (SQLException e) {
			//System.out.println("접속실패체크");
			e.printStackTrace();
		}
		return null;
	} //end of getConnect()
	
	// 목록조회 (단일, 게임코드 입력)
	public Game showGameInputCode(String code) {
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM tbl_game "
				+ "WHERE game_code = nvl(?, game_code)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  code);
			
			Game game = new Game();
			ResultSet rs = psmt.executeQuery(); // 조회
			if (rs.next()) {
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
			} else {
				return null;
			}
			return game;
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	} // end of showGame
	
	// 목록조회 (단일, 게임이름 입력)
	public Game showGameInputName(String gName) {
		List<Game> list = new ArrayList<Game>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM tbl_game "
				+ "WHERE game_name = nvl(?, game_name)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  gName);
			
			Game game = new Game();
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
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
			return game;
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	} // end of showGame
	
	// 목록조회 (다수의 게임 / 매개변수 바꿔야하긴함, code는 고유값이라 공백아니면 하나만 나옴)
	public List<Game> showGameList(String code) {
		List<Game> list = new ArrayList<Game>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM  tbl_game "
				+ "WHERE game_code = nvl(?, game_code) "
				+ "ORDER BY          game_code ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			
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
			//System.out.println("체크포인트");
			return null;
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
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, ?)";
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
			stmt.setInt(9, game.getScore());
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
	public boolean update(Game game) {
		// System.out.println(game);
		Connection conn = getConnect();
		String sql = "UPDATE tbl_game "
				+ "SET    game_code    = nvl(?, game_code), "
				+ "       game_name    = nvl(?, game_name), " //
				+ "       game_tag     = nvl(?, game_tag), "
				+ "       game_info    = nvl(?, game_info), "
				+ "       developer    = nvl(?, developer), "
				+ "       distributor  = nvl(?, distributor), "
				+ "       registration = nvl(?, registration), "
				+ "       price        = ?, "
				+ "       discount     = ?, "
				+ "       score        = ? " //
				+ "WHERE  game_code    = ? ";
		try {
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
			stmt.setString(11, game.getGameCode());
			
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
	public boolean delete(Game game) {
		Connection conn = getConnect();
		String sql = "DELETE FROM tbl_game "
				+ "Where game_code = '"
				+ game.getGameCode() + "'";
		
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
	} // end of delete()
} // end of class
