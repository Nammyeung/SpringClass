package polymorphism;

import java.util.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public int price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BeanFactory factory = new BeanFactory();
		
////	SamsungTv tv = new SamsungTv();
//		Scanner scn = new Scanner(System.in);
//		System.out.println("어떤 TV?>");
//		String command = scn.nextLine();
		
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
//		Context 가동, IOC 컨테이너				
		// xml 파일을 이용해서 인스턴스를 담을 컨테이너 실행
		
		
		TV tv = (TV)factory.getBean("tv"); // Samsung도 들어올 수 있고, Lg도 들어올 수 있다.
		tv = (TV)factory.getBean("tv");
		tv = (TV)factory.getBean("tv");
		tv = (TV)factory.getBean("tv");
//		// TV뿐만 아니라 모든 Object를 넣을 것임.
//		
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
//		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// LgTv tv = new LgTv();
		// 동일한 기능인데 메소드가 통일이 안됨.
		
//		결합도 낮추기 => 인터페이스의 활용
//		각각의 tv에는 표준이 있고 dependency(의존관계)를 이용해 inteface에 의존.
	}

}

