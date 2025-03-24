package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrappereExe {
	public static void main(String[] args) {
		int[] intAry = { 10, 20 };
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10); // int -> Integer boxing / Integer -> int unboxing
		
		//
		int num1 = 10; // == 두 개의 값을 비교
		Integer num2 = 10; // 참조변수(주소값) 아래 코드와 같은 의미 / 주소값을 비교
//		Integer num2 = new Integer(10);
		System.out.println(num1 == num2); //이거 왜 true지?
		System.out.println(num1 == num2.intValue()); //intValue() -> 기본 데이터타입으로 변경
		
	} // end of main()
}