package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		
		// 삭제처리
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		int r = mapper.removeEvent(event);
		// 정상처리시 목록이동
		if (r > 0) {
			System.out.println("이벤트 삭제성공");
		    resp.sendRedirect("eventForm.do");
		} else {
			System.out.println("이벤트 삭제실패");
		}
	} // end of exec()
} // end of class
