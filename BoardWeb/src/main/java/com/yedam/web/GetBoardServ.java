package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

// form태그(jsp) -> 서블릿
// 서블릿 -> jsp (아직 없음)


@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet{
// http://localhost/BoardWeb/getBoard?board_no=13
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		resp.setContentType("text/html;charset=utf-8");
		
		String boardNo = req.getParameter("board_no");
		
		// mybatis를 활용하여 jdbc 처리
		SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession의 매개변수를 true로 하면 자동 commit임, 기본값은 false
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO board = mapper.selectOne(Integer.parseInt(boardNo));
		
		PrintWriter out = resp.getWriter();
		String html = "<h3>상세조회</h3>";
		html += "글번호 : " + board.getBoardNo() + " | 제목 : " + board.getTitle() + " | 내용 : " + board.getContent();
		
		html += "<p><a href='mainservlet'>목록으로</a></p>";
		out.print(html);
	} // end of service()
} // end of class
