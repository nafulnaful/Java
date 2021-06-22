package day05;
class ForTest2 
{
	public static void main(String[] args) 
	{
		//[1] for루프 이용해서 "★"을 붙여서 10개 출력하기
		//★★★★★★★★★★


		for (int i=1;i<11 ;i++ )
		{
			System.out.print("★");
		}
		System.out.println();
		
		
		
		/*[2]1부터 10까지의 합을 구해 출력하기 -for루프 이용해서
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


		/*[3]1부터 10까지의 곱을 구해  출력하기 -for루프 이용해서
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

		
		
		
		//[4] 1~ 100까지의 수 중 17로 나누어 떨어지는 수만 출력하세요.
		for (int b=1;b<101 ;b++ )
		{
			if(b%17==0)
				System.out.print(b+",");
		}
		System.out.println();
		
		
		
		
		//[5] for루프를 이용해서 알파벳 대문자만 출력하세요
		
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
		
		
		
		//[6] 구구단 7단식을 for루프 이용해 출력하세요.
		

		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("구구단의 몇단을 할까요?");
		int dan=sc.nextInt();
		System.out.println("****"+dan+"단****");
		for (int i=1;i<10 ;i++ )
		{
			System.out.println(dan+"x"+i+"="+(dan*i));
		}
	}


}

