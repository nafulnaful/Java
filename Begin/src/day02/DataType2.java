package day02;

public class DataType2
{
	public static void main(String[] args)
	{
		System.out.println("1. ������----------------");
		//byte (1) < short (2) < int (4) < long (8)
		byte b1=-128;//byte�� ������ -128~127��
		byte b2=127;
		System.out.println(b1);
		System.out.println(b2);

		short s1=128;//short����: -2^15 ~ 2^15-1
		short s2=-4545;
		System.out.println(s1);
		System.out.println(s2);

		int i=45454;
		System.out.println("i="+i);

		long ln=80;
		long ln2=80l;//���̻� l�� ���δ�.
		System.out.println("ln="+ln);
		System.out.println("ln="+ln2);

		int x=1000000000;//0�� 9��
		long y=10000000000L;//0�� 10��
		System.out.println("x="+x);
		System.out.println("y="+y);

		int m=017;//8����[0~7] (0�� ���ξ�� ���δ�.)
		//0 1 7 1=8^1 7=8^0�ڸ� //0117=79
		System.out.println("m="+m);
		
		//16����(0~9,a,b,c,d,e,f)
		//0x�� ���ξ��
		int n=0x1af;
		//16^2 16 1
		System.out.println("n="+n);

		//2������ 0b�� ���ξ�� ���δ�.
		int w=0x1101;
		//1 1 0 1 =>8 4 0 1 =13
		System.out.println("w="+w);
	}
}