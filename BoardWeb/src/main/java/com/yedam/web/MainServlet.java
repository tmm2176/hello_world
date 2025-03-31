package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

/*
 * tomcat(WAS)의 규칙에 따라 작성
 * 1. url 패턴  (ex : http://localhost/BoardWeb/welcome)
 * 2. 서블릿클래스 (init() -> service() -> destroy()) 서블릿의 생명주기
 */
public class MainServlet extends HttpServlet {
	//생성자
	public MainServlet() {
		System.out.println("MainServlet() 호출");
	} // end of MainServlet
	// 서블릿의 생명주기(init) 최초 호출시 실행될 기능
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()메소드입니다. 최초호출 한 번만 실행");
	} // end of init() 호출될 때마다 실행될 기능
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("service()메소드입니다. 호출될 때마다 실행");
//		BoardDAO dao = new BoardDAO();
//		List<BoardVO> list = dao.boardList();
		
		//위의 주석처리한 두 줄 방식이 아래로 바뀐 것
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  List<BoardVO> list = session.selectList("com.yedam.mapper.BoardMapper.selectBoard");
			
		PrintWriter out = resp.getWriter();
		String html = "<h3>게시글목록</h3>";
		html += "<table border='2'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일시</th></tr></thead>";
		html += "<tbody>";
		for(BoardVO board : list) {
			html += "<tr>";
			html += "<td><a href='getBoard?board_no="+ board.getBoardNo() + "'>" + board.getBoardNo() + "</a></td>";
			html += "<td><a href='getBoard?board_no="+ board.getBoardNo() + "'>" + board.getTitle() + "</a></td>";
			html += "<td>" + board.getContent() + "</td>";
			html += "<td>" + board.getWriter() + "</td>";
			html += "<td>" + board.getWriteDate() + "</td>";
			html += "</tr>";
		} // end of loop
		html += "</tbody></table>";
		out.print(html);
		} // end of try
	} // end of service() 서버 종료시 실행될 기능
	@Override
	public void destroy() {
		System.out.println("destroy()메소드입니다. 서버종료시 실행");
	} //end of destroy
}
