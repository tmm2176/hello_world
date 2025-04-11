package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 요청방식 : post

		String title = req.getParameter("title");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate"); 	
		
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession의 매개변수를 true로 하면 자동 commit임, 기본값은 false
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		int r = mapper.addEvent(event);
		
		if(r > 0) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");// 요청재지정, 전달할 매개변수가 없을 경우 
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	} // end of exec()

}
