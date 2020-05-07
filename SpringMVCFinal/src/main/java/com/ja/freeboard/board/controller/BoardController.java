package com.ja.freeboard.board.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.freeboard.board.service.BoardServiceImpl;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;	
	
	@RequestMapping("/main_page.do")
	public String mainPage(Model model) {
		
		List<Map<String,Object>> list = 
				boardService.getBoardList(); // List안에 Hashmap	
		// ArrayList vs List안에 Map
		
		model.addAttribute("dataList", list);
				
		return "board/main_page";
	}
	@RequestMapping("/write_content_page.do")
	public String writeContentPage() {
		
		return "/board/write_content_page";
	}
	@RequestMapping("/write_content_process.do")
	public String wrtieContentProcess(BoardVo boardVo, HttpSession session) {
		//session은 Object로 들어가기 때문에 형변환을 해야한다.
		MemberVo memberVo = (MemberVo)session.getAttribute("sessionUser");
		
		boardVo.setMember_no(memberVo.getMember_no());
				
		boardService.writeContent(boardVo);
				
		return "redirect:/board/main_page.do";
	}
	
}