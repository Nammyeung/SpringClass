package com.ja.freeboard.mapper;

import java.awt.List;

import com.ja.freeboard.vo.ReplyVo;

public interface ReplySQLMapper {
	
	public void insert(ReplyVo replyVo);
	public java.util.List<ReplyVo> selectByBoardNo(int board_no);
	
	
}
