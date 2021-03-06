package com.ja.freeboard.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.HobbySQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.vo.MemberVo;

@Service
public class MemberServiceImpl {

	@Autowired
	private MemberSQLMapper memberSQLMapper;
	@Autowired
	private HobbySQLMapper hobbySQLMapper;
	
	public void joinMember(MemberVo vo, int [] member_hobby) {
		
		int member_key = memberSQLMapper.createKey();
		
		vo.setMember_no(member_key);
		
		memberSQLMapper.insert(vo);
		
		//가장 큰 값 가져옴
		
		//hobbySQLMapper.insert(member_key, member_hobby[0]);
		
		if(member_hobby == null) {
			return;
		}
		
		for(int hobby : member_hobby) {
			hobbySQLMapper.insert(member_key, hobby);
		}	
		
	}
	
	public MemberVo login(MemberVo vo) {
		//mapper해서 나온 결과를 그대로 세션에 넣음.
	
		return memberSQLMapper.selectByIdAndPw(vo);
	
	}
	
}
