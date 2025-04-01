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

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno=x&title=변경값&content=변경값 <-의 형식으로 전달받음 수정 후 목록으로 이동
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		
		// 매개값
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		//수정처리
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int r = mapper.updateBoard(board);
		
		// 정상처리시 목록이동
		if (r > 0) {
			System.out.println("수정성공");
		    resp.sendRedirect("boardList.do?page=" + page);
		} else {
			System.out.println("수정오류");
		}
		//req.setAttribute("board", board);
		//req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
	} // end of exex()
} // end of class
