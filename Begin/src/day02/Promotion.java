package day02;

public class Promotion
{
	public static void main(String[] args)
	{
		/*promotion(�ڵ�����ȯ): ũ�Ⱑ ���� �������� ū �������� �ڵ����� ����ȯ�� �Ǵ� ���� �ǹ�
		  casting(��������ȯ): ũ�Ⱑ ū �������� ���� �������� ����ȯ�� �� ĳ���� ������()�� �̿��ؼ�
		  					���������� ����ȯ�ؾ� ��.
		  byte < short < int < long | < float < double
		  		 char <
		*/
		byte a=55;
		float b=a;//promotion
		System.out.println("a="+a);
		System.out.println("b="+b);

		int x=1;
		long y=2;
		float z=x+y;//int���Ϸδ� �Ұ��� �ּ�long
		System.out.println("z="+z);
		/*�ڹٴ� int������ �ڷ���(byte, short, char)�� ���꿡 ���Ǹ� �ڵ����� int������ ����ȯ*/

		byte b1=10;
		byte b2=20;
		//byte b3=b1+b2 [x]
		int b3=b1+b2;//�ּ��� int
		System.out.println("b3="+b3);
		
		char c1='A';//65
		char c2='B';//66
		//char c3=c1+c2;
		int c3=c1+c2;
		System.out.println("c3="+c3);
		
		//�ݵ�� byte�θ� �ۼ��� �ؾ��ϴ� ���=>���� ����ȯ�� �ǽ�=>(byte)(����ȯ�� ����)
		byte b4=(byte)(b1+b2);
		System.out.println("b4="+b4);
		System.out.println(c1+1);//66==>��������ȯ �غ���

		System.out.println((char)(c1+1));
			
	}

}