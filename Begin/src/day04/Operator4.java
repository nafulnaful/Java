package day04;

class Operator4 
{
	public static void main(String[] args) 
	{
		System.out.println("6. ���� ������(���� ������)-----------");
		/*
			���� ���� = (���ǽ�)? ��1: ��2;
			���ǽ��� true�̸� ������ ��1�� �����ϰ�
				  false�̸� ������ ��2�� �����Ѵ�.
			�̶� ����. ����� ������ ��1, ��2�� ���� �ڷ����̾�� �Ѵ�.
		*/
		int a=50, b=60;
		int c=(a>b)? a:b;
		System.out.println("c: "+c);

		String s=(a>b)?a+"":b+"";
		System.out.println("s: "+s);

		System.out.println("7. �Ҵ� ������ (������ ���Կ�����)-----------");
		int i=3;
		i+=2; //i=i+2
		System.out.println("i="+i);
		
		int j=9;
		j-=4;//j=j-4;
		System.out.println("j="+j);
		
		int k=7;
		k*=8; //k =k*8;
		System.out.println("k="+k);
		
		k/=3; //k =k/3;
		System.out.println("k="+k);

		k%=3; //k =k%3
		System.out.println("k="+k);

		int x=3; //0011
		x^=2;	 //0010
		// x = x^2
		System.out.println("x="+x);//1

		int y=5; //00000101
		y<<=1; //10
		System.out.println("y="+y);



	}
}
