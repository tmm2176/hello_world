package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		int[] intAry = {10, 20, 30};
		for (int i = 0; i < intAry.length; i++) {
//			System.out.println(intAry[i]);
		}
		intAry = new int[] { 40, 50, 60 };
//		배열의 초기값을 지정
		intAry = new int[10];
//		배열의 크기를 지정 {0, 0, ..., 0}
		intAry[3] = 30;
		intAry[9] = 90;
		intAry[1] = 100;
		// 10 이상의 index는 없기 때문에 10 이상의 값의 index를 사용하려고 하면 예외 발생
		intAry[0] = (int)(Math.random() * 100)+1;
		
		for (int i = 0; i < intAry.length; i++) {
			if(intAry[i] == 0) {
			   intAry[i] = (int)(Math.random() * 100)+1;
			}
		}
		// 홀수값의 합 구하기
		int sumOdd = 0;
		for (int i = 0; i < intAry.length; i++) {
			if(intAry[i] % 2 == 1) {
			   sumOdd = sumOdd + intAry[i];
			}
		}
		System.out.println("홀수값의 합은 " + sumOdd + "입니다.");
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(i + "번째 값은 " + intAry[i]);
		}
	} // end of main()
}
