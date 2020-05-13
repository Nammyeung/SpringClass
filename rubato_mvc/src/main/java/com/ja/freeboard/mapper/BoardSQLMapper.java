package com.ja.freeboard.mapper;

import java.util.*;
import com.ja.freeboard.vo.BoardVo;

public interface BoardSQLMapper {
	
	public void insert(BoardVo boardVo);
	
	public BoardVo selectByNo(int no);
	
	public List<BoardVo> selectAll();
	
	public void deleteByNo(int no);
	
	public void update(BoardVo vo);
	
	public void updateReadCount(int no);
	
	
}
