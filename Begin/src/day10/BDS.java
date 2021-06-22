package day10;
/*부동산 어플
 * ==> 관련된 객체를 추출
 * 		집, 매도인, 매수인, 중개인, 임대인, 임차인....
 * ==> 추출한 객체를 클래스로 옮기는 것===> 추상화(Abstraction)
 * 				객체의 속성==> 멤버변수
 * 			    기능(행동양식)==> 메소드로
 * */
public class BDS {

	public static void main(String[] args) {
		//클래스 : 설계도. 붕어빵틀 (객체를 만들어내는 틀)
		//객체(Object) : 클래스를 통해 만들어진 구현체 (집, 붕어빵)
		House h1 = new House();//메모리 힙 영역에 올라감 ==> object, instance
		House h2 = new House();
		
		//정보출력하기==> showInfo()
		h1.showInfo();
		h2.showInfo();
		
		h1.owner="홍길동";
		h1.addr="서울 영등포구 양평동";
		h1.room=2;
		
		//h2
		h2.owner="김길동";
		h2.addr="경기도 고양시";
		h2.room=3;
		
		h1.showInfo();
		h2.showInfo();
		
		//h1은 100번지
		String a=h1.existAt(100);
		//h2  150번지
		System.out.println(a);
		
		String b=h2.existAt(150);
		System.out.println(b);

	}

}








