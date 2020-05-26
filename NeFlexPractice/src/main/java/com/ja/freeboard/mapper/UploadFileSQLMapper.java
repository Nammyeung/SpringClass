package com.ja.freeboard.mapper;

import java.util.List;

import com.ja.freeboard.vo.UploadFileVo;

public interface UploadFileSQLMapper {

	public void insert(UploadFileVo fileVo);
	
	public List<UploadFileVo> selectByBoardNo(int boardNo);
	
}








