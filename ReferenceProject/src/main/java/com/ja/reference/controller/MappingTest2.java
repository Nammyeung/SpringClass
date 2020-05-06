package com.ja.reference.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.reference.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class MappingTest2 {

	@RequestMapping("/test1")
	public String test1(HttpServletRequest re) {
		
		String aa = re.getParameter("aa");
		String bb = re.getParameter("bb");
				
		
		System.out.println("안녕1" + aa + bb);		
		
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2(int aa, int bb) {
		System.out.println("안녕2" + aa + bb);
		
		return "test1";
		
	}
	
	@RequestMapping("/test3")
	public String test3(
			@RequestParam("aa") int v1,   //aa 파라미터를 v1에 넣어줌
			@RequestParam("bb") int v2) { //bb 파라미터를 v2에 넣어줌
		
		// 파라미터명이 v1, v2인 애들을 받겠다.
		
		System.out.println("안녕3:" + v1 + v2);
		
		return "test1";
	}
	
	@RequestMapping("/test4")
	public String test4(MemberVo vo) {
		
		System.out.println(vo.getM_id());
		System.out.println(vo.getM_pw());
		System.out.println(vo.getM_nick());
		
		
		return "test1";
	}
	
	@RequestMapping("/test5/{pid}/{xxx}")// 알아서 변수에다가 분류해서 넣어줘
	public String test5(
		@PathVariable("pid") int pid ,
		@PathVariable("xxx") int xxx
		) {
		
		System.out.println(pid);
		System.out.println(xxx);	
			
		return "test1";
	
	
	}
	
}
