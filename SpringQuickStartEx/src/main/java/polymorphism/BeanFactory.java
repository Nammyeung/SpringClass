package polymorphism;

public class BeanFactory {
		
	public Object getBean(String beanName) {
		
		if(beanName.equals("삼성")) {
			return new SamsungTv();
		}else if(beanName.equals("엘지")) {
			return new LgTv();
		}
		
		return null;
	}
}
