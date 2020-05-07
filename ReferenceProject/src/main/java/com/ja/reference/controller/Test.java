package com.ja.reference.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class Test {
	
	
//	@RequestMapping("/test1")
//	@PostMapping("/test1") // get방식으로는 못받음
	@GetMapping("/test1")
	public String test1() {
			System.out.println("안녕1");
			return "test1";
	}
	
	
	@RequestMapping("/test2")
	public String test2(HttpSession session) {
				
		session.invalidate();
		session.setAttribute("xxx", 1111);
		session.getAttribute("xxx");
		
		return "test1";
	}
	
	@RequestMapping("/test3")
	public String test3(Model model) {
		
		String title = "제목입니다....";
		
		model.addAttribute("title",  title);
		
		return "test1";
		// model에 포워딩
	}
	
	
	
	
	
}
