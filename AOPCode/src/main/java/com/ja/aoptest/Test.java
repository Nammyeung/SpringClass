package com.ja.aoptest;

import org.springframework.web.servlet.view.*;


public class Test {
	
	
	public void ssss() {
		
		InternalResourceViewResolver aa =
				new InternalResourceViewResolver();
//		setter를 호출
		
		aa.setPrefix("/WEB-INF/views/");
		aa.setSuffix(".jsp");
		
	}
	
}
