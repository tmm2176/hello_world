package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno=x 단건조회 modifyBoard.jsp
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVO board = mapper.selectOne(Integer.parseInt(bno));
		
		// 권한체크
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		System.out.println("수정 IP : " + req.getRemoteHost());
		
		if (logId != null && logId.equals(board.getWriter())) {
			// 정상적으로 처리가 된 경우
			// board.jsp 전달
			req.getRequestDispatcher("board/modifyBoard.tiles").forward(req, resp);
		} else {
			req.setAttribute("msg", "권한이 없습니다");
			// 수정하는 화면으로 가지 않도록 설정
			req.getRequestDispatcher("tiles/board.tiles").forward(req, resp);
		}
	} // end of exex()
} //end of class
