package com.yedam.common;

import lombok.Getter;
import lombok.ToString;

// 게시글 건수에 따른 페이지 갯수
@Getter
@ToString
public class PageDTO {
	private int startPage; // 현재 페이지가 속한 그룹의 첫 페이지
	private int endPage; // 현재 페이지가 속한 그룹의 마지막 페이지
	private int currentPage; // 현재 페이지
	private boolean prev, next; // 이전, 이후 10개 페이지 여부
	
	public PageDTO(int totalCnt, int page) {
		this.currentPage = page;
		endPage = (int) (Math.ceil(page / 10.0)) * 10;
		startPage = endPage - 9;
		int realEnd = (int) (Math.ceil(totalCnt / 5.0)); // 실제 데이터 건수
		endPage = endPage > realEnd ? realEnd : endPage; 
		// 실제 끝 페이지가 계산한 끝 페이지보다 작은 경우 조정해줌
		// -> 마지막 페이지인 경우 해당하는 이야기임
		// 이전 10개 페이지의 유무
		prev = startPage > 1 ? true : false;
		// 다음 10개 페이지의 유무
		next = endPage < realEnd ? true : false;
	}
} // end of class
