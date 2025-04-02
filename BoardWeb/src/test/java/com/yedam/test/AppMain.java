package com.yedam.test;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AppMain {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login("user1", "1111");
		
		System.out.println(member.toString()); // null 나옴
	} // end of main()
} // end of class
