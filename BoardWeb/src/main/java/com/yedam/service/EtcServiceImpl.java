package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EtcServiceImpl implements EtcService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
    @Override
    public boolean addEvent(EventVO event) {
        try {
            mapper.addEvent(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
    }
    @Override
    public boolean removeEvent(EventVO event) {
        try {
            mapper.removeEvent(event);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 처리
        }
    }
    @Override
    public List<EventVO> eventList() {
    	return mapper.eventList();
    }
	@Override
	public List<Map<String, Object>> cntPerWriter() {
		return mapper.selectWriter();
	}
	@Override
	public void logCreate(Map<String, String> map) {
		mapper.insertLogging(map);
	}
}
