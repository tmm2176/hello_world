package com.yedam.classes;

public class MethodExe5 {
    public static void main(String[] args) {
		// 상수선언
    	int num1 = 10;
    	num1 = 20;
    	
    	final int num2 = 20;
//    	num2 = 30; // 상수(final)는 변경불가
    	final Product p1 = new Product();
    	p1.setProductCode("A001");
    	p1.setProductCode("B001");
    	// 인스턴스는 fianl로 선언해도 내부 데이터는 변경 가능함
    	
//    	p1 = new Product(); // 내부 데이터가 아닌 인스턴스 자체를 재할당하는건 불가능
	}
}
