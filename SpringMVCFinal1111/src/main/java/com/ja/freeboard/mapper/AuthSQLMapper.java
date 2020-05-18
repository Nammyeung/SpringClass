package com.ja.freeboard.mapper;

import com.ja.freeboard.vo.AuthVo;

public interface AuthSQLMapper {

	
//	필요한 것 : (1) insert (2) update

	public void insert(AuthVo authVo);
	
	public void update(String key);

	public AuthVo selectByMemberNo(int memberNo);

}

