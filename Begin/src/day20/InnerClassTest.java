package day20;
import day20.Outer;

public class InnerClassTest {

	public static void main(String[] args) {
		//1. OuterŬ������ a,b �������� ����ϼ���
		System.out.println("Outer.b: "+Outer.b);
		
		Outer o1=new Outer();
		System.out.println("o1.a: "+o1.a);
		//2. Outer.Inner Ŭ������ c������ ����ϱ�, foo()ȣ���ϱ�
		//Outer o2=new Outer();
		//Outer.Inner oi=o2.new Inner(); //�ؿ� ������ ���� ��ĥ�� �ִ�.
		Outer.Inner oi=new Outer().new Inner();
		System.out.println("oi.c: "+oi.c);
		oi.foo();
		//3. Outer.SInnerŬ������ d,e �� ���, bar(), baz()ȣ��
		System.out.println("Outer.SInner.e: "+Outer.SInner.e);
		Outer.SInner.baz();
		
		Outer.SInner os = new Outer.SInner();//����ƽ�̴ϱ� Ŭ������ ���� �����Ѵ� �׷��� ���� ����
		System.out.println("os.d: "+os.d);
		os.bar();
	}

}
