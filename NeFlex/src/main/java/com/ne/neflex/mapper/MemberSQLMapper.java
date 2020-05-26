package com.ne.neflex.mapper;

import com.ne.neflex.vo.MemberVo;

public interface MemberSQLMapper {

	public MemberVo selectByIdAndPassword(MemberVo memberVo);
	
	public void insertMember(MemberVo memberVo);
	
	public int createMem_noKey();
	
}
