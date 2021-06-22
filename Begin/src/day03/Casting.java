package day03;

public class Casting
{
	public static void main(String[] args) 
	{
		byte b=127;//-128~127
		System.out.println("b="+b);

		byte b2=(byte)128;//강제 형변환 (casting)=> 데이터 손실이 발생할 수 있음
		//큰 자료유형의 값을 작은 자료유형으로 변환하고자 할 때 사용
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
		//char로 형변환해서 출력해보기
		char c=(char)a;
		System.out.println(a);
		System.out.println(c);

		double p=3.14;
		//int타입으로 형변환후 출력하기
		int w=(int)p;
		System.out.println("p="+p);
		System.out.println("w="+w);

		//promotion : 큰자료형으로 자동으로 형변환이 일어남(묵시적 형변환)
		//int 이하의 자료형은 연산하면 int형으로 형변환된다.
		short s=10;
		byte s2=2;
		int s3=s*s2;//short로 받으면 안됨
		System.out.println(s3);
	}
}
