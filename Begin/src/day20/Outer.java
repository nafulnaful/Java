package day20;

public class Outer {//outer안에 inner가 있는 상황
	int a=10;//인스턴스변수(non-static변수)
	static int b=20;//클래스변수(static변수)
	class Inner //Inner Member Class(non-static)
	{
		int c=30;//static붙일 수 없다.
		
		void foo() {
			System.out.println("foo()###");
		}
		
		
	}/////////
	
	static class SInner//Inner Member Class (static)
	{
		int d=40;//넌스태틱
		static int e=50;//스태틱
		void bar() {//매소드 다 받을 수 있다
			System.out.println("bar()###");
		}
		static void baz() {//스태틱인 매소드도 받음
			System.out.println("baz()@@@");
		}
	}
	
}///////////////////
