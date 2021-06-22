package day04;

public class  Operator3
{
	public static void main(String[] args) 
	{
		System.out.println("4. 비트 연산자-----------");
		/* 정수형에만 사용되는 연산자, 비트로 바꾸어 연산을 한다.
		1) & (and연산자) : 두 비트가 1일 때만 1. 나머지는 0
		2) | (or연산자)  : 두 비트가 하나라도 1이면 1. 모두 0이면 0
		3) ^ (xor연산자) : 두 비트가 서로 다르면 1. 서로 같으면 0
		*/
		int x=3; //0011
		int y=5; //0101
		System.out.println("x & y :"+(x&y));//0001 : 1
		System.out.println("x | y :"+(x|y));//0111 : 7
		System.out.println("x ^ y :"+(x^y));//0110 : 6

		System.out.println("5. 논리 연산자-----------");
		/* &, |, &&, ||
		논리식이나 논리값에 사용되는 연산자
		*/
		/*
			T & T == T
			T & F == F
			F & T == F
			F & F == F

			T | T == T
			T | F == T
			F | T == T
			F | F == F

			1) &
			2) |
			 : &, | 연산자를 사용하면 앞의 연산으로 결과를 알 수 있어도
			 		뒤의 문장까지 비교한다.
			3) &&
			4) ||
			 : 앞의 연산으로 결과를 알 수 있을 경우, 뒤의 연산은 수행하지 않는다.
			   예를 들어 &&의 경우 앞의 연산결과가 false이면 뒤의 연산을 생략한다.
			   		  ||의 경우는 앞의 연산결과가 true이면 뒤의 연산을 생략한다.
		*/
		int i=1;
		int j=i++; //j: 1, i: 2

		if ( (i>++j) && (i++ ==j)){
			i= i+j;
		}
		System.out.println("i: "+i);

		//문제2
		int k=0;
		int p=1;

		if ((k++ ==0) | (p++ ==2)){
			k=42;//|,  || 비교
		}
		System.out.println("k="+k+", p="+p);

		//문제3
		boolean r=false;
		boolean e=false;
		boolean w=((r=true) | (e=true));//=이건 등가연산자가 아님 ==이게 등가연산자
		System.out.println("r= "+r+", e="+e+", w="+w);

		{
		}


	}
}
