package com.yedam.classes;

import java.io.Serializable;

/*
 * 상품 코드, 상품명, 가격
 */
public class Product implements Serializable{ // 250320 추가 implements Serializable
	
	private String productCode;
	private String productName;
	private int price;
	
	Product(){}
	public Product(String pc, String pn, int price){
		this.productCode = pc;
		this.productName = pn;
		this.price = price;
	}
	public String getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// 목록 출력
	public String showProductInfo() {
		String show = productCode + " " + productName + " " + price;
		return show; 
	}
}