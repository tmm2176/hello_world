
package com.yedam.inheritance;
/*
 * Friend2 : Friend 상속
 */
public class UnivFriend extends Friend{
	// 필드
	private String univName;
	private String major;
	
	// 생성자
	public UnivFriend() {}
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel);
		this.univName = univName;
		this.major = major;
	}
	// 부모 클래스 메소드를 자식 클래스가 재정의. over riding (!= over loading)
	@Override
	public String toString() { // 부모 클래스의 매개변수와 다른 매개변수를 설정할 수 없음
		return super.toString() + ", 학교는 "+ univName + ", 학과는 " + major;
	}
	
	// getter, setter
	@Override
	public String getName() {
		return super.getName();
	}
//	@Override
//	public void setName(string name) {
//		// 부모 final 메소드는 overriding 불가
//	}
	
	public String getUnivName() {
		return univName;
	}
	public String getMajor() {
		return major;
	}
	public void setUnivName(String univName) {
		this.univName = univName;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
