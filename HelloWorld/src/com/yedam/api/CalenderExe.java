package com.yedam.api;

import java.util.Calendar;

public class CalenderExe {
    public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance(); // 2025-03-18
//		cal.set(Calendar.YEAR, 2024); // 2024년
//		cal.set(Calendar.MONTH, 1); // 2월
//		cal.set(Calendar.DATE, 10); // 10일
//		cal.set(2023, 2, 5); // 2023년 3월 5일
//		
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH)); //0월부터 시작
//		System.out.println(cal.get(Calendar.DATE));
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일 (시작은 일요일)
//		System.out.println(cal.getActualMaximum(Calendar.DATE)); //이번 달의 마지막 일
		
		// 년, 월 입력 => 1일의 요일 및 말일을 반환
    	int inputYear = 2025;
    	int inputMonth = 2;
    	
		String week = getDay(inputYear, inputMonth); // 7월달의 1일의 요일
		System.out.println(inputYear + "년 "+ inputMonth + "월 1일의 요일은 " + week);
		int lastDay = getLastDate(inputYear, inputMonth); // 7월달의 마지막날
		System.out.println(inputYear + "년 "+ inputMonth + "월 1일의 마지막 일은 " + lastDay);
    } // end of main()
    
    static String getDay(int year, int month) {
    	int week = 0;
    	Calendar cal = Calendar.getInstance();
    	cal.set(year, month -1, 1);
//		cal.set(Calendar.YEAR, year); // year년
//		cal.set(Calendar.MONTH, month - 1); // month월
//		cal.set(Calendar.DATE, 1); // 1일
		week = cal.get(Calendar.DAY_OF_WEEK); // 요일 (시작은 일요일)
		//System.out.println("test : " + week);
		if(week == 1) {
			return "일요일";			
		}else if(week == 2) {
			return "월요일";
		}else if(week == 3) {
			return "화요일";
		}else if(week == 4) {
			return "수요일";
		}else if(week == 5) {
			return "목요일";
		}else if(week == 6) {
			return "금요일";
		}else if(week == 7) {
			return "토요일";
		}
		return "정확한 값을 입력하시오";
    }
    static int getLastDate(int year, int month) {
    	Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year); // year년
		cal.set(Calendar.MONTH, month - 1); // month월
		//System.out.println("테스트 : " + cal.getActualMaximum(Calendar.DATE));
    	return cal.getActualMaximum(Calendar.DATE);
    }
}