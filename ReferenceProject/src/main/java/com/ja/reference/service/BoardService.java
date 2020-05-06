package com.ja.reference.service;
// 기능과 관련된 클래스
// 컨테이너에 등록
// 컨테이너에 주입되어야 함.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.reference.mapper.BoardSQLMapper;
import com.ja.reference.vo.BoardVo;

@Service
public class BoardService{

	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	
	public BoardVo getContent(int b_no) {
		// DB 연동....
		// 데이터 베이스 연동했다고 가정
		return boardSQLMapper.selectByNo(b_no);
		
	}		
	
	
}
