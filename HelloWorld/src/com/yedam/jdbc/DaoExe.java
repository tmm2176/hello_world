package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 250319
 * 1. ojdbc 데이터베이스 연결, 쿼리, 실행결과
 * 2. Connection 객체(db session)
 * 3. Statement(PreparedStatement) 쿼리 실행
 * 4. ResultSet(조회 시 결과를 저장), int(입력, 수정, 삭제)
 */
public class DaoExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		String sql = "SELECT empno, ename, job, mgr, hiredate, sal\r\n"
				+ "FROM EMP order by empno DESC";
		// SQL Developer -> 사용자(scott 계정 사용했음) -> 접속
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			conn.setAutoCommit(false); // autoCommit 사용여부 설정 가능
			System.out.println("연결성공");
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate("DELETE FROM emp WHERE empno = 9999");
			if (r > 0) { // r < 0은 처리 건수가 없음 -> 데이터에 제대로 반영 x
				System.out.println("삭제성공");
				conn.commit(); // 커밋처리, 일반적으로 자동 commit
			}
			
			ResultSet rs = stmt.executeQuery(sql); // 쿼리작성 -> 실행
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+ ", " + rs.getString("ename") + //
						", " + rs.getString("job"));
			}
			System.out.println("-- end of data --");
		} catch(SQLException e){
			e.printStackTrace();
		}
	} // end of main()
}