package com.ja.freeboard.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ja.freeboard.vo.BoardVo;

public interface BoardSQLMapper {
	
	public int createKey();
	
	public void insert(BoardVo boardVo);
	
	public BoardVo selectByNo(int no);
	
	public int selectAllCount();
	public int selectByTitleCount(String title);
	
	public List<BoardVo> selectAll(int currPage);

	public List<BoardVo> selectByTitle(
			@Param("title") String title,
			@Param("currPage") int currPage);
	
	public void deleteByNo(int no);
	
	public void update(BoardVo vo);
	
	public void updateReadCount(int no);
}










