package day03;

class UnaryOperator 
{
	public static void main(String[] args) 
	{
		System.out.println("1. ���� ������------------");
		/*
		[1] ++ : 1�� ������Ŵ
		[2] -- : 1�� ���ҽ�Ŵ
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
		System.out.println(c++);//c�� ������Ű�� ���� ����ع����� ++�� �� ����
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

		System.out.println("2.��ȣ ������-----");
		// +,-
		int m=-7;
		System.out.println(+m);
		System.out.println(-m);

	}
}