package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {
		
		MethodExe3 m3 = new MethodExe3();
//		  System.out.println(m3.gugudan(9,2));
//        m3.printStar(5, "%");
		m3.printCard();
	} // end of main()
	
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
		Product[] list = m2.productList(searchProd);
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].showProductInfo());
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
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].showProductInfo());
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
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].showProductInfo());
			}
		}
	} // end of method3
}


