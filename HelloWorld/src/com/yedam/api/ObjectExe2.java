package com.yedam.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectExe2 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());
	
		Date obj2 = new Date();
		System.out.println(obj2.toString());
		
		// 출력 2025년 03월 17일 13시 23분 45초 << 출력 포멧을 희망
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(obj2));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf2.format(obj2));
		
	} // end of main
	
}