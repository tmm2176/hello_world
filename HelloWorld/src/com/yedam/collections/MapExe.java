package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookApp.Book;

public class MapExe {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(101, "김민수");
		map.put(102, "김혁수");
		map.put(102, "김혁식"); // 같은 키값의 데이터를 추가한 경우 기존의 키값 데이터 변경 
		// 삭제
		map.remove(101);
		Set<Entry<Integer, String>> eset = map.entrySet();
		for(Entry<Integer, String> entry: eset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		Boolean run = true;
		if (run)
			return;
		
		
		Map<String, Book> books = new HashMap<String, Book>();
		books.put("B001", new Book("이것이자바다", "신용권", "한빛출", 20000));
		books.put("B002", new Book("이거자바아님", "권용신", "두빛출", 25000));
		books.put("B003", new Book("자바는이건가", "용신권", "세빛출", 15500));
		
		// 검색
		Book result = books.get("B001");
		
		// 키값만 가진 set
		Set<String> keyset = books.keySet();
		for(String key: keyset) {
			System.out.println("key: " + key + ", val: " + books.get(key).showList());
		}
		
		// 키:값 쌍의 (Entry) 반환
		// books.entrySet();
		Set<Entry<String, Book>> entryset = books.entrySet();
		for(Entry<String, Book> entry : entryset) {
			System.out.println("key: " + entry.getKey() + ", val: " + entry.getValue().showList());
		}
		
//		// {키: 값}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Gson라이브러리 : 자바객체 -> 문자열
//		String json = gson.toJson(map);
//		System.out.println(json); // 객체 출력
//		
//		Gson gson2 = new GsonBuilder().setPrettyPrinting().create(); // Gson라이브러리 : 자바객체 -> 문자열
//		String json2 = gson2.toJson(books);
//		System.out.println(json2); // 객체 출력
		
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create(); // Gson라이브러리 : 자바객체 -> 문자열
		String json3 = gson3.toJson(result);
		System.out.println(json3); // 객체 출력
	} // end of main()
}
