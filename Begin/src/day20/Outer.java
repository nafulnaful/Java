package day20;

public class Outer {//outer�ȿ� inner�� �ִ� ��Ȳ
	int a=10;//�ν��Ͻ�����(non-static����)
	static int b=20;//Ŭ��������(static����)
	class Inner //Inner Member Class(non-static)
	{
		int c=30;//static���� �� ����.
		
		void foo() {
			System.out.println("foo()###");
		}
		
		
	}/////////
	
	static class SInner//Inner Member Class (static)
	{
		int d=40;//�ͽ���ƽ
		static int e=50;//����ƽ
		void bar() {//�żҵ� �� ���� �� �ִ�
			System.out.println("bar()###");
		}
		static void baz() {//����ƽ�� �żҵ嵵 ����
			System.out.println("baz()@@@");
		}
	}
	
}///////////////////
