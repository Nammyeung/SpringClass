package com.ja.freeboard.board.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.BoardSQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardSQLMapper boardSQLMapper;
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void writeContent(BoardVo boardVo) {
	// Controller에 채워서 넘겨줌
		boardSQLMapper.insert(boardVo);		
	}
	
	
	public int getBoardDataCount(String searchWord) {
		
		if(searchWord == null) {
			return boardSQLMapper.selectAllCount();
		}else {
			return boardSQLMapper.selectByTitleCount(searchWord);
		}
		
		
	}
	
	
	public List<Map<String,Object>> getBoardList(String searchWord , int currPage){
		
		
		List<Map<String,Object>> list =
				new ArrayList<>();
		
		List<BoardVo> boardList = null;
		
		if(searchWord == null) {
			boardList =
					boardSQLMapper.selectAll(currPage);
					
		} else {
			boardList =
					boardSQLMapper.selectByTitle(searchWord, currPage);
		}
		
			
		
		
		for(BoardVo boardVo : boardList) {
			
			MemberVo memberVo = 
					memberSQLMapper.selectByNo(boardVo.getMember_no());
			
			Map<String,Object> map
				= new HashMap<String,Object>();
			
			map.put("memberVo", memberVo);
			map.put("boardVo", boardVo);
			
			list.add(map);
		}
				
		return list;
	}
	
	
	
	public Map<String, Object> getBoard(int board_no) {
		
		Map<String, Object> map =
				new HashMap<String, Object>();
		
		boardSQLMapper.updateReadCount(board_no);
				
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		MemberVo memberVo = memberSQLMapper.selectByNo(boardVo.getMember_no());
//		memberSQLMapper.selectByNo(boardVo.getBoard_no());
		
		map.put("memberVo", memberVo);
		map.put("boardVo", boardVo);
		// map계열은 순서가 없다.
		
		
		return map;
	}	
	
	public void deleteContent(int board_no) {
	
		boardSQLMapper.deleteByNo(board_no);
	}
	
	public void updateContent(BoardVo boardVo) {
		
		boardSQLMapper.update(boardVo);
		
	}
	
	
	
}
