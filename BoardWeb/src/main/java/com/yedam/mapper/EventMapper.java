package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.EventVO;

public interface EventMapper {
	// 등록
	int addEvent(EventVO event);
	// 삭제
	int removeEvent(EventVO event);
	// 전체건수
	List<EventVO> eventList();
	// 차트
	List<Map<String, Object>> selectWriter();
	// 로그
	int insertLogging(Map<String, String> map);
} // end of interface
