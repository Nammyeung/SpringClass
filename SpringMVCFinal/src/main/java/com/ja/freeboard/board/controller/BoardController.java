package com.ja.freeboard.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.ja.freeboard.vo.UploadFileVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	
	@RequestMapping("/main_page.do")
	public String mainPage(Model model , String search_word , 
		@RequestParam(value = "currPage" , required = false , defaultValue = "1")	int currPage) {
		
		List<Map<String,Object>> list = 
				boardService.getBoardList(search_word,currPage);
		
		int totalCount = 
				boardService.getBoardDataCount(search_word);
		
		//%5 + 1 * 5
		//int beginPage = ((currPage-1)/5)*5 + 1;
		//int endPage = ((currPage-1)/5 + 1)*(5);

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
		
		return "board/write_content_page";
	}
	
	@RequestMapping("/write_content_process.do")
	public String writeContentProcess(MultipartFile [] upload_files ,BoardVo boardVo , HttpSession session) {
		
		
		String uploadRootFolderName = "C:/upload/";
		
		Date today = new Date(); 
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
		String todayFolder = df.format(today);
		
		String saveFolderName = 
				uploadRootFolderName + todayFolder;
		
		File saveFolder = new File(saveFolderName); 	
		
		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		List<UploadFileVo> fileVoList = 
				new ArrayList<UploadFileVo>();
		
		//파일 업로드.. 부분...
		for(MultipartFile file : upload_files) {

			//예외 처리...
			if(file.getSize() <= 0) {
				continue;
			}
			
			//랜덤 이름 짓기....(중복 배제)
			//랜덤 + 시간
			String oriFileName = file.getOriginalFilename();
			
			String saveFileName = UUID.randomUUID().toString();
			saveFileName += "_" + System.currentTimeMillis();
			saveFileName += oriFileName.substring(oriFileName.lastIndexOf("."));
			
			String saveRealPath = 
					saveFolderName + "/" +
					saveFileName;
			
			try {
				file.transferTo(new File(saveRealPath));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//DB를 위한 FileVo객체 생성
			UploadFileVo fileVo = 
					new UploadFileVo();
			
			fileVo.setFile_link_path(todayFolder + "/" + saveFileName);
			fileVo.setFile_real_path(saveRealPath);
			
			fileVoList.add(fileVo);
			
		}
		
		
		
		
		
		//데이터 처리...
		
		MemberVo memberVo = (MemberVo)session.getAttribute("sessionUser");
		
		boardVo.setMember_no(memberVo.getMember_no());
		
		boardService.writeContent(boardVo,fileVoList);
		
		return "redirect:./main_page.do";
	}
	
	
	@RequestMapping("/read_content_page.do")
	public String readContentPage(int board_no,Model model) {
		
		Map<String,Object> map = 
				boardService.getBoard(board_no);
		
		model.addAttribute("aaaa",map);
		
		
		return "board/read_content_page";
	}
	
	@RequestMapping("/delete_content_process.do")
	public String deleteContent(int board_no) {
		boardService.deleteContent(board_no);
		return "redirect:/board/main_page.do";
	}
	
	@RequestMapping("/update_content_page.do")
	public String updateContentPage(int board_no , Model model) {
		
		model.addAttribute("data", boardService.getBoard(board_no));
		
		return "board/update_content_page";
	}
	
	@RequestMapping("/update_content_process.do")
	public String updateContentProcess(BoardVo vo) {
		
		boardService.updateContent(vo);
		
		return "redirect:/board/main_page.do";
	}
	
	
	
}











