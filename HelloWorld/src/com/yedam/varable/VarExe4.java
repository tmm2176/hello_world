package com.yedam.varable;

import java.util.Scanner; 

public class VarExe4 {
	public static void main(String[] args) {
		int[] scores = new int[3];
//		{0, 0, 0} 정수 값을 3개 담을 수 있는 배열
//		int는 초기값이 0으로 지정되어있다고 함
		
		Scanner scn = new Scanner(System.in);
		int sumScore = 0;
		
		for(int i = 0; i < scores.length; i++) {
//		점수를 입력하세요
			System.out.print("점수를 입력하세요>");
//		값 입력
			scores[i] = scn.nextInt();
//		입력값의 합을 콘솔에 출력
			System.out.println("입력한 값: " + scores[i]);
			sumScore = sumScore + scores[i];
		}
//		합은 '결과'입니다. 출력
		double avgScore = sumScore * 1.0 / scores.length;
		System.out.println("합은 " + sumScore + "입니다");
		System.out.println("평균은 " + avgScore + "입니다");
		
	} // end of main()
}
