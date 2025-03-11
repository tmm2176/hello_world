package com.yedam;

public class HelloExe {
    // 기능 (함수) => main 메소드.
	public static void main(String[] args) {
    	System.out.println("Hello, World");
    	// System.out.println =>. 콘솔에 출력
    	
    	String name;
    	name = "김민수";
    	
    	System.out.println("이름은 " + name);
    	// 문자열 사이의 + 연산자 => 두 문자열을 합치는 기능
    	
    	int score = 100;
    	System.out.println("점수는 " + score + "점 입니다");
        // 두 개의 타입이 같도록 변환시켜 주기 때문에 int타입의 변수도 문자열 타입으로 변환시키게 된다.
    	// 즉 +도 문자열을 합치는 기능으로 사용된다.
    	
    	
    } // end of main()
}
