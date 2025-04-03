package com.yedam.service;

import com.yedam.vo.MemberVO;

// 업무 프로세스(service)
public interface MemberService {
	// 로그인
	MemberVO login(String id, String pw);
	boolean addMember (MemberVO member); // 회원등록
} // end of interface
