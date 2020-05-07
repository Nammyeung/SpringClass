package com.ja.freeboard.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.freeboard.member.service.MemberServiceImpl;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	
	@Autowired
	private MemberServiceImpl memberService;
	
	
	@RequestMapping("/login_page.do")
	public String loginPage() {
		
		return "member/login_page";
	}
	
	@RequestMapping("/join_member_page.do")
	public String joinMemberPage() {
				
		return "member/join_member_page";
	}
	
	@RequestMapping("/join_member_process.do")
	public String joinMemberProcess(MemberVo memberVo, int [] member_hobby) {
//		member_hobby는 구조상 memberVo에 묶어서 받을 수 없다?
		
		memberService.joinMember(memberVo,member_hobby);
		
		return "redirect:./login_page.do";
//		redirect
	}
	
	@RequestMapping("/login_process.do")
	public String loginProcess(MemberVo memberVo , HttpSession session) {
		// 단일 값으로 받을 때는 변수명이 의미가 없다.
		// session에 session을 채워서 넘겨줌
		MemberVo userData = memberService.login(memberVo);
		
		if(userData == null) {
			// 아이디와 비밀번호가 틀린 경우
			return "/member/login_fail";
		} else {
			// 로그인 성공한 경우
			session.setAttribute("sessionUser", userData);
//			session 저장공간에 setAttribute를 sessionUser로 저장
			return "redirect:/board/main_page.do";
			// 슬래시(/)로 받을 때
		}	
	}

}

