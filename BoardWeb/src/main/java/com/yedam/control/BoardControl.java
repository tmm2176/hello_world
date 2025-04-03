package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글 목록 정보 -> jsp
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardVO board = mapper.selectOne(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		// http://localhost... /board.do -> jsp 출력 : 페이지 재지정
		// board.jsp에 전달
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
	} // end of exec()
} // end of class
