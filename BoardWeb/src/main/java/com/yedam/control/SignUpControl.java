package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equals("GET")) {
			// 1. 회원가입화면 WEB-INF/views/signForm.jsp
			req.getRequestDispatcher("member/signForm.tiles").forward(req, resp);			
		} else {
			// 2. 회원가입처리 (파일업로드 : images, db등록)
			// 1) 요청정보 2) 경로 3) 최대 크기 4) 인코딩 5) 리네임정책
			String saveDir = req.getServletContext().getRealPath("images"); //webapp/images 경로
			int maxSize = 1024 * 1024 * 5; // 최대 크기
			String enc = "UTF-8"; // 인코딩 방식
			MultipartRequest mr = new MultipartRequest(req, saveDir, maxSize, enc, new DefaultFileRenamePolicy());
			// 매개변수 & 값
			String uid = mr.getParameter("userId");
			String upw = mr.getParameter("userPw");
			String unm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");
			
			MemberVO mvo = new MemberVO();
			mvo.setUserId(uid);
			mvo.setPassword(upw);
			mvo.setUserName(unm);
			mvo.setImages(img);
			
			// 업무처리
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(mvo)) {
				resp.sendRedirect("loginForm.do");
			} else {
				System.out.println("처리오류");
			} // end of if
		} // end of if
	} // end of exec()
} // end of class
