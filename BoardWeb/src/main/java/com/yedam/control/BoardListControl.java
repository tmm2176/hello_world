package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글 목록 정보 -> jsp
		// 넘어오는 URL 값이 boardList.do?page={page}로 넘어와야함
		System.out.println("목록 접속IP : " + req.getRemoteHost());
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		// getParameter()반환값이 범위 밖일 경우 null을 반환
		// 삼항연산자를 통해 범위 밖의 페이지일 경우(null)을 반환받은 경우 1페이지 출력
		
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		// 글목록 정보 -> jsp
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVO> list = mapper.selectBoard(search);
		req.setAttribute("blist", list);
				
		// 페이징 계산
		int totalCnt = mapper.selectTotal(search);
		PageDTO pageDTO = new PageDTO(totalCnt, Integer.parseInt(page));
		
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		// http://localhost... /boardList.do -> jsp 출력 : 페이지 재지정
		req.getRequestDispatcher("board/boardList2.tiles").forward(req, resp);
	} // end of exec()
} // end of class
