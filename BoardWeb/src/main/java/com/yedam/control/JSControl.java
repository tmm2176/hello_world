package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class JSControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// /WEB-INF/views/etc/javaScript.jsp
		req.getRequestDispatcher("etc/javaScript.tiles").forward(req, resp);
	} // end of exec
} // end of class
