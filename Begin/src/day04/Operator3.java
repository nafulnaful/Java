package day04;

public class  Operator3
{
	public static void main(String[] args) 
	{
		System.out.println("4. ��Ʈ ������-----------");
		/* ���������� ���Ǵ� ������, ��Ʈ�� �ٲپ� ������ �Ѵ�.
		1) & (and������) : �� ��Ʈ�� 1�� ���� 1. �������� 0
		2) | (or������)  : �� ��Ʈ�� �ϳ��� 1�̸� 1. ��� 0�̸� 0
		3) ^ (xor������) : �� ��Ʈ�� ���� �ٸ��� 1. ���� ������ 0
		*/
		int x=3; //0011
		int y=5; //0101
		System.out.println("x & y :"+(x&y));//0001 : 1
		System.out.println("x | y :"+(x|y));//0111 : 7
		System.out.println("x ^ y :"+(x^y));//0110 : 6

		System.out.println("5. �� ������-----------");
		/* &, |, &&, ||
		�����̳� ������ ���Ǵ� ������
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
			 : &, | �����ڸ� ����ϸ� ���� �������� ����� �� �� �־
			 		���� ������� ���Ѵ�.
			3) &&
			4) ||
			 : ���� �������� ����� �� �� ���� ���, ���� ������ �������� �ʴ´�.
			   ���� ��� &&�� ��� ���� �������� false�̸� ���� ������ �����Ѵ�.
			   		  ||�� ���� ���� �������� true�̸� ���� ������ �����Ѵ�.
		*/
		int i=1;
		int j=i++; //j: 1, i: 2

		if ( (i>++j) && (i++ ==j)){
			i= i+j;
		}
		System.out.println("i: "+i);

		//����2
		int k=0;
		int p=1;

		if ((k++ ==0) | (p++ ==2)){
			k=42;//|,  || ��
		}
		System.out.println("k="+k+", p="+p);

		//����3
		boolean r=false;
		boolean e=false;
		boolean w=((r=true) | (e=true));//=�̰� ������ڰ� �ƴ� ==�̰� �������
		System.out.println("r= "+r+", e="+e+", w="+w);

		{
		}


	}
}
