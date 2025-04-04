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


public class AddBoardControl implements Control{
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//resp.setContentType("text/html;charset=utf-8");
		
		if(req.getMethod().equals("GET")) {
			// 요청 재지정만 하면 되는 듯
			// url에 직접 입력, 링크 => get방식 요청
			req.getRequestDispatcher("board/addForm.tiles").forward(req, resp);			
		} else if (req.getMethod().equals("POST")) {
			// 등록
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content") + "\n" + req.getRemoteHost(); 
			System.out.println("등록 IP : " + req.getRemoteHost());
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			// mybatis를 활용하여 jdbc 처리
			SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession의 매개변수를 true로 하면 자동 commit임, 기본값은 false
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			int r = mapper.insertBoard(board);
			
			if(r > 0) {
				System.out.println("등록을 성공했습니다");
				resp.sendRedirect("boardList.do"); // 요청재지정, 전달할 매개변수가 없을 경우 
			} else {
				System.out.println("등록을 실패했습니다");
				
			}
		}
	} // end of exec()
} // end of class
