package com.yedam.inheritance;

/*
 * 친구1 : 이름, 연락처
 */

// 만약 클래스 이름 앞에 final을 붙이면 부모 클래스가 될 수 없음을 의미한다
public class Friend extends Object{
	// 필드
	private String name;
	private String tel;

	// 생성자
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름은 " + getName() + ", 연락처는 " + getTel();
	}
	// getter, setter
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
