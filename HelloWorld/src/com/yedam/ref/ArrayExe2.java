package com.yedam.ref;

import com.yedam.varable.Member;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Hello", "World", "20", "23.4"};
		// 확장 for문
		for(String str : strAry) {
			System.out.println(str);
		}
		// 크기지정
		strAry = new String[10]; // {null, null, ..., null}
		// strAry[0] = new String("Nice"); //원래 이렇게 만들어야하는데 String은 생략 가능
		strAry[0] = "Nice";
		for (String str : strAry) {
			System.out.println(str);
		}
		//Member 클래스
		Member[] memAry = new Member[10]; // {null, null, ..., null}
		memAry[0] = new Member(); // 생성자
		memAry[0].setMember("홍길동", 80); // 80 -> 90
		memAry[0].showInfo();
				
		memAry[1] = new Member(); //값을 할당하지 않은 경우 오류 발생, 참조하고 있는 객체가 없는 NULL값임
		memAry[1].setMember("박민동", 85); // 85 -> 95
		memAry[1].showInfo();
		
		memAry[2] = new Member("최민혁", 77);
		memAry[2].showInfo();
		
//		System.out.println("---------------------- ");
//		for (int i = 0; i < memAry.length; i++) {
//			if (memAry[i] != null) //null이 아닌 경우에만 처리하도록 설정
//				memAry[i].showInfo();
//		}
		System.out.println("---------------------- ");
		memAry[0].setScore(90);
		memAry[1].setScore(95);
		for (int j = 0; j < memAry.length; j++) {
			if (memAry[j] != null) //null이 아닌 경우에만 처리하도록 설정
				memAry[j].showInfo();
		}
	} // end of main()
}
