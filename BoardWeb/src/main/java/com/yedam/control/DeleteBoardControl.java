package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("삭제 IP : " + req.getRemoteHost());
		String bno = req.getParameter("bno");
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		
		// 삭제처리
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int r = mapper.deleteBoard(Integer.parseInt(bno));
		// 정상처리시 목록이동
		if (r > 0) {
			System.out.println("삭제성공");
		    resp.sendRedirect("boardList.do");
		} else {
			System.out.println("삭제오류");
		}
	} // end of exec()
} // end of class
