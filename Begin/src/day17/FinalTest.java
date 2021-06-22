package day17;

abstract class Super{
	void foo() {
		System.out.println("Super's foo()");
	}
	abstract void bar();//추상메소드 : 재정의 가능
	final void baz() {//final + 메소드 : 재정의 못함
		System.out.println("Super's baz()");
	}
}///////////////////////////

//final + class : 상속받지 못하도록 만든다.
final class Sub extends Super{
	//bar()오버라이드하기
	public void bar() {
		System.out.println("Sub's bar()");
	}
	/*public void baz() {
		
	}[x]*/
}/////////////////

class Sub2 //extends Sub
{
	int x=10;//인스턴스 변수
	public static final int Y=20;//상수 클래스변수
	//final + 변수 : 값 할당 못함
	
}/////////////////////////

public class FinalTest {

	public static void main(String[] args) {
		//Sub2의 x값 출력하기
		// 		Y값 출력
		Sub2 s=new Sub2();
		System.out.println("s.x: "+s.x);
		
		System.out.println("Sub2.Y:"+Sub2.Y);
		
		s.x=100;
		System.out.println("s.x: "+s.x);
		//Sub2.Y=200; [x] 상수이기 때문에 변경 불가
		
		Sub sb=new Sub();
		sb.bar();
		sb.foo();
		sb.baz();
		
	}

}/////////////////////////////////
