package day05;

class ForTest3 
{
	public static void main(String[] args) 
	{
		//중첩 for루프
		/*
			★★★★★
			★★★★★
			★★★★★
			
			3행5열
		*/
		for (int i=1;i<=3 ;i++ )//행의 조건
		{
				for (int k=1;k<=6 ;k++ )//열의 조건
				{
					System.out.print("★");
				}
				System.out.println();
		}
		System.out.println("--중첩 for루프문-----");
		//3행2열

		for (int i=1;i<4 ;i++ )
		{
			for (int k=1;k<3 ;k++ )
			{
				System.out.println("i"+i+", k="+k);
			}//System.out.println("_____________");
		}
		/*중첩 for루프를 이용해서 아래와 같이 출력하세요.
		[1] 5행 5열
			★
			★★
			★★★
			★★★★
			★★★★★

		 [2]
		 	*
		   **
		  ***
		 ****
		*****
		
		[3]
		*
	   ***
	  *****
	 *******

		*/

		for (int i=1;i<7 ;i++ )
		{
			for (int k=1;k<6 ;k++ )
			{
				if (i>k)
					System.out.print("★");
				else
					System.out.print(" ");	
			}
			System.out.println();
		}
		
		
		int sum=0;
		for (int i=1;i<6 ;i++ )
		{
			for (int k=1;k<6 ;k++ )
			{	sum=i+k;
				if (sum>5){
					System.out.print("*");}
				else{
					System.out.print(" ");
				}
			}System.out.println();
		}
	}
}
//11 12 13 14 15
//21 22 23 24 25
//31 32 33 34 35
//41 42 43 44 45
//51 52 53 54 55