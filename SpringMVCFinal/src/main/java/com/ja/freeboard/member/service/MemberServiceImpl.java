package com.ja.freeboard.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.freeboard.mapper.AuthSQLMapper;
import com.ja.freeboard.mapper.HobbySQLMapper;
import com.ja.freeboard.mapper.MemberSQLMapper;
import com.ja.freeboard.util.FBMessageDigest;
import com.ja.freeboard.vo.AuthVo;
import com.ja.freeboard.vo.MemberVo;

import java.security.*;


@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper; 
	@Autowired
	private HobbySQLMapper hobbySQLMapper;
	@Autowired
	private AuthSQLMapper authSQLMapper; 
	
	public void joinMember(MemberVo vo ,int [] member_hobby, AuthVo authVo) {
		
		String hashCode = FBMessageDigest.digest(vo.getMember_pw());
		vo.setMember_pw(hashCode);
		
		//DB연동...
		
		int member_key = memberSQLMapper.createKey();
		vo.setMember_no(member_key);
		memberSQLMapper.insert(vo);

		authVo.setMember_no(member_key);
		authSQLMapper.insert(authVo);
		
		
		if(member_hobby == null) {
			return;
		}
		
		for(int hobby : member_hobby) {
			hobbySQLMapper.insert(member_key, hobby);
		}
		
	}
	
	public MemberVo login(MemberVo vo) {
		
		String hashCode = FBMessageDigest.digest(vo.getMember_pw());
		vo.setMember_pw(hashCode);
		
		return memberSQLMapper.selectByIdAndPw(vo);
	}

	public void certification(String key) {
		
		authSQLMapper.update(key);
		
	}
	
	public boolean confirmId(String id) {
		
		if(memberSQLMapper.selectById(id) == null) {
			return true; //사용 가능
		}else {
			return false; //사용 불가능 (아이디 중복됨)
		}
			
		
	}
	
	
}












