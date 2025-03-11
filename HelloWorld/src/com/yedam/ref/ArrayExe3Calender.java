package com.yedam.ref;

public class ArrayExe3Calender {
	// 2025년 기준으로 월 정보 입력 시 1일의 위치를 반환
	public static int getFirstDay(int month) {
		switch(month) {
		case 1:
			return 3;
		case 2:
			return 6;
		case 3:
			return 6;
		case 4:
			return 2;
		default:
			return 1;
		}
	}
	// 2025년 기준으로 월 정보 입력시 총 날짜를 반환
	public static int getLastDate(int month) {
		switch(month) {
		case 2:
			return 28;
		case 4:
			return 30;
		case 6:
			return 30;
		case 9:
			return 30;
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	public static void main(String[] args) {
		String[] days = {"Sun ", "Mon ","Tue ","Wed ","Thu ","Fri ","Sat "};
		for (int i = 0; i < days.length; i++) {
			System.out.print(days[i]);
		}
		System.out.println("\n============================");
		int thisMonth = 3;
		int space = getFirstDay(thisMonth); // 1일의 위치값 지정
		int lastDate = getLastDate(thisMonth); // 마지막 날
		for (int i = 0; i < space; i++) {
			System.out.print("    ");
		}
	    for(int i = 1 ; i <= lastDate; i++) {
//	    	방법 1=====================================
//	    	String d = String.format("%4s", i);
//	    	if (i == 21) {
//	    		System.out.print(" 평가");	
//	    	}
//	    	else if(i != 21) {
//	    		System.out.print(d);	    		
//	    	}
//	    	
//	    	방법 1=====================================
//          방법 2=====================================
	    	if (i == 21) {
	    		System.out.print(" 평가");
	    	}
	    	else if(i != 21) {
	    		if(String.valueOf(i).length() == 1) {
	    			System.out.print("   " + i);
	    		}
	    		else if(String.valueOf(i).length() == 2)
	    			System.out.print("  " + i);	    		
	    	}
//	    	방법 2=====================================
//          한 주마다 줄바꿈 (고정 부분)
	    	if ((space + i) % 7 == 0) {
	    		System.out.println();
	    	}
	    }
	} // end of main()
}
