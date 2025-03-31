package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

@WebServlet("/addBoard")
public class AddBoardServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// addForm.jsp -> 3개의 매개변수 값 (title, writer, content)
		// ?title=title&writer=user01&content=content
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		// mybatis를 활용하여 jdbc 처리
		SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession의 매개변수를 true로 하면 자동 commit임, 기본값은 false
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int r = mapper.insertBoard(board);
//		sqlSession.commit();
		
		resp.getWriter().print(r + "건 처리");
		
	} // end of service
} // end of class
