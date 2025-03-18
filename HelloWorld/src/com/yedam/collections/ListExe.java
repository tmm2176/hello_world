package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;
import com.yedam.bookApp.Book;

public class ListExe {
	public static void main(String[] args) {
		// 배열의 값을 추가하는 경우
		// 새로운 배열을 선언 후 기존의 값을 복사 후 추가하는 방식을 사용해야한다
		int[] intAry = { 10, 20 };
		int[] intAry2 = new int[5];
		for(int i = 0; i < intAry.length; i++) {
			intAry2[i] = intAry[i];
		}
//		intAry[2] = 30; // runtime error 발생 -> 배열 범위 밖에 새로운 값 할당
		
		List<Integer> list = new ArrayList<Integer>();
		// list의 add값을 사용할 경우 list의 크기가 가변적으로 변함
		list.add(10);
		list.add(14);
		list.add(17);
		list.add(20);
		
		//list.get(0); // get은 list의 데이터 타입에 맞는 값을 반환, 해당 리스트는 Integer를 반환
		Integer it1 = list.get(0); // 조회
		list.remove(0); //삭제
		list.set(0, 30); // 수정 
		for(int i = 0;  i < list.size(); i++) {
			System.out.println(list.get(i));
		} // end of for
		// List - ArrayList
		List<String> list2 = new ArrayList<String>();
		list2.add("Hello");
		//list2.add(200);
		//list2.add(new Book()); //어떤 데이터 값이든 담을 수 있으나 자료형을 적어둬야 오류가 없음
		
		List<Book> list3 = new ArrayList<Book>();
		list3.add(new Book());
		
		for(int i = 0; i < list2.size(); i++) {
			String result = (String)list2.get(i); // Object -> Casting(형변환)
		} // end of for
	} // end of main()
}
