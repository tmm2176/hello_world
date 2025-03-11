package com.yedam.varable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
//		 임의의 정수 1 ~ 50 사이의 값
		int randScores[] = new int[5];
		int randNames[] = new int[5];
		
//		 정수(int) -> 5개 저장
//		---------생성 난수 테스트---------
//		int randMax = 30;
//		int randMin = 101;
		
		for(int i = 0; i < randScores.length; i++) {
//			학생의 점수 (30 ~ 100)사이의 점수
			randScores[i] = (int)(Math.random() * 71) + 30; // 0 <= x < 1
			
//	      학생의 점수 (30 ~ 101 사이의 점수)
			if(randScores[i] % 2 == 1) {
				System.out.println( i + "번 홀수 : " + randScores[i]);				
			}
//			---------짝수 생성 테스트---------
//			else if(randArr[i] % 2 == 0) {
//				System.out.println("짝수xxxxxxx : " + randArr[i]);				
//			}
//			---------생성 난수 테스트---------
//			if(randScores[i] > randMax) randMax = randScores[i];	
//			if(randScores[i] < randMin) randMin = randScores[i]; 		
		}
//		---------생성 난수 테스트---------
//		System.out.println("생성된 최대 난수 값 : " + randMax + "\n생성된 최소 난수 값 : " +randMin);


		// 홀수의 값만 출력
	} // end of test()
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		Member m1 = new Member(); // 인스턴스 생성
		m1.setName("홍길동");
//		System.out.println(m1.score);
		Member m2 = new Member(); // 인스턴스 생성
		m2.setName("최민수");
		Member m3 = new Member(); // 인스턴스 생성
		m3.setName("김병수");
		Member m4 = new Member(); // 인스턴스 생성
		m4.setName("박인만");
		
//		배열
		Member[] members = { m1, m2, m3, m4 };		
//        int maxScore = 0;
//        String maxScoreMem = ""; 
		System.out.print("조회할 이름 입력>> ");
        String inputName = scn.nextLine();
        int searchScore = 0;
        int checkMemFlag = 0;
        
        // 조회이름을 입력 - > 점수 출력
		for(int i = 0; i < members.length; i++) {
			//		70 ~ 100 사이의 임의값으로 점수지정
			members[i].setScore((int)(Math.random() * 30) + 70);
//			if(members[i].score > maxScore) {
//				maxScore = members[i].score;
//				maxScoreMem = members[i].name;
//			}
			if(members[i].getName().equals(inputName)) {
				searchScore = members[i].getScore();
				checkMemFlag = 1;
			}
//				test code
			System.out.println("이름 : "+ members[i].getName() +" / 점수 : " + members[i].getScore());
		}
//		점수가 가장 높은 사람의 이름을 출력
//		System.out.println("\n최고점 : " + maxScoreMem + " "+ maxScore + "점");
//		입력한 사람의 점수를 출력
		if(checkMemFlag == 1) {
			System.out.println("조회한 이름 : " + inputName + " / 점수 " + " "+ searchScore + "점");			
		}
		else if (checkMemFlag == 0) {
			System.out.println("해당 이름이 목록에 존재하지 않습니다\n");
		}
	} // end of main()
}
