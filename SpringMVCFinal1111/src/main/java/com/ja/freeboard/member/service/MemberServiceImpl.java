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
		
	
	public void joinMember(MemberVo vo, int [] member_hobby, AuthVo authVo) {
		
		String hashCode = FBMessageDigest.digest(vo.getMember_pw());
		vo.setMember_pw(hashCode);
		
//		//비밀번호 해싱....
//				try {
//					
//					String hashCode = "";
//					
//					StringBuilder sb = new StringBuilder();
//					
//					MessageDigest messageDigest 
//						 = MessageDigest.getInstance("SHA-1"); 
//					
//					messageDigest.reset();
//					messageDigest.update(vo.getMember_pw().getBytes());
//					
//					byte[] chars = messageDigest.digest();
//					
//					for(int i = 0 ; i < chars.length ; i++) {
//						
//						String tmp = Integer.toHexString(chars[i] & 0xff);
//						
//						if(tmp.length() == 1) {
//							sb.append("0");
//						}
//						
//						sb.append(tmp);
//					}
//
//					hashCode = sb.toString();
//					
//					vo.setMember_pw(hashCode);
//					
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			
//		
		
		
		//DB연동...
		
		int member_key = memberSQLMapper.createKey();		
		vo.setMember_no(member_key);		
		memberSQLMapper.insert(vo);
		
		authVo.setMember_no(member_key);
		authSQLMapper.insert(authVo);
		
		
		
		//가장 큰 값 가져옴
		
		// hobbySQLMapper.insert(member_key, member_hobby[0]);
		
		if(member_hobby == null) {
			return;
		}
		
		for(int hobby : member_hobby) {
			hobbySQLMapper.insert(member_key, hobby);
		}
	
	}
	
	public MemberVo login(MemberVo vo) {
		// mapper해서 나온 결과를 그대로 세션에 넣음.
		
		String hashCode = FBMessageDigest.digest(vo.getMember_pw());
		vo.setMember_pw(hashCode);
		
		return memberSQLMapper.selectByIdAndPw(vo);
		
	
	}
	
	public void certification(String key) {
				
		authSQLMapper.update(key);
	}
	
	public boolean confirmId(String id) {
		
		if(memberSQLMapper.selectById(id) == null) {
			return true; // 사용 가능
		}else {
			return false; // 사용 불가능(아이디 중복됨)
		}
		
	}
	
}
