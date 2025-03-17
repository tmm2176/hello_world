package com.yedam.interfaces;
/*
 * 1차 프로젝트
 * 등록(insert), 수정(modify), 삭제(remove)
 */
public class MysqlDao implements Dao {
	@Override
	public void insert() {
		System.out.println("mysql용 등록");
	} //end of insert()
	@Override
	public void update() {
		System.out.println("mysql용 수정");
	} // end of modify()
	@Override
	public void delete() {
		System.out.println("mysql용 삭제");
	} // end of remove()
}
