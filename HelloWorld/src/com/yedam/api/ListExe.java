package com.yedam.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ListExe {
	public static void main(String[] args) {
		// 배열 : int[], String[], Member[]
		// 컬렉션 : List<Integer>, List<String>, List<Member>
		// intList.get(0), intList.add(30)
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(100);
		intList.add(150);
		intList.add(200);
		intList.add(100);
		
		for(int i = 0; i < intList.size(); i++) {
			//Array -> lenght = List -> size
			System.out.println(intList.get(i));
		} //end of for
		
		// set컬렉션 -> Index로 관리되는 것이 아니라 중복값 불가능
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(100);
		intSet.add(150);
		intSet.add(200);
		intSet.add(100); //중복값이 추가로 담기지 않음
		
		System.out.println("----------------------------------");
		// index기반이 아니기 때문에 확장 for문 사용
		for(Integer num : intSet) {
			System.out.println(num);
		} // end of for
		
		// Set<Member>
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("박태욱", 21));
		members.add(new Member("최선욱", 22));
		members.add(new Member("홍길동", 20)); // hashCode, equals의 반환 값이 같으면 동등개체
		
		System.out.println("----------------------------------");
		// index기반이 아니기 때문에 확장 for문 사용
		for(Member mbr : members) {
			System.out.println(mbr.toString());
		} // end of for	
	} // end of main()
}










