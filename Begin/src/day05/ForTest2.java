package day05;
class ForTest2 
{
	public static void main(String[] args) 
	{
		//[1] for���� �̿��ؼ� "��"�� �ٿ��� 10�� ����ϱ�
		//�ڡڡڡڡڡڡڡڡڡ�


		for (int i=1;i<11 ;i++ )
		{
			System.out.print("��");
		}
		System.out.println();
		
		
		
		/*[2]1���� 10������ ���� ���� ����ϱ� -for���� �̿��ؼ�
		1+2+3+4+ ... +10
		*/
		
		int sum=0;
		for (int a=1;a<=10 ;a++ )
		{
			//sum = sum +a;
			if (a<10)
				System.out.print(a+"+");
			else
				System.out.print(a+"=");
			sum +=a;
		}
		System.out.print(sum);
		System.out.println();


		/*[3]1���� 10������ ���� ����  ����ϱ� -for���� �̿��ؼ�
		1*2*3*4*5*6*7*8*9*10
		*/
		int gop=1;
		for (int i=1;i<11 ;i++ )
		{	
			System.out.print((i<10)? i+"x":i+"=");
			gop *=i;
		}
		System.out.print(gop);
		System.out.println();

		
		
		
		//[4] 1~ 100������ �� �� 17�� ������ �������� ���� ����ϼ���.
		for (int b=1;b<101 ;b++ )
		{
			if(b%17==0)
				System.out.print(b+",");
		}
		System.out.println();
		
		
		
		
		//[5] for������ �̿��ؼ� ���ĺ� �빮�ڸ� ����ϼ���
		
		for (int c=65;c<=90 ;c++ )
		{
			System.out.print((char)c+" ");
		}
		System.out.println();

		for (char c='A';c<='Z' ;c++ )
		{
			System.out.print(c+" ");
		}
		System.out.println();
		
		
		
		//[6] ������ 7�ܽ��� for���� �̿��� ����ϼ���.
		

		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("�������� ����� �ұ��?");
		int dan=sc.nextInt();
		System.out.println("****"+dan+"��****");
		for (int i=1;i<10 ;i++ )
		{
			System.out.println(dan+"x"+i+"="+(dan*i));
		}
	}


}

