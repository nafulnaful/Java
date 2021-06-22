package day09;
/*클래스 멤버
 * [1] 생성자(constructor) : 객체를 생성할 때 호출되는 일종의 메소드
 * 	-구성하는 방법
 * 		- 1) 생성자 이름은 클래스 이름과 동일해야 한다.
 * 		- 2) 반환타입은 명시하지 않는다.
 *		- 3) 역할:멤버변수(인스턴스변수)들의 초기값을 부여한다.
 *	-사용하는 방법
 *		클래스명 참조변수명 = new 생성자명(); ==> 객체를 생성할 때 호출함
 *
 * [2] 멤버 변수
 * [3] 멤버 메소드
 * */

public class MyDemo {
	int b;//멤버변수(인스턴스 변수) variable, field, property
	static double c;//멤버변수(클래스 변수)
	
	static {
		c=500;//static변수들은 static블럭 안에서 초기화를 한다.
	}//static initializer
	public MyDemo() {//default constructor(기본생성자)
		System.out.println("MyDemo()생성자...");
		b=100;
		
	
	}
	
	
	public static void main(String[] args) {
		int a=0;//지역변수(local variable, automatic field)
		MyDemo md = new MyDemo(); //객체 생성
		MyDemo md2 = new MyDemo();
		MyDemo md3 = new MyDemo();
		//인스턴스변수=> "객체명.변수" 식으로 접근해야 한다.
		System.out.println("md.b="+md.b);
		System.out.println("md.2b="+md2.b);
		System.out.println("md.3b="+md3.b);
		md.b=300;
		md3.b=5000;
		System.out.println("---------------------");
		System.out.println("md.b="+md.b);
		System.out.println("md.2b="+md2.b);
		System.out.println("md.3b="+md3.b);
		
		System.out.println("c="+c);//권장 x
		//static변수"클래스명.변수"식으로 접근한다.
		System.out.println("MyDemo.c="+MyDemo.c);
		
	}

}
