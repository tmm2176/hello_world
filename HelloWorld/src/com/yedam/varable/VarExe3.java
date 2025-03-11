package com.yedam.varable;

import java.util.Scanner; 
// java.util.Scanner를 굳이 전부 입력하지 않아도 괜찮음

// 사용자의 입력값을 읽어들이는 방식
// Scanner 클래스
public class VarExe3 {
	public static void main(String[] args) {
//		java.util.Scanner scn = new java.util.Scanner(System.in);
		Scanner scn = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요>");
		String name = scn.nextLine(); //nextLine => 메소드 (함수)
		System.out.print("점수를 입력하세요>");
		int score = scn.nextInt();
		System.out.print("키를 입력하세요>");
		double height = scn.nextDouble();
		
		System.out.println("입력한 값: " + name + ", 점수: " + score + ",키: "+ height);
	} // end of main()

}
