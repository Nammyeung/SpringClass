package com.ja.aoptest;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller : 등록 @Autowired : 조립
@Controller // annotation(주석)
// (1) annotation으로 등록
// (2) xml로 등록
public class BoardController {
	
	@Autowired // 컨테이너 내부에서 조립해서 주입
	private BoardServiceImpl boardService; // 변수의 형태에 인스턴스가 하나라도 있으면 주입
//	참조 주소 변수만 만듬
	
	
	
	@RequestMapping("/main_page.do")
	public String mainPage(HttpServletRequest request) {
				
//		BoardServiceImpl s =
//				new BoardServiceImpl();
		
		ArrayList<String> list = boardService.getBoardList();
		
		request.setAttribute("xxxx",  list);
		
		return "main_page";
	}
	
	@RequestMapping("read_content_page.do")
	public String readContentPage() {
		
		return "read_content_page";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		
		boardService.adminFunction();
		
		boardService.getContent();
//		point컷 설정이 되어있어 로그가 찍힘
		//관리자와 관련된 중요한 로직...
		return "aaaa";
	}
	
}
