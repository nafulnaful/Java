package day03;

class Operator 
{
	public static void main(String[] args) 
	{
		System.out.println("1. ���������--------------");
		//+,-,*,/,%(���������� ���ϴ� ������)
		int a=10;
		System.out.println(a*4);//40
		System.out.println(a/4);//2(int/int=int)
		System.out.println(a%3);//1
		/*Shift������
		[1] << : �������� ��Ʈ����ŭ �̵��Ѵ�. �����ʿ� ���� ��ĭ�� 0���� ä���.
		[2] >> : ���������� ��Ʈ����ŭ �̵�. ���ʿ� ���� ��ĭ�� ��ȣ��Ʈ�� ä���.
		[3] >>>: ���������� ��Ʈ����ŭ �̵�. ���ʿ� ���� ��ĭ�� ������ 0���� ä���.
		
		42:   00000000 00000000 00000000 00101010
	 42<<3:   00000 00000000 00000000 00101010000
	 42>>3:   000 00000000 00000000 00000000 00101
	 42<<3:
		*/
		System.out.println("42<<3: "+(42<<3));//336
		System.out.println("42>>3: "+(42>>3));//5
		System.out.println("42>>>3: "+(42>>>3));//5
		/*
		-14
		[1] ���(14)�� ���� ��Ʈ�� ��Ÿ����, �׷� �ڿ� 1�� ������ ���Ѵ�.
		[2] 1�� �������� +1�� �Ѵ�=> 2�� ����

		14
		 7...0
		 3...1
		 1...1

14:		 00000000 00000000 00000000 00001110
		 11111111 11111111 11111111 11110001 <=1�� ����(��Ʈ����)
		 								  +1 <=2�� ����
		--------------------------------------
-14:		 11111111 11111111 11111111 11110010

tip) [1] ���� ������� ��Ʈ�� ���Ѵ�.
	 [2] ������� ���� ��Ʈ���� ù ��° 1�� ������������ ����� �����ϰ� ����.
	 	 ù��° 1�� ���� ������Ʈ�� ��Ʈ������ �Ѵ�.

-8:		11111111 11111111 11111111 11111000 
11100011
		*/
		System.out.println("-8<<2: "+(-8<<2));//-32
		System.out.println("-8>>2: "+(-8>>2));//-2
		System.out.println("-8>>>2: "+(-8>>>2));//00111111 111111111 11111111 111110
		
	}
}