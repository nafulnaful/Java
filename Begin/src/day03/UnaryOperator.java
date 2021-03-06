package day03;

class UnaryOperator 
{
	public static void main(String[] args) 
	{
		System.out.println("1. 증감 연산자------------");
		/*
		[1] ++ : 1씩 증가시킴
		[2] -- : 1씩 감소시킴
		*/
		int a=3;
		long b=7;
		a++;// a=a+1
		b--;// b=b+1
		System.out.println(a);//4
		System.out.println(b);//6
		++a;
		--b;
		System.out.println(a);//5
		System.out.println(b);//5

		float c=8.7f;
		double d=5.4;
		System.out.println(c++);//c를 증가시키기 전에 출력해버려서 ++이 안 붙음
		System.out.println("c="+c);
		System.out.println(--d);
		System.out.println("d="+d);

		int x=10;
		int y=x++;
		System.out.println("x: "+x);//11
		System.out.println("y: "+y);//10

		x=10;
		int z=++x;

		System.out.println("x: "+x);//11
		System.out.println("z: "+z);//11

		System.out.println("2.부호 연산자-----");
		// +,-
		int m=-7;
		System.out.println(+m);
		System.out.println(-m);

	}
}
