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
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
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
		EtcService svc = new EtcServiceImpl();
		// 정상처리시 목록이동
		if(svc.removeEvent(event)) {
			resp.getWriter().print("{\"retCode\": \"OK\"}");// 요청재지정, 전달할 매개변수가 없을 경우 
		} else {
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	} // end of exec()
} // end of class
