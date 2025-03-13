package com.yedam.classes;

public class MethodExe1 {
	/* returnType MethodName (para...){
    *
    }
    */
	void printString(int times, String str) {
		for(int i = 1; i <= times; i++) {
		    System.out.println(str);
		}
	}
	// 두 정수의 합
	int sum(int n1, int n2) {
		int result = 0;
		result = n1 + n2;
		return result;
	}
	
	// 같은 이름의 함수인데 매개변수로 받는 값이 달라짐
	// (메소드, 생성자) 오버로딩
	// 두 실수의 합
	double sum(double n1, double n2) {
		return (n1 + n2);
	}
	
	// 배열의 합
	int sum(int[] ary) {
		int result = 0;
		for(int i = 0; i < ary.length; i++) {
			result = result +ary[i];
		}
		return result;
	}
	
	// 배열의 합(double[]을 매개값, 반환 : double)
	double sum(double[] ary) {
		double result = 0;
		for(int i = 0; i < ary.length; i++) {
			result = result +ary[i];
		}
		return result;
	}
}
