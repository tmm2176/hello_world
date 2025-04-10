package com.yedam.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.service.EtcService;
import com.yedam.service.EtcServiceImpl;
import com.yedam.vo.EventVO;

public class AppMain {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		
		List<Map<String, Object>> list = mapper.selectWriter();

		//출력결과
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
		System.out.println(json);
		
	} // end of main()
} // end of class
