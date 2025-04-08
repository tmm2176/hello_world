package com.yedam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class AppMain {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		List<Map<String, Object>> list = mapper.selectListForDT(387);
		
		List<List<Object>> slist = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			List<Object> ilist = new ArrayList<>();
			ilist.add(list.get(i).get("REPLY_NO"));
			ilist.add(list.get(i).get("REPLY"));
			ilist.add(list.get(i).get("REPLYER"));
			slist.add(ilist);
		}
		// {"data":[ [],[],[]...[] ]}
		Map<String, Object> result = new HashMap<>();
		result.put("data", list);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		System.out.println(json);
	} // end of main()
} // end of class
