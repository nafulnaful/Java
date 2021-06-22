package day03;

class UnaryOperator2 
{
	public static void main(String[] args) 
	{
		System.out.println("3. 비트별 not연산자: (~)-------");
		//~ : 비트 반전. 0은 1, 1은 0으로 바꾼다.
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
	[문제1]
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
	System.out.println("4. 논리부정 연산자: (!)----");
	//논리값이나 논리식 앞에 사용된다. true를 false로, false를 true로 바꾼다.
	boolean c=true;
	System.out.println(c);
	System.out.println(!c);
	System.out.println(2<1);
	System.out.println(!(2<1));

	int m=5;
	double n=5.1;
	// == : 기본자료형일 때는 값이 같은지를 비교함
	// != :      "        값이 서로 다르면 true를 반환, 같으면 false
	System.out.println(m==n);
	System.out.println(m!=n);

	}
}
