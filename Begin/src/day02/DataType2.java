package day02;

public class DataType2
{
	public static void main(String[] args)
	{
		System.out.println("1. 정수형----------------");
		//byte (1) < short (2) < int (4) < long (8)
		byte b1=-128;//byte의 범위는 -128~127값
		byte b2=127;
		System.out.println(b1);
		System.out.println(b2);

		short s1=128;//short범위: -2^15 ~ 2^15-1
		short s2=-4545;
		System.out.println(s1);
		System.out.println(s2);

		int i=45454;
		System.out.println("i="+i);

		long ln=80;
		long ln2=80l;//접미사 l을 붙인다.
		System.out.println("ln="+ln);
		System.out.println("ln="+ln2);

		int x=1000000000;//0이 9개
		long y=10000000000L;//0이 10개
		System.out.println("x="+x);
		System.out.println("y="+y);

		int m=017;//8진수[0~7] (0을 접두어로 붙인다.)
		//0 1 7 1=8^1 7=8^0자리 //0117=79
		System.out.println("m="+m);
		
		//16진수(0~9,a,b,c,d,e,f)
		//0x를 접두어로
		int n=0x1af;
		//16^2 16 1
		System.out.println("n="+n);

		//2진수는 0b를 접두어로 붙인다.
		int w=0x1101;
		//1 1 0 1 =>8 4 0 1 =13
		System.out.println("w="+w);
	}
}