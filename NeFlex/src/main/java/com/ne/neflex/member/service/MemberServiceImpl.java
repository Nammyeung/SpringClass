package com.ne.neflex.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ne.neflex.mapper.MemberSQLMapper;
import com.ne.neflex.vo.MemberVo;

@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public MemberVo login(MemberVo memberVo) {
		MemberVo vo = memberSQLMapper.selectByIdAndPassword(memberVo);
		
		return vo;
	}
	
	public void joinMember(MemberVo memberVo) {
		int mem_no = memberSQLMapper.createMem_noKey();
		memberVo.setMem_no(mem_no);
		
		memberSQLMapper.insertMember(memberVo);
	}
}
