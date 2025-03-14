package com.yedam.inheritance;
/*
 * Friend? : Friend 상속
 */
public class CompanyFriend extends Friend{
	// 필드
	private String company;
	private String dept;
	
	// 생성자
	public CompanyFriend() {}
	public CompanyFriend(String name, String tel, String company, String dept) {
		super(name, tel);
		this.company = company;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return super.toString() + ", 회사는 "+ company + ", 부서는 " + dept;
	}
	// getter, setter
	public String getCompany() {
		return company;
	}
	public String getDept() {
		return dept;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
