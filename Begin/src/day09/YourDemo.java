package day09;
//생성자 구성하세요.
/*2.멤버변수
 * (1) 인스턴스 변수 (non-static 변수): "객체명.변수" 식으로 접근
 * (2) 클래스 변수 (static 변수)	  : "클래스명.변수" 식으로 접근
 * 			==> static ==> 객체들간에 공유를 한다.
 * */
public class YourDemo {
		   int x=20; //인스턴스 변수
	static int y=30; //클래스 변수

	public YourDemo() {
		
	}
	public static void main(String[] args) {
		//System.out.println("x: "+x);
		YourDemo yd=new YourDemo();
		System.out.println("yd.x="+yd.x);
		
		System.out.println("y: "+y);
		System.out.println("YourDemo.y="+YourDemo.y);//권장한다 위에 문단보다
		System.out.println("yd.y="+yd.y);
	}

}
