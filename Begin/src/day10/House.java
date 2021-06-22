package day10;
/*클래스: 설계도, 틀
 * 1. 속성 (property, attribute)=> 방수, 주소, 소유주,.... ==> 멤버변수
 * 2. 행동양식(behvior) : 집의 정보를 보여주다, 얼마에 렌트하다, 어느주소에 위치하다....==>메소드
 * 
 * */
public class House {
	//1.속성==>"has a"관계를 살펴야 한다.
	int room;//House has a room
	String owner;
	String addr;
	
	//2. 기능,행동양식
	public void showInfo() {
		System.out.println("---House 정보----");
		System.out.println("소유주: "+owner);
		System.out.println("방 수 : "+room);
		System.out.println("주 소 : "+addr);//서울 영등포구 양평동
	}//-------------------
	public String existAt(int bunji) {
		String str=owner+"의 집: "+addr+" "+bunji+"번지에 위치합니다";
		return str;
	}//-------------------
}////////////////////////////////////
