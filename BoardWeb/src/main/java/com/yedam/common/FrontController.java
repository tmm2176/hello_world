package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.EventFormControl;
import com.yedam.control.EventListControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;

// *.do의 요청에 실행
public class FrontController extends HttpServlet{
	// 요청 url <=> 실행컨트롤
	Map<String, Control> map;
	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	} // end of FrontController()
	
	//init
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl()); // 메인화면
		
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 목록
		map.put("/addBoard.do", new AddBoardControl()); // 글등록. AddBoardControl
		map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정처리
		map.put("/deleteForm.do", new DeleteFormControl()); // 삭제화면
		map.put("/deleteBoard.do", new DeleteBoardControl()); // 삭제처리
		// 로그인 관련
		map.put("/loginForm.do", new LoginFormControl()); // 로그인 화면
		map.put("/login.do", new LoginControl()); // 로그인처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃 
		
		// 회원가입
		map.put("/signForm.do", new SignUpControl()); // 회원가입화면
		map.put("/signUp.do", new SignUpControl()); // 회원등록
		// 자바스크립트 연습
		map.put("/javaScript.do", new JSControl()); // 회원등록
		//댓글관련
		map.put("/replyList.do", new ReplyListControl()); // 댓글데이터
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글(한 건)삭제
		map.put("/addReply.do", new AddReplyControl()); // 댓글추가
		map.put("/replyCount.do", new ReplyCountControl()); // 댓글 수
		// Datatable 연습용
		map.put("/replyListDataTable.do", new RLDatatable()); //댓글목록
		// fullcalender관련
		map.put("/eventForm.do", new EventFormControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		map.put("/eventList.do", new EventListControl());
	} // end of init()
	
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// URL : 전체 주소값 | URI 프로토콜, 위치, 포트를 제외한 주소값(BoardWeb 부터)
		// http://localhost:8080/BoardWeb/board.do
		String uri = req.getRequestURI();
		System.out.println("요청 URI: " + uri); // /BoardWeb/board.do
		String context = req.getContextPath(); //getContextPath의 반환값이 /BoardWeb/board.do 이거인가?
		String page = uri.substring(context.length()); // page는 /BoardWeb 이후의 마지막 페이지 "/board.do"의 정보를 가짐 
		System.out.println(page);
		
		Control sub = map.get(page); // 키(url) => control 반환
		sub.exec(req, resp);
		
	} // end of service
} //end of class
