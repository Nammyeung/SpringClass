package com.ja.freeboard.member.controller;

import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.freeboard.member.service.MemberServiceImpl;
import com.ja.freeboard.vo.AuthVo;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private JavaMailSender mailSender;
	
	
	@RequestMapping("/login_page.do")
	public String loginPage() {
		
		System.out.println("호출됨 로그인 페이지..컨트롤러...");
		
		return "member/login_page";
	}
	
	
	
	@RequestMapping("/join_member_page.do")
	public String joinMemberPage() {
				
		return "member/join_member_page";
	}
	
	
	
	@RequestMapping("/join_member_process.do")
	public String joinMemberProcess(MemberVo memberVo, int [] member_hobby) {
//		member_hobby는 구조상 memberVo에 묶어서 받을 수 없다?
		
		//인증 키 생성....
		// 설계 : 자기자신의 주관이 중요함
		AuthVo authVo = new AuthVo();		
		String authKey = UUID.randomUUID().toString();		
		authVo.setAuth_key(authKey);
		
		memberService.joinMember(memberVo, member_hobby, authVo);
		
		//메일 발송....
		//s00112341234
		
		
//		try {
//			
//			
//			MimeMessage message = null;
//		    MimeMessageHelper messageHelper = null;
//	        message = mailSender.createMimeMessage();
//	        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//	        messageHelper.setSubject("[WEB 발송]회원가입을 추카드립니다.");
//	        messageHelper.setText("내용 테스트....", true);
//	        messageHelper.setFrom("111", "FB관리자");
//	        messageHelper.setTo("skaaudtjd@naver.com");
//	        //messageHelper.addInline(contentId, dataSource);
//	        mailSender.send(message);					
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		FBMailSenderThread thread =
				new FBMailSenderThread(
						mailSender, 
						memberVo.getMember_id(), 
						authVo.getAuth_key());
		
		thread.start();
//		thread.run(); // run 호출
		
		
		
		
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
	
	
	@RequestMapping("/certification_process.do")
	public String certificationProcess(String key) {
				
		memberService.certification(key);
		
		return "member/certification_complete";
	}
	
	
	
	@RequestMapping("/logout_process.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/board/main_page.do";
	}

	
	
	@RequestMapping("/testAjax.do")
	public String testAjax() {
		System.out.println("testAjax 호출");
		return "member/testAjax";
	}
	
	@RequestMapping("/confirmId.do")
	@ResponseBody
	public String confirmId(String id) {
		
		System.out.println("넘어온 값 : " + id);
		if(memberService.confirmId(id)) {
			return "true";
		} else {
			return "false";
		}
		
	}
	
}




class FBMailSenderThread extends Thread{
		
	private String to;
	private String authKey;
	private JavaMailSender mailSender;
	
	
	public FBMailSenderThread(JavaMailSender mailSender, String to, String authKey) {
		this.mailSender = mailSender;
		this.to = to;
		this.authKey = authKey;
	}
	
	
	
	public void run() {
		try {			
			MimeMessage message = null;
		    MimeMessageHelper messageHelper = null;
	        message = mailSender.createMimeMessage();
	        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	        messageHelper.setSubject("[WEB 발송]회원가입을 추카드립니다.");
	        
	        String link = "http://localhost:8181/freeboard/member/certification_process.do?key=" + authKey;
	        String text = "";
	        text += "FB 회원 가입을 축하드립니다.<br>";
	        text += "회원가입 완료를 위해 아래 링크를 클릭해 주세요.<br>";
	        text += "<a href='"+link+"'>";
	        text += "링크 클릭";
	        text += "</a>";
	        
	        messageHelper.setText(text, true);
	        messageHelper.setFrom("111", "FB관리자");
	        messageHelper.setTo(to);
	        //messageHelper.addInline(contentId, dataSource);
	        mailSender.send(message);					
						
	        
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}