package day20;
import day20.Outer;

public class InnerClassTest {

	public static void main(String[] args) {
		//1. Outer클래스의 a,b 변수값을 출력하세요
		System.out.println("Outer.b: "+Outer.b);
		
		Outer o1=new Outer();
		System.out.println("o1.a: "+o1.a);
		//2. Outer.Inner 클래스의 c변수값 출력하기, foo()호출하기
		//Outer o2=new Outer();
		//Outer.Inner oi=o2.new Inner(); //밑에 식으로 두줄 합칠수 있다.
		Outer.Inner oi=new Outer().new Inner();
		System.out.println("oi.c: "+oi.c);
		oi.foo();
		//3. Outer.SInner클래스의 d,e 값 출력, bar(), baz()호출
		System.out.println("Outer.SInner.e: "+Outer.SInner.e);
		Outer.SInner.baz();
		
		Outer.SInner os = new Outer.SInner();//스태틱이니까 클래스가 같이 가야한다 그래서 새로 지정
		System.out.println("os.d: "+os.d);
		os.bar();
	}

}
