package com.yedam.classes;

public class MethodExe2 {
	private Product[] store;
	
	// 생성자
	MethodExe2() {
		store = new Product[10];
		// 샘플데이터
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "샤프2000", 2000);
		store[2] = new Product("C001", "연필500", 500);
		store[3] = new Product("D001", "지우개", 1000);
		store[4] = new Product("E001", "가위", 2500);
		store[5] = new Product("F001", "자", 1500);
	}
	
	// 메소드
	boolean productAdd(Product prd) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] == null) {
				store[i] = prd;
				//System.out.println("등록완료");
				return true;
			}
		} return false;
	} // end of productAdd(Product prd)
	
	// 입력받은 상품 정보 반환, ALL을 입력받을 시 모든 정보 반환
	Product[] productList(Product searchProd) {
		Product[] list = new Product[10];
		int idx = 0;
		for(int i = 0; i < store.length ; i++) {
			if(store[i] != null) {
				if(searchProd.getProductName().equals("ALL")//
						|| store[i].getProductName().equals(searchProd.getProductName())) {
					// 상품가격을 조건으로 추가
					if(store[i].getPrice() >=searchProd.getPrice()) {
						list[idx++] = store[i];
					}
				} // end of if
			} // end of if
		} // end of for
		return list;
	} //end of productList()
	
	// 입력받은 제품을 목록에서 삭제 => boolean remove(string code)
	boolean productRemove(String prdCode) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null //
					&& store[i].getProductCode().equals(prdCode)) {
				store[i] = null;
				return true;
			} // end of if
		} // end of for
		return false;
	} //end of productRemove(String prdCode)
	
	// 입력받은 제품을 목록에서 수정 => boolean modify(Product prd)
	boolean productModify(Product prd) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null //
			    	&& store[i].getProductCode().equals(prd.getProductCode())) {
//			    store[i] = prd;
				if(prd.getProductName() != null) {
					store[i].setProductName(prd.getProductName());
				}
				if(prd.getPrice() != 0) {
					store[i].setPrice(prd.getPrice());
				}
				return true;
			} // end of if
		} // end of for
		return false;
	} // end of productModify(Product prd)
}
