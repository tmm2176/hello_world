package com.yedam.varable;

import java.util.Scanner;

// 추가, 수정, 삭제, 목록 출력.
public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		Member 값을 저장할 배열
		Member[] storage = new Member[100]; // 인스턴스 생성 초기값 {null, null, ..., null}
		//편의를 위해 샘플데이터 몇 개 미리 입력
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("김민혁", 86);
		storage[2] = new Member("한수아", 83);
		
		while(run) {
			System.out.println("1. 등록 2. 수정 3. 삭제 4. 출력 5. 평균 6. 종료");
			System.out.print("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());			
//			 1과 엔터 입력시 nextInt는 int형인 1만 처리 가능함.
//			따라서 nextLine로 엔터까지 입력받은 후 int형으로 형변환하여 처리하게 한 것
			String name = "";
			int score = 0;
			Member member = new Member();
			switch(menu) {
			case 1:
				System.out.print("이름입력>> ");
				name = scn.nextLine();
				System.out.print("점수입력>> ");
				score = Integer.parseInt(scn.nextLine());
//				member.name = name;
//				member.score = score;
				member.setMember(name, score);
//				빈 공간에 값을 할당
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] == null) {
						storage[i] = member;
						System.out.println("입력완료");
						break; // 빈 값에 새로운 값을 입력한 경우 종료
					}
				}
				break; // case 1 종료.
			case 2:
				System.out.print("수정할 이름입력>> ");
				name = scn.nextLine();
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						System.out.print("수정할 점수입력>> ");
						score = Integer.parseInt(scn.nextLine());
//						member.name = name;
//						member.score = score;
						member.setMember(name, score);
						storage[i] = member;
//						System.out.println("반환값 테스트 : " + storage[i].getName().equals(name));
						System.out.println("수정완료");
						break;
					}
					else if(storage[i] != null && storage[i].getName().equals(name) != true) {
						System.out.println("해당 이름이 목록에 존재하지 않습니다\n");
						break;
					}
				}
				break; // case 2 종료.
			case 3: // 삭제. 이름입력 조회 후 => null 대입
				System.out.print("삭제할 이름입력>> ");
				name = scn.nextLine();
				for (int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						storage[i] = null;
						System.out.println("삭제완료");
						break;
					}
					else if(storage[i] != null && storage[i].getName().equals(name) != true) {
						System.out.println("해당 이름이 목록에 존재하지 않습니다\n");
						continue;
					}
				}
				break; // case 3 종료.
			case 4:
				System.out.println("이름         | 점수       ");
				System.out.println("========================");
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						System.out.println("이름 : " +storage[i].getName() +
								" | 점수 : " +storage[i].getScore());
						}
				}
				break; // case 4 종료.
			case 5:
				int sumScore = 0;
				int numMem = 0;
				double avgScore = 0;
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						sumScore = sumScore + storage[i].getScore();
						numMem++;
						}
				}
				avgScore = (sumScore * 1.0) / numMem;
//				System.out.println("test(총점 / 학생 수) "+ sumScore + " " + numMem);
				System.out.println("평균 점수 : "+avgScore);
				break; // case 5 종료.
			case 6:
				run = false;
			}
		}
		System.out.println("end of prog.");
	} // end of main()
}