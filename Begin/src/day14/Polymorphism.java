package day14;

public class Polymorphism {

	public static void main(String[] args) {
		//1. Human객체 생성해서 showInfo()
		Human h1=new Human("김시원",165);
	System.out.println(h1.showInfo());
		//2. Superman
		Superman s1=new Superman("김정철",180,230);
		System.out.println(s1.showInfo());
		s1.showInfo("##슈퍼맨 정보###");
		
		//3. Aquaman
		Aquaman a1=new Aquaman("고등어",150,50.22);
		String info=a1.showInfo();
		System.out.println(info);
		
		//다형성
		/*부모와 자식의 상속관계를 맺을 경우
		 * 부모타입의 변수를 선언하고 자식의 객체를 생성하는 것이 가능하다.
		 * 그러나 그 참조 변수로 참조할 수 있는 범위는 제한이 있다.
		 * */
		Human hs = new Superman("최수퍼",188,700);
		System.out.println("hs.name="+hs.name);
		System.out.println("hs.height="+hs.height);
		//System.out.println("hs.power="+hs.power);[x]
		System.out.println("((Superman)hs).power="+((Superman)hs).power);
		System.out.println(hs.showInfo());
		
		Superman s2=(Superman)hs;//[1]
		s2.showInfo("@@@슈퍼맨 정보@@@");
		((Superman)hs).showInfo("@@@슈퍼맨 정보@@@");//[2]
		/*hs로 접근할 수 있는 범위
		 * -부모로 부터 물려받은 변수나 메소드는 접근 가능하다.
		 * - 자식이 가지고 있는 고유한 변수나 메소드는 부모타입으로 접근 불가
		 * -그러나 자식클래스에서 오버라이딩한 메소드가 있을 경우에는
		 * 그오버라이딩한 메소드를 우선 호출한다.
		 * */
		
		
		
		
		
		//Human타입으로 변수 선언하고 Aquaman객체 생성하기
		//이름, 키, 스피드
		//showInfo()호출해보기
		
		Human ha=new Aquaman("최수종",180,220);
		System.out.println("ha.name="+ha.name);
		System.out.println("ha.height="+ha.height);
		System.out.println("((Aquaman)ha).speed="+((Aquaman)ha).speed);//부모 자식 상속관계에 있을 때 형변환 가능
		System.out.println(ha.showInfo());//override한 값이 우선적으로 나오기 때문에 스피드 나옴
	}

}
