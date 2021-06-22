package day03;

public class Casting
{
	public static void main(String[] args) 
	{
		byte b=127;//-128~127
		System.out.println("b="+b);

		byte b2=(byte)128;//���� ����ȯ (casting)=> ������ �ս��� �߻��� �� ����
		//ū �ڷ������� ���� ���� �ڷ��������� ��ȯ�ϰ��� �� �� ���
		System.out.println("b2="+b2);

		int i=100;
		byte b3=(byte)i;
		System.out.println("b3="+b3);
		/*
				128
				 64 ...0
				 32	...0
				 16 ...0
				  8 ...0
				  4 ...0
				  2 ...0
				  1 ...0

128: 00000000 00000000 00000000 10000000

				100 ...0
				 50 ...0
				 25 ...0
				 12 ...1
				  6 ...0
				  3 ...0
				  1 ...1

100:	00000000 00000000 00000000 01100100
		
		*/
		int a=90;
		//char�� ����ȯ�ؼ� ����غ���
		char c=(char)a;
		System.out.println(a);
		System.out.println(c);

		double p=3.14;
		//intŸ������ ����ȯ�� ����ϱ�
		int w=(int)p;
		System.out.println("p="+p);
		System.out.println("w="+w);

		//promotion : ū�ڷ������� �ڵ����� ����ȯ�� �Ͼ(������ ����ȯ)
		//int ������ �ڷ����� �����ϸ� int������ ����ȯ�ȴ�.
		short s=10;
		byte s2=2;
		int s3=s*s2;//short�� ������ �ȵ�
		System.out.println(s3);
	}
}
