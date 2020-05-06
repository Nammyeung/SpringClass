package polymorphism;

public class SamsungTv implements TV{
	
	private Speaker speaker;
	private int price; // 생성이 될 때 null이 아닌 0	
	
	public SamsungTv() {
		System.out.println("삼성 --- 기본 생성자 호출됨");
	}
	
	public SamsungTv(SonySpeaker speaker) {
		this.speaker = speaker;
		System.out.println("삼성 --- 주입생성자1 호출됨");
//		컨테이너가 가동될 때 삼성tv와 소니스피커 가동
	}
	
//	소니 스피커, 애플 스피커 둘 다 받을 수 있음.
	public SamsungTv(Speaker speaker, int price) {
		this.price = price;
		this.speaker = speaker;
		System.out.println("삼성 --- 주입생성자2 호출됨");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker; // 생성자로 주입 or setter로 주입
	}
	
	public void powerOn() {
		System.out.println("삼성 --- 전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("삼성 --- 전원 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("삼성 --- 소리 올림.");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	
	}
	
	public void volumeDown() {
		System.out.println("삼성 --- 소리 내림.");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
	public void initMethod() {
		System.out.println("삼성 --- 초기화 코드...");
	}
}
