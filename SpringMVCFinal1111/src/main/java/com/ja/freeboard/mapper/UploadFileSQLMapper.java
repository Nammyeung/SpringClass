package com.ja.freeboard.mapper;

import java.awt.List;

import com.ja.freeboard.vo.UploadFileVo;

public interface UploadFileSQLMapper {

//	insert 와 select
	
	public void insert(UploadFileVo fileVo);
	
	public java.util.List<UploadFileVo> selectByBoardNo(int board_no);	
	
	
	
}
