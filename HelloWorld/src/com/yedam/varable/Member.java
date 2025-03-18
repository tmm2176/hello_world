package com.yedam.varable;

// public <-> private
public class Member {
	// 클래스 : 필드(값을 저장)
	private String name;
	private int score;
	// 클래스 : 생성자(실체생성)
	// 컴파일러 기본생성자 생성 / 기본생성자 -> 매개값이 없는 생성자
	// 생성자는 반환 type이 없음
	// 같은 이름의 생성자를 여러개 만드는 것 -> overloading
	// 기본생성자가 없어도 컴파일러가 따로 처리해주지만
	// 기본생성자 외의 다른 생성자를 만든 경우 기본생성자를 꼭 추가해줘야함
	public Member() {
		
	}
	// 생성자 -> 기본생성자와 달리 값을 바로 입력가능하게 만든 생성자
	public Member(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// 클래스 : 메소드(기능) 반환값 메소드명(매개값)
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		if(score < 0 || score > 100) {
			System.out.println("적정값을 입력하세요");
			return; // 메소드 종료
		}
		this.score = score; 
	}
	public void showInfo() {
		System.out.println("이름은, " + name + " 점수는, " + score);
	}
	public void setMember(String name, int score){
		this.name = name;
		this.score = score;
		// 이름이 같은 경우 매개변수가 우선임
		// 클래스 내부 변수를 호출할 때는 this
	}
	// toString 재정의 250318 추가
	public String toString() {
		return "이름: " + name + ", 점수: " + score;
	}
	// Set 컬렉션의 중복된 값으로 지정 //250318 추가
	// name, score -> hashCode + equals -> 동일한 값
	@Override
	public int hashCode() {
		return score;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member target  = (Member) obj;
			return this.name.equals(target.name);
		}
		return false;
	}	
}
