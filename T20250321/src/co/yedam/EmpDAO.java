package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";
		//System.out.println("체크포인트1");
		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
			//System.out.println("DB연결 성공 체크");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("DB연결 실패 체크");
		}
		return null;
	} //end of getConnect()
	
	// 추가
	public Boolean addFunc(Employee emp) {
//		System.out.println("분기체크");
		Connection conn = getConnect();
		String sql = "INSERT INTO tbl_emp (emp_no, emp_name, phone, hire_date, salary)\r\n"
				+ "VALUES(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getEmpNo());
			stmt.setString(2, emp.getEmpName());
			stmt.setString(3, emp.getEmpPhone());
			stmt.setString(4, emp.getEmpHireDate());
			stmt.setInt(5, emp.getEmpSalary());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 등록성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패
	} // end of addFunc()
	
	//목록
	public List<Employee> listFunc() {
	    List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnect();
		String sql = "SELECT emp_no, "
				+ "       emp_name, "
				+ "       phone, "
				+ "       hire_date, "
				+ "       salary "
				+ "FROM   tbl_emp";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(); // 조회
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getString("emp_no")); //getString("col_name")
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpPhone(rs.getString("phone"));
				emp.setEmpHireDate(rs.getString("hire_date"));
				emp.setEmpSalary(rs.getInt("salary"));
				list.add(emp); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of listFunc()
	
	public boolean editFunc(Employee emp) {
		Connection conn = getConnect();
		String sql = "UPDATE tbl_emp "
				+ "SET    emp_no      = nvl(?, emp_no), " //
				+ "       emp_name    = nvl(?, emp_name), " //
				+ "       phone       = nvl(?, phone), " //
				+ "       hire_date   = nvl(?, hire_date), " //
				+ "       salary      = ? "
				+ "WHERE  emp_no      = ? ";
		try {
			//Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getEmpNo());
			stmt.setString(2, emp.getEmpName());
			stmt.setString(3, emp.getEmpPhone());
			stmt.setString(4, emp.getEmpHireDate());
			stmt.setInt(5, emp.getEmpSalary());
			stmt.setString(6, emp.getEmpNo());

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true; // 수정성공
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 수정실패
	} // end of editFunc()

	public boolean deletdFunc(Employee emp) {
		Connection conn = getConnect();
		String sql = "DELETE FROM tbl_emp "
				+ "Where emp_no = '"+ emp.getEmpNo() + "'";
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
	} // end of detaileFunc()
	
	// 조회(조건 : 입사일자)
	public List<Employee> searchFunc(String hd) {
	    List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnect();
		String sql = "SELECT * "
				+ "FROM     tbl_emp "
				+ "WHERE    hire_date >= nvl(?, hire_date) "
				+ "order by hire_date";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,  hd);
			
			ResultSet rs = psmt.executeQuery(); // 조회
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getString("emp_no")); //getString("col_name")
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpPhone(rs.getString("phone"));
				emp.setEmpHireDate(rs.getDate("hire_date").toString());
				emp.setEmpSalary(rs.getInt("salary"));
				list.add(emp); // 컬렉션저장
			} // end of while
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of searchFunc()
}
