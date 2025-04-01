package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		
		BoardVO board = new BoardVO();
//		board.setTitle("mapper test");
//		board.setContent("매퍼를 활용한 입력테스트");
//		board.setTitle("mapper test4");
//		board.setContent("매퍼를 활용한 입력테스트244");
//		board.setWriter("newbie");
//		board.setBoardNo(1);
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
			
//			int r = mapper.insertBoard(board); 
//			// 예전 방식이라고 하심 r = sqlSession.delete("com.yedam.mapper.BoardMapper.deleteBoard", board.getBoardNo());
//			if(r == 1) {
//				System.out.println("등록성공");
//				sqlSession.commit();
//			} else {
//				System.out.println("등록실패");
//			}
//			SearchDTO search = new SearchDTO();
//			search.setKeyword(" ");
//			search.setSearchCondtion(" ");
//			search.setPage(Integer.parseInt(page));
//			List<BoardVO> list = mapper.selectBoard(search);
//			// 이것도 예전 방식인 듯 sqlSession.selectList("com.yedam.mapper.BoardMapper.selectBoard");
//			for(BoardVO brd : list) {
//				System.out.println(brd.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
		}
	} // end of main()
} // end of class
