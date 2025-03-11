package com.yedam.varable;

// 관례 : 클래스의 이름은 대문자로 시작
public class VarExe1 {
//	연산은 두 변수의 유형(dataType)이 동일
	public static void main(String[] args) {
		int number1 = 70;
		int number2 = 80;
		number1 = 71;
		
		int sum = number1 + number2;
		
		System.out.println("두 점수의 합은 " + sum + "점 입니다.");
		
//		double avg = sum / 2;
//		 둘 다 int타입이면 자료형을 double로 하여도 int형의 결과가 나온다
		double avg = sum / 2.0;
//		따라서 둘 중 하나는 double형으로 만들어 줘야 결과가 double형으로 출력된다
		System.out.println("두 점수의 평균은 " + avg + "점 입니다.");
	} // end of main()
}
