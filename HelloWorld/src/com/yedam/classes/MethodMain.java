package com.yedam.classes;

import java.util.List;
import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		//Scanner scn;
		officeApp();
		
	} // end of main()
	
	static void officeApp() {
		MethodExe2 m2 = new MethodExe2(); // 기능정의
		// 사용자입력 받아서 1. 목록, 2. 추가, 3. 수정, 4.삭제 구현
		// 입력메세지 정의 구현
		String inputProdCode = "";
		String inputProdName = "";
		int inputProdPrice = 0;
		Product newProd = new Product();
		int menu = 0;
		
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;	
		while(run) {
			System.out.println("원하는 메뉴를 입력하세요");
			System.out.println("1. 목록 | 2. 추가 | 3. 수정 | 4. 삭제 | 0. 종료");
		    System.out.print("선택 >> ");
		    menu = Integer.parseInt(scn.nextLine());
		    
		    switch (menu) {
			case 1: // 목록 조회
				System.out.println("상품 목록을 조회합니다");
				System.out.print("상품 이름을 입력해주세요 (모든 상품 조회 : Enter) >> ");
				inputProdName = scn.nextLine();
				
				System.out.print("금액입력 (입력한 금액 이상의 상품만 출력) >> ");
				inputProdPrice = Integer.parseInt(scn.nextLine());
				
				// 검색 필터링
				Product searchProd = new Product();
				searchProd.setProductName(inputProdName);
				searchProd.setPrice(inputProdPrice);
				
				List<Product> list = m2.productList(searchProd);
				for(int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).showProductInfo());
				}
				System.out.println();
				break; // end of case1
			case 2: // 항목 추가
				System.out.println("추가할 물건의 정보를 입력하세요.");
				System.out.print("(추가) 상품코드 입력 >> ");
				inputProdCode = scn.nextLine();
				System.out.print("(추가) 상품이름 입력 >> ");
				inputProdName = scn.nextLine();
				System.out.print("(추가) 상품금액 입력 >> ");
				inputProdPrice = Integer.parseInt(scn.nextLine());
				
//				newProd.setProductCode(inputProdCode);
//				newProd.setProductName(inputProdName);
//				newProd.setPrice(inputProdPrice);
				newProd = new Product(inputProdCode, inputProdName, inputProdPrice);
				
				if(m2.productAdd(newProd) == true) {
					System.out.println("추가완료\n");
				}else if(m2.productAdd(newProd) != true) {
					System.out.println("추가실패\n");
				}
				break; // end of case2
			case 3: //항목 수정
				System.out.println("수정할 물건의 코드를 입력하세요.");
				System.out.print("(수정) 상품코드 입력 >> ");
				inputProdCode = scn.nextLine();
				System.out.println("수정할 물건의 정보를 입력하세요.");
				System.out.print("(수정) 상품이름 입력 >> ");
				inputProdName = scn.nextLine();
				System.out.print("(수정) 상품금액 입력 >> ");
				inputProdPrice = Integer.parseInt(scn.nextLine());
				
				newProd = new Product(inputProdCode, inputProdName, inputProdPrice);
				if(m2.productModify(newProd)) {
					System.out.println("수정성공\n");
				}
				else if(m2.productModify(newProd) == false) {
					System.out.println("수정실패\n");
				}
				break; // end of case3
			case 4: // 항목 삭제
				System.out.println("삭제할 물건의 코드를 입력하세요.");
				System.out.print("(삭제) 상품코드 입력 >> ");
				inputProdCode = scn.nextLine();
				if(m2.productRemove(inputProdCode)) {
					System.out.println("삭제성공\n");
				}
				else if(m2.productRemove("없는거") == false) {
					System.out.println("삭제실패\n");
				}
				break; // end of case4
			case 0:
				run = false; //프로그램 종료
				m2.save(); //프로그램 종료하면서 기록된 내용 저장
				break; // end of case0
			default:
				break; // end of default
			} // end of switch
		    
		} // end of loop
		System.out.println("end of prog.");
	} // end of officeApp()
	
	void method1() {
		MethodExe1 m1 = new MethodExe1(); //MethodExe1 객체의 주소값을 저장 
//		System.out.println(m1);
		// 메소드 호출
		int n = 5;
		m1.printString(n, "*");
		
		double result = m1.sum(n, 10.5);
		System.out.println(result);
		
		int sumInt = m1.sum(new int[] {10, 20, 30});
		System.out.println(sumInt);
		
		double sumDouble = m1.sum(new double[] {10.3, 20.3, 30.4});
		System.out.println(sumDouble);		
	} // end of method1()
	
	void method2() {
		// 상품코드 : M001, 상품명 : 만년필, 가격 : 10000원
		MethodExe2 m2 = new MethodExe2();
		Product prod = new Product("M001", "만년필", 10000);
		
		// 검색 필터링
		Product searchProd = new Product();
		searchProd.setProductName("ALL");
		searchProd.setPrice(1400);
		
		if(m2.productAdd(prod) == true) {
			System.out.println("등록완료");
		}
		List<Product> list = m2.productList(searchProd);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
				System.out.println(list.get(i).showProductInfo());
			}
		}
		System.out.println();
		if(m2.productRemove("B001")) {
			System.out.println("삭제성공");
		}
		else if(m2.productRemove("없는거") == false) {
			System.out.println("삭제실패");
		}
		
		list = m2.productList(searchProd);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
				System.out.println(list.get(i).showProductInfo());
			}
		}
		
		Product newProd = new Product("A001", "변경값", 15570);
		System.out.println();
		if(m2.productModify(newProd)) {
			System.out.println("수정성공");
		}
		else if(m2.productModify(newProd) == false) {
			System.out.println("수정실패");
		}
		list = m2.productList(searchProd);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
				System.out.println(list.get(i).showProductInfo());
			}
		}
	} // end of method2

    void method3() {
		MethodExe3 m3 = new MethodExe3();
//		  System.out.println(m3.gugudan(9,2));
//      m3.printStar(5, "%");
		m3.printCard();
    } // end of method3
    
    void method4() {
//		MethodExe4 m4 = new MethodExe4();
		MethodExe4.main();
    } // end of method4
    
    void method5() {
    	System.out.println("미리 만든거임");
    } // end of method5
    
} // end of class MethodMain
