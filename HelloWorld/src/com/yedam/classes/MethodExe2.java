package com.yedam.classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MethodExe2 {
	private List<Product> store; // 250318 배열에서 List로 전체 수정
	
	// 생성자
	MethodExe2() {
		init();
//		store.add(new Product("A001", "지우개", 500));
//		store.add(new Product("B001", "샤프2000", 2000));
//		store.add(new Product("C001", "연필500", 500));
//		store.add(new Product("D001", "지우개", 1000));
//		store.add(new Product("E001", "가위", 2500));
//		store.add(new Product("F001", "자", 1500));
	}
	
	// 250320 변경
	void init() { // 이전 init은 한 라인씩 읽은 후 추가하는 작업을 반복했었음
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat"); //파일 읽어오기
			ObjectInputStream ois = new ObjectInputStream(fis);
			store = (List<Product>) ois.readObject(); // 기본타입 -> 객체 readObjact의 반환은 object
		} catch (Exception e) {
			// e.printStackTrace();
		}
	} // end of init
	
	// 250320 변경
	void save() { // 이전 save는 반복문을 돌면서 저장했었음
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(store); // ArrayList<Product>()
			oos.flush();
			oos.close(); fos.close(); //선언했던 것들은 close해줘야함
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of save
	
	void initPrev() {
		store = new ArrayList<Product>(); // 샘플데이터 ()store = new Product[10];)
		try {
			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while(true){
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" ");
				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
			} // end of loop
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일을 다 읽어서 더 읽을게 없는 경우 아무 동작없이 그냥 넘어감
			// System.out.println("end of file");
		}
		//초기화 끝		
	} //end of init()
	
	// 종료시점 store 정보를 messge.txt에 저장
	void savePrev() {
		// 입력값을 파일출력
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			for(Product prod : store) {
		        writer.write(prod.getProductCode() + " ");
		        writer.write(prod.getProductName() + " ");
		        writer.write(prod.getPrice() + "\n");
		        writer.flush();
			} //end of loop
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("end of prog");
	}
	
	// 메소드
	boolean productAdd(Product prd) {
		boolean result = store.add(prd);
		return result;
	} // end of productAdd(Product prd)
	
	// 입력받은 조건의 상품 정보 반환, Enter 입력받을 시 모든 정보 반환
	List<Product> productList(Product searchProd) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size() ; i++) {
			if(searchProd.getProductName().isBlank()//
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
