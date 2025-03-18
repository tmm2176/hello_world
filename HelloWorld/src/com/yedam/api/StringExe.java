package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";
		str = new String("Hello, World");
		str.getBytes();
		byte[] bAry = str.getBytes();
		
		for(int i = 0; i < bAry.length; i++) {
			System.out.print(bAry[i] + " ");
		}
		
		System.out.println("\n--------------------------------------------------");
		byte[] bstr = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100};
		String msg = new String(bstr);
		//String msg = new String(bstr, 7, 5); // index 7부터 5개의 index -> world 출력
		System.out.println(msg); 
		char result = msg.charAt(0);
		System.out.println((int)result);
		
		// String: "" - 문자열, char: '' - 문자 하나
		if (result == 'W') {
			// 비교구문
		} // end of if
		int idx = msg.indexOf("o");
		if(idx != -1) {
			// 처리
		} // end of if
		
		String[] names = {"홍길동", "홍길승", "김민규", "박홍길"};
		int cnt = 0;
		for(int i = 0; i < names.length; i++) {
			if(names[i].indexOf("홍") == 0) { // indexOf는 해당 값의 index를 반환
				cnt++;
			} // end of if
		} // end of for
		System.out.println("\"홍\"씨 성을 사용하는 이름의 갯수: " + cnt);
		
		System.out.println("Hello, World".substring(3, 7));
		// substring(a,b) -> 문자열의 a index부터 b index 이전까지 가져옴
		System.out.println("--------------------------------------------------");
		// p. 509 문자추출 charAt()
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3);
		System.out.println(charValue);
		
		System.out.println("--------------------------------------------------");
		// p. 510 문자열비교 equals()
		String strVar1 = new String("엄준식");
		String strVar2 = "엄준식";
		String strVar3 = "엄준식";
		
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar2 == strVar3);
		// 자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조.
		// new 연산자로 생성된 문자는 다른 객체를 참조
		System.out.println("--------------------------------------------------");
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar2 == strVar3);
		
		
		
	} // end of main
}
