package day02;

public class DataType3 
{
	public static void main(String[] args) 
	{
		System.out.println("2. �Ǽ���---------------");
		//float (4) < double (8)
		//float: �����е�, �Ҽ��� ���� 7�ڸ�
		//double: �����е�, �Ҽ��� ���� 15~16�ڸ� (����Ʈ)
		float f1=1.234f;
		System.out.println(f1);
		//float���� �ε��Ҽ����� ��� �ݵ�� ���̻� F�� �ٿ��� �Ѵ�.
		//�׷��� ������ double�� �ν��Ѵ�.
		float f2=-32;//���θ�� : ����Ÿ���� ūŸ������ �ٲ�°�
		System.out.println(f2);
		float f3=0123;
		System.out.println("f3="+f3);

		float f4=.454f;
		System.out.println("f4="+f4);

		float f5=789e-2f;//789*10^-2//double ������ ����(e)�� ����ϸ� ������ double�� ������.
		System.out.println("f5="+f5);

		float f6=789e+2f;
		System.out.println("f6="+f6);

		double d1=753.123;//�Ǽ����� default
		double d2=1.234d;
		double d3=0.45E-7;
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);

		System.out.println("3. ������ ---------");
		//char (2byte) : 0 ~ 2^16 -1 (0 ~ 65535) ��� ������ ��� ǥ�� ����
		//				�����ڵ� ü�踦 ����Ѵ�.
		char c1='A';//������(primitive type)
//		char c2='AB';[x]
		String str="AB";//���ڿ�(reference type)
		char c2='ʫ';
		char c3='\uff57';//�����ڵ�
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		System.out.println("str="+str);
		System.out.println(c1+1);//66
		//char������ ���꿡 ����� �Ǹ� �ڵ����� int������ ����ȯ�� �Ͼ��.(promotion)


		System.out.println("4. ���� ---------");
		//boolean(1) : true, false���� ���´�. �ҹ��ڷ� �ؾ� ��
		//				�ڹ��� ������ 0�̳� 1�� ȣȯ���� �ʴ´�.
		boolean bool=true;
		boolean bool2=2<1;
		System.out.println("bool="+bool);
		System.out.println("bool2="+bool2);
	}
}
