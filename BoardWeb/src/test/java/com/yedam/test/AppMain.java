package com.yedam.test;

import java.util.List;

import com.google.gson.Gson;
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
import com.yedam.vo.EventVO;

public class AppMain {
	public static void main(String[] args) {
		EtcService svc = new EtcServiceImpl();
		List<EventVO> list = svc.eventList();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
	} // end of main()
} // end of class
