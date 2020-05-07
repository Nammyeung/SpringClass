package com.ja.reference.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.reference.service.BoardService;
import com.ja.reference.vo.BoardVo;


@Controller // ContextPath / 
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired // 클래스 인스턴스들이 어디에 등록되고 주입되었는지
	private BoardService boardService;	
	
	
	@RequestMapping("/read_content_page.do")
	public String xxxxx(int b_no, Model model) {
		
	
		BoardVo boardVo = boardService.getContent(b_no);
		
		model.addAttribute("boardVo", boardVo);
				
		
		
		
		return "read_content_page";
	}
	
	
}
