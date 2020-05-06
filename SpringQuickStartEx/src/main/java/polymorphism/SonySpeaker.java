package polymorphism;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component// Component = Controller
//@Controller
//@Service
@Repository
// Controller를 주로, 경우에 따라서는 Service를 쓰지만 상위 4개는 동일
public class SonySpeaker implements Speaker{
//	Component : 생성이 되서 등록
	public SonySpeaker() {
		System.out.println("소니 스피커 -- 생성");
	}
	
	public void volumeUp() {
		System.out.println("소니 스피커 -- 소리 올림");
	}
	
	public void volumeDown() {
		System.out.println("소니 스피커 -- 소리 내림");
	}
	
	
}
