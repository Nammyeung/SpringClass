package com.ja.freeboard.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.BoardSQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.mapper.ReplySQLMapper;
import com.ja.freeboard.mapper.UploadFileSQLMapper;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;
import com.ja.freeboard.vo.ReplyVo;
import com.ja.freeboard.vo.UploadFileVo;

import java.util.*;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private BoardSQLMapper boardSQLMapper; 
	@Autowired
	private MemberSQLMapper memberSQLMapper; 
	@Autowired
	private UploadFileSQLMapper uploadFileSQLMapper; 
	@Autowired
	private ReplySQLMapper replySQLMapper; 
	
	
	
	public void writeContent(BoardVo boardVo, List<UploadFileVo> fileVoList) {
		
		int boardKey = boardSQLMapper.createKey();
		boardVo.setBoard_no(boardKey);
		
		boardSQLMapper.insert(boardVo);
		
		for(UploadFileVo fileVo : fileVoList) {
			
			fileVo.setBoard_no(boardKey);
			uploadFileSQLMapper.insert(fileVo);
			
		}
		
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
				new ArrayList<Map<String,Object>>();
		
		List<BoardVo> boardList = null;
		
		if(searchWord == null) {
			boardList =	boardSQLMapper.selectAll(currPage);
		}else {
			boardList =	boardSQLMapper.selectByTitle(searchWord,currPage);
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
	
	
	public Map<String,Object> getBoard(int board_no){
		Map<String,Object> map = 
				new HashMap<String, Object>();
		
		boardSQLMapper.updateReadCount(board_no);
		
		
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		MemberVo memberVo = memberSQLMapper.selectByNo(boardVo.getMember_no());
		List<UploadFileVo> fileVoList = 
				uploadFileSQLMapper.selectByBoardNo(board_no);
		
		
		map.put("memberVo", memberVo);
		map.put("boardVo", boardVo);
		map.put("fileVoList",fileVoList);
		
		return map;
	}
	
	
	public void deleteContent(int board_no) {
		boardSQLMapper.deleteByNo(board_no);
	}

	public void updateContent(BoardVo boardVo) {
		boardSQLMapper.update(boardVo);
	}
	
	
	public List<Map<String,Object>> getRepleList(int board_no){
		List<Map<String,Object>> list = 
				new ArrayList<Map<String,Object>>();
		
		List<ReplyVo> replyVoList = 
				replySQLMapper.selectByBoardNo(board_no);
		
		for(ReplyVo replyVo : replyVoList) {
			
			MemberVo memberVo = 
					memberSQLMapper.selectByNo(replyVo.getMember_no());
			
			Map<String,Object> map = 
					new HashMap<String, Object>();
			
			map.put("memberVo", memberVo);
			map.put("replyVo", replyVo);
			
			list.add(map);
		}
		
		
		return list;
	}
	
	public void writeReply(ReplyVo replyVo) {
		replySQLMapper.insert(replyVo);
	}
	
	
}










