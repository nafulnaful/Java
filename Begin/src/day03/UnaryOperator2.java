package day03;

class UnaryOperator2 
{
	public static void main(String[] args) 
	{
		System.out.println("3. ��Ʈ�� not������: (~)-------");
		//~ : ��Ʈ ����. 0�� 1, 1�� 0���� �ٲ۴�.
		int a=42;
		System.out.println("a="+a);
		System.out.println("a="+(~a));

	/*
		42 
		21 ...0
		10 ...1
		 5 ...0
		 2 ...1
		 1 ...0

 42:	00000000 00000000 00000000 00101010
~42:	11111111 11111111 11111111 11010101
	   -1*2^31 + 1*2^30 	        -1*2^6+2^4+2^2+1
	   								-64+16+4+1	
	[����1]
	*/
	int b=0xfffffff1;
	System.out.println("b="+b);
	System.out.println("~b="+(~b));

	/* 15
		7...1
		3...1
		1...1

		1111 1111 1111 1111 1111 1111 1111 0001
		0000 0000 0000 0000 0000 0000 0000 1110

	
	*/
	System.out.println("4. ������ ������: (!)----");
	//�����̳� ���� �տ� ���ȴ�. true�� false��, false�� true�� �ٲ۴�.
	boolean c=true;
	System.out.println(c);
	System.out.println(!c);
	System.out.println(2<1);
	System.out.println(!(2<1));

	int m=5;
	double n=5.1;
	// == : �⺻�ڷ����� ���� ���� �������� ����
	// != :      "        ���� ���� �ٸ��� true�� ��ȯ, ������ false
	System.out.println(m==n);
	System.out.println(m!=n);

	}
}
