package com.ja.aoptest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl {
	
	private LogAdvice logAdvice = new LogAdvice();
	
	
// implements	
	@Autowired
	private BoardDao boardDao;
//  private은 본래 내부에서만 접근이 가능하지만(setter를 만들어줘야지 주입), @Autowired를 이용하면 가능.(annotation이 setter기능을 내포)
//	앞으로 annotation방식으로 setting을 들어갈 것임.
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	// setter를 public으로 만들어줘야함.
	
	public ArrayList<String> getBoardList() {
//		
//		logAdvice.printLog(jp);
//		비즈니스 로직이 아닌 코드가 들어가고 해당 코드를 떼고 싶다.
		ArrayList<String>list =
					boardDao.selectAll(); // 웬만하면 이러한 방법을 통해 클래스를 생성하지 않고 컨테이너를 생성해 조립
		//		new BoardDao().selectAll();
		
		return list;
//		데이터를 최종적으로 만들고 판단
	
		
	}
	public void login() {
//		logAdvice.printLog();
		System.out.println("로그인 기능 수행....");
		
	} // 비즈니스 로직, 필수 로직
	
	public void getContent() {
//		logAdvice.printLog();
		// 일기와 관련된 중요한 로직......
		System.out.println("컨텐트 가져오기 기능 수행....");
	}
	
	public void adminFunction() {
		//관리자와 관련된 중요한 로직....
//		logAdvice.printLog();
		System.out.println("관리자 기능 수행....");
	}
	
	public void ttt() {
		
	}

}



