package com.ja.reference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
/* @RequestMapping("/member") */
public class MappingTest {

	@RequestMapping("/test1")
	public void test1() {
		System.out.println("안녕1");
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("안녕2");
		
		
		return "test1";
	}
	// 리턴 != 리다이렉트
	
	@RequestMapping("/test3")
	public String test3() {
		System.out.println("안녕3");
		// test2를 리다이렉트 : 리다이렉트는 주소가 바뀜
		return "redirect:./test2";
	}
	
	@RequestMapping("/test4")
	public String test4() {
		System.out.println("안녕4");
		return "test1";
	}
		
	
}
