package com.ne.neflex.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ne.neflex.member.service.MemberServiceImpl;
import com.ne.neflex.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping("/login_page.ne")
	public String loginPage() {
		return "member/login_page";
	}
	
	@RequestMapping("/login_process.ne")
	public String loginProcess(HttpSession session,MemberVo memberVo) {
		
		MemberVo sessionMemData = memberService.login(memberVo);
		if(sessionMemData != null) {
			session.setAttribute("sessionMemData", sessionMemData);
			return "redirect:/vboard/main_page.ne";
		} else {
			return "member/login_fail_page"; //자바스크립트로 처리 하고 싶음.
		}
	}
	
	@RequestMapping("/join_member_page.ne")
	public String joinMemberPage() {
		return "member/join_member_page";
	}
	
	@RequestMapping("/join_member_process.ne")
	public String joinMemberProcess(MemberVo memberVo) {
		System.out.println("조인 멤버 프로세스.ne");
		memberService.joinMember(memberVo);
		return "redirect:./login_page.ne";
	}
	
	@RequestMapping("/subscription_page.ne")
	public String subscriptionPage() {
		return "member/subscription_page";
	}
	
	@RequestMapping("/payment_page.ne")
	public String paymentPage() {
		return "member/payment_page";
	}
	
	@RequestMapping("subscription_process.ne")
	public String subscriptionProcess() {
		System.out.println("결제 멤버 프로세스.ne");
		return "redirect:/vboard/main_page.ne";
	}
}
