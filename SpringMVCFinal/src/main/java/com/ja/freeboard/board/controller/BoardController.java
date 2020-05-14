package com.ja.freeboard.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.freeboard.board.service.BoardServiceImpl;
import com.ja.freeboard.vo.BoardVo;
import com.ja.freeboard.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;	
	
	
	
	
	@RequestMapping("/main_page.do")
	public String mainPage(Model model , String search_word, 
		@RequestParam(value = "currPage" , required = false, defaultValue = "1") int currPage) {
		
//		defaultValue 역할
//		if(currPage <= 0) {
//			currPage = 1; // 1page부터
//		}
		
		List<Map<String,Object>> list = 
				boardService.getBoardList(search_word, currPage); // List안에 Hashmap	
		// ArrayList vs List안에 Map
		
		int totalCount = 
				boardService.getBoardDataCount(search_word);
		
		//%5 + 1 * 5		
		
		int beginPage = ((currPage-1)/5)*5 + 1;
		int endPage = ((currPage-1)/5 + 1)*(5);
		
		if (endPage > ((totalCount-1)/10) + 1) {
			endPage = ((totalCount-1)/10) + 1;
		}
		
		model.addAttribute("beginPage",beginPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("currPage",currPage);
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("dataList",list);
				
		return "board/main_page";
	}
	
	
	
	
	@RequestMapping("/write_content_page.do")
	public String writeContentPage() {
		
		return "/board/write_content_page";
	}
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	
	
	
	@RequestMapping("/write_content_process.do")
	public String writeContentProcess(MultipartFile [] upload_files, BoardVo boardVo, HttpSession session) {
		//session은 Object로 들어가기 때문에 형변환을 해야한다.		
//		upload_files[0].transferTo(new File("C:/upload"));
		
		String uploadRootFolderName = "C:/upload";
		
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String todayFolder = df.format(today);
		 
		String saveFolderName = 
				uploadRootFolderName + todayFolder;
		
		File saveFolder = new File(saveFolderName);
		
		if(!saveFolder.exists()) {		
			saveFolder.mkdirs();
		}
		
		
		//파일 업로드.. 부분...
		for(MultipartFile file : upload_files) {
			
			System.out.println("test : " + file.getOriginalFilename());
			System.out.println("test : " + file.getSize());
			
			//예외 처리...
			if(file.getSize() <=0) {
				continue;
			}
		
			String saveFileName =
					saveFolderName + "/" +
				    file.getOriginalFilename();
			
			/*
			 * String saveFileName = uploadRootFolderName + file.getOriginalFilename();
			 */
			
			try {
				file.transferTo(new File(saveFileName));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//데이터 처리...
		
		MemberVo memberVo = (MemberVo)session.getAttribute("sessionUser");
		
		
		boardVo.setMember_no(memberVo.getMember_no());
				
		
		boardService.writeContent(boardVo);
				
		
		return "redirect:/board/main_page.do";
	}
	
	
	
	
	@RequestMapping("/read_content_page.do")
	public String readContentPage(int board_no, Model model) {
		
		Map<String, Object> map = 
				boardService.getBoard(board_no);
		
		model.addAttribute("aaaa", map);
			
		return "board/read_content_page";
	}
	
	
	
	
	@RequestMapping("/delete_content_process.do")
	public String deleteContent(int board_no) {		
		boardService.deleteContent(board_no);		
		return "redirect:/board/main_page.do";
	}
	
	
	
	
	@RequestMapping("/update_content_page.do")
	public String updateContentPage(int board_no, Model model) {
//		model에 담아서 포워딩(forwarding)
		
		model.addAttribute("data", boardService.getBoard(board_no));
//		Map<String, Object> boardService.getBoard(board_no);
		
		
		return "board/update_content_page";
	}
	
	
	
	
	@RequestMapping("/update_content_process.do")
	public String updateContentProcess(BoardVo vo) {
		
		boardService.updateContent(vo);
		
		
		return "redirect:/board/main_page.do";
	}
	
	
	
}
