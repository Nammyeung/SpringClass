package com.ne.neflex.vboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vboard/*")
public class VBoardController {

	@RequestMapping("/main_page.ne")
	public String mainPage() {
		return "vboard/main_page";
	}
	
}
