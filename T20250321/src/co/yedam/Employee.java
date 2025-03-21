package co.yedam;

public class Employee {
/*
 * 필요 정보 : 사번, 이름, 전화번호, 급여, 입사일자
 */
	//필드
	private String empNo;
	private String empName;
	private String empPhone;
	private String empHireDate;
	private int empSalary;
	
	public Employee() {}
	// 생성자 -> 기본생성자와 달리 값을 바로 입력가능하게 만든 생성자
	public Employee(String empNo, String empName, String empPhone, String empHireDate, int empSalary) {
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empHireDate = empHireDate;
		this.empSalary = empSalary;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpHireDate() {
		return empHireDate;
	}
	public void setEmpHireDate(String empHireDate) {
		this.empHireDate = empHireDate;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
}
