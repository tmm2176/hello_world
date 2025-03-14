package com.yedam.classes;
/*
 *  정적(static) 멤버의 사용
 */
public class MethodExe4 {
	
	static void test() {
		System.out.println("인스턴스 메소드");
	}
	
	// 정적 메소드에서 인스턴스 메소드 호출하려고 하면 오류발생
	static void main() {
		test();
	}
}
