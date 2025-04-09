package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EtcService {
	// 등록
	public boolean addEvent(EventVO event);
	// 삭제
	public boolean removeEvent(EventVO event);
	// 전체건수
	public List<EventVO> eventList();
} // end of interface
