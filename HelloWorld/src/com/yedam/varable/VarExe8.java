package com.yedam.varable;

public class VarExe8 {
	public static void main(String[] args) {
		int n1 = 10;
		byte b1 = 120;
		byte result = (byte)(b1 + 130);
		// byte자료형의 범위는 -128 ~ 127, 자료형 문제로 형변환을 해줘야함
		System.out.println("더한 결과: " + result);
//		byte -> int (자동형변환 : promotion) 작은 값 > 큰 값 시 자동 형변환
//		n1 = (int)b1;
		n1 = b1; //
		System.out.println(n1);
		n1 = 200;
		b1 = (byte)n1; // 큰 값 > 작은 값 시 자동형변환x 형변환 해줘도 값의 손실이 있을 수 있음
		System.out.println(b1);
		
//		for (int i = 1; i < 15; i++) {
//			System.out.println(b1++);
//		}
	}
}