package day09;
/*Ŭ���� ���
 * [1] ������(constructor) : ��ü�� ������ �� ȣ��Ǵ� ������ �޼ҵ�
 * 	-�����ϴ� ���
 * 		- 1) ������ �̸��� Ŭ���� �̸��� �����ؾ� �Ѵ�.
 * 		- 2) ��ȯŸ���� ������� �ʴ´�.
 *		- 3) ����:�������(�ν��Ͻ�����)���� �ʱⰪ�� �ο��Ѵ�.
 *	-����ϴ� ���
 *		Ŭ������ ���������� = new �����ڸ�(); ==> ��ü�� ������ �� ȣ����
 *
 * [2] ��� ����
 * [3] ��� �޼ҵ�
 * */

public class MyDemo {
	int b;//�������(�ν��Ͻ� ����) variable, field, property
	static double c;//�������(Ŭ���� ����)
	
	static {
		c=500;//static�������� static�� �ȿ��� �ʱ�ȭ�� �Ѵ�.
	}//static initializer
	public MyDemo() {//default constructor(�⺻������)
		System.out.println("MyDemo()������...");
		b=100;
		
	
	}
	
	
	public static void main(String[] args) {
		int a=0;//��������(local variable, automatic field)
		MyDemo md = new MyDemo(); //��ü ����
		MyDemo md2 = new MyDemo();
		MyDemo md3 = new MyDemo();
		//�ν��Ͻ�����=> "��ü��.����" ������ �����ؾ� �Ѵ�.
		System.out.println("md.b="+md.b);
		System.out.println("md.2b="+md2.b);
		System.out.println("md.3b="+md3.b);
		md.b=300;
		md3.b=5000;
		System.out.println("---------------------");
		System.out.println("md.b="+md.b);
		System.out.println("md.2b="+md2.b);
		System.out.println("md.3b="+md3.b);
		
		System.out.println("c="+c);//���� x
		//static����"Ŭ������.����"������ �����Ѵ�.
		System.out.println("MyDemo.c="+MyDemo.c);
		
	}

}
