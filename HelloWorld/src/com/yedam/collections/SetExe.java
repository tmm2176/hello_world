
package com.yedam.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.varable.Member;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		//set.add(100); //추가할 수 없는 자료형
		set.add("Hello"); // 중복값은 들어가지 않음
		
		Iterator<String> iter = set.iterator(); // 반복자
		// set은 index로 접근할 수 없기 때문에 반복자를 통해 접근
		while(iter.hasNext()) {
		    String result = iter.next();
		    System.out.println(result);
		}
		
		// Set<Member>
		Set<Member> members = new HashSet<>();
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 85));
		members.add(new Member("홍길동", 80));
		
		Iterator<Member> miter = members.iterator();
		while(miter.hasNext()) {
			Member result = miter.next();
			System.out.println(result.toString());
		}
		
		// int -> Integer 이 두 타입은 boxing과 unboxing을 통해 서로 변환하여 사용가능
		int[] intAry = {10, 20, 30, 40, 20, 10};
		// int배열에서 중복된 값을 제거한 결과를 List 추가
		// List 반복문 활용 출력
		Set<Integer> iset = new HashSet<>();
		for(int i = 0; i < intAry.length; i++) {
			iset.add(intAry[i]); 
		}
		// 반복문 -> List 저장
	    List<Integer> ilist = new ArrayList<>(); 
	    Iterator<Integer> iterator = iset.iterator(); //반복자
	    while(iterator.hasNext()) {
	    	ilist.add(iterator.next());
	    }
	    //반복문 출력
	    ilist.forEach(num -> System.out.println(num));
	} //end of main
}
