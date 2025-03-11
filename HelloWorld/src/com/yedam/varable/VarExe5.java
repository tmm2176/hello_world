package com.yedam.varable;

import java.util.Scanner;
// (ctrl + shift + o) => import 단축키
// 예금과 출금, 잔고 확인을 할 수 있는 프로그램

public class VarExe5 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; // 예금액을 저장하는 변수
		// 10만원 최대, 잔액이 음수가 되지 않도록 조건 지정
		Scanner scn = new Scanner(System.in);
		while(run) {
			System.out.println("1. 예금, 2. 출금 3. 잔고 4. 종료");
			int menu = scn.nextInt();
			int inputMoney = 0;
			switch(menu) {
			case 1:
				System.out.print("예금 금액을 입력>> ");
				inputMoney = scn.nextInt();
				if(balance + inputMoney > 100000) {
					System.out.println("최대 금액은 10만원 입니다. ");
				}
				else if(balance + inputMoney <= 100000) {
					balance = balance + inputMoney;
				}
				break; // case 1 종료.
			case 2:
				System.out.print("출금 금액을 입력>> ");
				inputMoney = scn.nextInt();
				if(balance - inputMoney < 0) {
					System.out.println("잔액이 부족해 출금할 수 없습니다.");
				}
				else if(balance - inputMoney >= 0) {
					balance = balance - inputMoney;
				}
				break; // case 2 종료.
			case 3:
				System.out.println("현재 잔액은 "+ balance +"입니다");
				break; // case 3 종료.
			case 4:
				run = false;
			}
			
		}
		System.out.println("end of prog.");
	} // end of main()
}
