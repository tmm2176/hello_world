package com.yedam.interfaces;

/*
 * Data Access Object 
 * interface에서 생성되는 모든 메소드는 기본적으로 추상 메소드
 * ex) Mysql으로 1차 프로젝트 진행
 *     Oracle로 2차 프로직트 진행 
 */

public interface Dao {
	void insert();
	void update();
	void delete();
	
}
