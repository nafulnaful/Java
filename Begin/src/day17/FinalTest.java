package day17;

abstract class Super{
	void foo() {
		System.out.println("Super's foo()");
	}
	abstract void bar();//�߻�޼ҵ� : ������ ����
	final void baz() {//final + �޼ҵ� : ������ ����
		System.out.println("Super's baz()");
	}
}///////////////////////////

//final + class : ��ӹ��� ���ϵ��� �����.
final class Sub extends Super{
	//bar()�������̵��ϱ�
	public void bar() {
		System.out.println("Sub's bar()");
	}
	/*public void baz() {
		
	}[x]*/
}/////////////////

class Sub2 //extends Sub
{
	int x=10;//�ν��Ͻ� ����
	public static final int Y=20;//��� Ŭ��������
	//final + ���� : �� �Ҵ� ����
	
}/////////////////////////

public class FinalTest {

	public static void main(String[] args) {
		//Sub2�� x�� ����ϱ�
		// 		Y�� ���
		Sub2 s=new Sub2();
		System.out.println("s.x: "+s.x);
		
		System.out.println("Sub2.Y:"+Sub2.Y);
		
		s.x=100;
		System.out.println("s.x: "+s.x);
		//Sub2.Y=200; [x] ����̱� ������ ���� �Ұ�
		
		Sub sb=new Sub();
		sb.bar();
		sb.foo();
		sb.baz();
		
	}

}/////////////////////////////////
