package com.yedam.classes;
import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	private List<Product> store; // 250318 배열에서 List로 전체 수정
	
	// 생성자
	MethodExe2() {
		//store = new Product[10];
		store = new ArrayList<Product>();
		// 샘플데이터
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프2000", 2000));
		store.add(new Product("C001", "연필500", 500));
		store.add(new Product("D001", "지우개", 1000));
		store.add(new Product("E001", "가위", 2500));
		store.add(new Product("F001", "자", 1500));
	}
	
	// 메소드
	boolean productAdd(Product prd) {
		boolean result = store.add(prd);
		return result;
	} // end of productAdd(Product prd)
	
	// 입력받은 조건의 상품 정보 반환, ALL을 입력받을 시 모든 정보 반환
	List<Product> productList(Product searchProd) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size() ; i++) {
			if(searchProd.getProductName().equals("ALL")//
					|| store.get(i).getProductName().equals(searchProd.getProductName())) {
				// 상품가격을 조건으로 추가
				if(store.get(i).getPrice() >=searchProd.getPrice()) {
					list.add(store.get(i));
				}
			} // end of if
		} // end of for
		return list;
	} //end of productList()
	
	// 입력받은 제품을 목록에서 삭제 => boolean remove(string code)
	boolean productRemove(String prdCode) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prdCode)) {
				store.remove(i);
				return true;
			} // end of if
		} // end of for
		return false;
	} //end of productRemove(String prdCode)
	
	// 입력받은 제품을 목록에서 수정 => boolean modify(Product prd)
	boolean productModify(Product prd) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prd.getProductCode())) {
//			    store[i] = prd;
				if(prd.getProductName() != null) {
					store.get(i).setProductName(prd.getProductName());
				}
				if(prd.getPrice() != 0) {
					store.get(i).setPrice(prd.getPrice());
				}
				return true;
			} // end of if
		} // end of for
		return false;
	} // end of productModify(Product prd)
}
